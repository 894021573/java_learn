package 设计模式.命令模式.reveiver;

public class RedLightImpl implements Light
{
    @Override
    public void on()
    {
        System.out.println("红灯开");
    }

    @Override
    public void off()
    {
        System.out.println("红灯关");
    }
}
