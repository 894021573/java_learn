package cn.设计模式.策略模式.skills.hero;

import cn.设计模式.策略模式.skills.control.Control;
import cn.设计模式.策略模式.skills.damage.Damage;
import cn.设计模式.策略模式.skills.help.Help;

public class Hero
{
    public String name;

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

    public void display()
    {
        System.out.println(this.name);

        if(control != null){
            control.perform();
        }

        if(damage != null){
            damage.perform();
        }

        if(help != null){
            help.perform();
        }
    }
}
