package 设计模式.观察者模式.subject;

import 设计模式.观察者模式.observer.Observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserSubjectImpl implements Subject
{
    private int id;
    private String name;
    private int score;

    private List<Observer> observers = new ArrayList();

    @Override
    public void registerObserver(Observer observer)
    {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer)
    {
        observers.remove(observer);
    }

    @Override
    public void noticeObserver()
    {
        for(int i = 0;i < observers.size();i++)
        {
            Observer observer = observers.get(i);
            observer.update(this);
        }
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getScore()
    {
        return score;
    }

    public void setScore(int score)
    {
        this.score = score;
    }
}
