package cn.demo;

public class TestInnerStatic
{
    public static void main(String[] args)
    {
        Dark.Builder builder = new Dark.Builder(1, 2);
    }
}

class Dark
{
    private static int a;
    private static int b;

    public static class Builder
    {
        public Builder(int a, int b)
        {
            Dark.a = a;
            Dark.b = b;
        }

        public Dark build()
        {
            return new Dark();
        }
    }
}


