package 设计模式.命令模式.control;

import 设计模式.命令模式.command.Command;

// 命令请求者
public class Control
{
    Command command;
    public Control(){};

    // 请求哪条命令
    public void setCommand(Command command)
    {
        this.command = command;
    }

    // 请求执行命令
    public void pressButton()
    {
        this.command.execute();
    }
}
