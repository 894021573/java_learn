package 设计模式.命令模式.command;

import 设计模式.命令模式.reveiver.Light;

public class LightOnCommandImpl implements Command
{
    Light light;

    public LightOnCommandImpl(Light light)
    {
        this.light = light;
    }

    @Override
    public void execute()
    {
        this.light.on();
    }
}
