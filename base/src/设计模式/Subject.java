package 设计模式;

interface Subject
{
    void addObserver(Observer observer);

    void removeObserver(Observer observer);

    void noticeObserver();
}

