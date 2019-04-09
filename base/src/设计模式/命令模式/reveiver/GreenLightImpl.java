package 设计模式.命令模式.reveiver;

public class GreenLightImpl implements Light
{
    @Override
    public void on()
    {
        System.out.println("绿灯开");
    }

    @Override
    public void off()
    {
        System.out.println("绿灯关");
    }
}
