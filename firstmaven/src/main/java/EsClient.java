import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;


public class EsClient
{
    public final static String HOST = "127.0.0.1";

    public final static int PORT = 9300;//http请求的端口是9200，客户端是9300


    public static void main(String[] args)
    {
        try {
            System.out.println(getClient());
            createIndex();
            query();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static TransportClient getClient() throws UnknownHostException
    {
        // cluster.name 和 ht-application 来自es配置文件
        Settings settings = Settings.builder().put("cluster.name", "ht-application").build();
        TransportClient client = new PreBuiltTransportClient(settings)
                .addTransportAddress(new TransportAddress(InetAddress.getByName(HOST), PORT));

       // client.close();
        return client;
    }

    public static void createIndex() throws IOException
    {
        IndexResponse response = getClient().prepareIndex("twitter", "_doc", "2")
                .setSource(jsonBuilder()
                        .startObject()
                        .field("user", "洪涛")
                        .field("postDate", new Date())
                        .field("message", "啦啦啦")
                        .endObject()
                ).get();
    }

    public static void query()
    {
        try {
            GetResponse response = getClient().prepareGet("twitter", "_doc", "2").execute().actionGet();
            System.out.println(response.getSourceAsString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}