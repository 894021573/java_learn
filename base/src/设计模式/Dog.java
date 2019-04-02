package 设计模式;

class Dog implements Observer
{
    private String food;
    private String toy;

    public void update(String food, String toy)
    {
        this.food = food;
        this.toy = toy;
    }

    public void display()
    {
        System.out.println("dog eat + " + this.food + ";" + "play" + this.toy);
    }
}
