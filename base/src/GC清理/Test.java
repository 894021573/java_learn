package GC清理;

public class Test
{
    public static void main(String[] args)
    {
        Book b = new Book(true);
        b.checnIn();
//
        new Book(true);
        System.gc();
    }
}

class Book
{
    boolean checkOut = false;

    Book(boolean checkOut)
    {
        this.checkOut = checkOut;
    }

    void checnIn()
    {
        checkOut = false;
    }

    protected void finalize()
    {
        if (checkOut) {
            System.out.println("error: checkout out");
        }
    }
}
