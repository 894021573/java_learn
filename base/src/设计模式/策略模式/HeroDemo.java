package 设计模式.策略模式;

import 设计模式.策略模式.skills.control.BingDongImpl;
import 设计模式.策略模式.skills.damage.HuoGongImpl;
import 设计模式.策略模式.skills.help.JiaSuImpl;
import 设计模式.策略模式.skills.help.JiaXueImpl;
import 设计模式.策略模式.skills.hero.Hero;
import 设计模式.策略模式.skills.hero.HeroA;
import 设计模式.策略模式.skills.hero.HeroB;

public class HeroDemo
{
    public static void main(String[] args)
    {
        Hero heroA = new HeroA();
        heroA.setControl(new BingDongImpl());
        heroA.setHelp(new JiaSuImpl());
        heroA.performControl();
        heroA.performHelp();

        Hero heroB = new HeroB();
        heroB.setDamage(new HuoGongImpl());
        heroB.setHelp(new JiaXueImpl());
        heroB.performDamage();
        heroB.performHelp();
    }
}