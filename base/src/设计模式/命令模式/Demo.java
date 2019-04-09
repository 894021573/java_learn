package 设计模式.命令模式;

import 设计模式.命令模式.command.Command;
import 设计模式.命令模式.command.LightOnCommandImpl;
import 设计模式.命令模式.control.Control;
import 设计模式.命令模式.reveiver.GreenLightImpl;
import 设计模式.命令模式.reveiver.Light;
import 设计模式.命令模式.reveiver.RedLightImpl;

public class Demo
{
    public static void main(String[] args)
    {
        // 请求者
        Control control = new Control();

        // 设置请求命令
        Light redLight = new RedLightImpl(); // 命令接收者
        Command lightOnCommand1 = new LightOnCommandImpl(redLight); // 把接收者传入命令对象
        control.setCommand(lightOnCommand1);

        // 发起请求
        control.pressButton();

        // 再来一次
        Light greenLight = new GreenLightImpl();
        Command lightOnCommand2 = new LightOnCommandImpl(greenLight);
        control.setCommand(lightOnCommand2);
        control.pressButton();

    }
}
