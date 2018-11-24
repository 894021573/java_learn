import java.lang.reflect.Constructor;

public class DemoSwitchEnum
{
    public static void main(String[] args)
    {
        for (Enum e : Color.values())
        {
            System.out.println(e.toString());
        }

        Color c = Color.RED;
        switch (c)
        {
            case RED:
                break;
            case BLUE:
                break;
        }

        System.out.println();
    }
}
