import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;

public class ZookeeperTest
{
    private static ZooKeeper zooKeeper;

    public static void main(String[] args)
    {
        String ip = "47.98.208.33";

//        String connectString = ip + ":2181";
        String connectString1 = ip + ":1000";
        String connectString2 = ip + ":2000";
        String connectString3 = ip + ":3000";
        String connectString = connectString1 + "," + connectString2 + "," + connectString3;
        int sessionTimeout = 5000;

        Watcher watcher = new Watcher()
        {
            public void process(WatchedEvent watchedEvent)
            {

            }
        };

        // 链接
        try {
            //参数：(ip地址：端口号  ，当前会话超时时间，自定义事件监听器）
            zooKeeper = new ZooKeeper(connectString, sessionTimeout, watcher);
        } catch (IOException e) {
            e.printStackTrace();
        }

        ZooKeeper.States states = zooKeeper.getState();

        System.out.println("当前链接状态：" + states.toString());


        // 创建节点
        String s = null;
        try {
            s = zooKeeper.create("/m", "m-1".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("创建节点：" + s);

//        // 获取节点的值
//        byte[] bytes = new byte[0];
//        try {
//            bytes = zooKeeper.getData("/man5", new Watcher()
//            {
//                public void process(WatchedEvent event)
//                {
//                    System.out.println("检测值改变了");
//                }
//            }, new Stat());
//        } catch (KeeperException e) {
//            e.printStackTrace();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println("获取节点的值：" + new String(bytes));
//
//        // 持续获取修改节点的值
//        getData();
//
//        while (true) {
//            try {
//                Thread.sleep(5000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("loop");
//        }
    }

    public static void getData()
    {
        // 获取节点的值
        byte[] bytes = new byte[0];
        try {
            bytes = zooKeeper.getData("/man5", new Watcher()
            {
                public void process(WatchedEvent event)
                {
                    System.out.println("持续检测值改变了");
                    ZookeeperTest.getData();
                }
            }, new Stat());
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("获取持续修改的节点的值：" + new String(bytes));
    }
}
