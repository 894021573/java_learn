package cn.设计模式;

import java.util.ArrayList;
import java.util.List;

class Mobile
{
    private List<Observer> observers = new ArrayList();

    private String food;
    private String toy;

    public void addObserver(Observer observer)
    {
        observers.add(observer);
    }

    public void removeObserver(Observer observer)
    {
        observers.remove(observer);
    }

    public void noticeObserver()
    {
        for (int i = 0; i < observers.size(); i++)
        {
            observers.get(i).update(this.food, this.toy);
        }
    }

    public String getFood()
    {
        return food;
    }

    public void setFood(String food)
    {
        this.food = food;
    }

    public String getToy()
    {
        return toy;
    }

    public void setToy(String toy)
    {
        this.toy = toy;
    }
}
