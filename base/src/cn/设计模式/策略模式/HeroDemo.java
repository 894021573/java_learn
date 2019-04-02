package cn.设计模式.策略模式;

import cn.设计模式.策略模式.skills.control.BingDongImpl;
import cn.设计模式.策略模式.skills.help.JiaSuImpl;
import cn.设计模式.策略模式.skills.hero.Hero;
import cn.设计模式.策略模式.skills.hero.HeroA;

public class HeroDemo
{
    public static void main(String[] args)
    {
        Hero heroA = new HeroA();
        heroA.setControl(new BingDongImpl());
        heroA.setHelp(new JiaSuImpl());
        heroA.display();
    }
}