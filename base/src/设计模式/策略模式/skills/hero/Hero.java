package 设计模式.策略模式.skills.hero;

import 设计模式.策略模式.skills.control.Control;
import 设计模式.策略模式.skills.damage.Damage;
import 设计模式.策略模式.skills.help.Help;

public class Hero
{
    private Control control;
    private Damage damage;
    private Help help;

    public void setControl(Control control)
    {
        this.control = control;
    }

    public void setDamage(Damage damage)
    {
        this.damage = damage;
    }

    public void setHelp(Help help)
    {
        this.help = help;
    }

    public void performControl()
    {
        control.perform();
    }

    public void performDamage()
    {
        damage.perform();
    }

    public void performHelp()
    {
        help.perform();
    }
}
