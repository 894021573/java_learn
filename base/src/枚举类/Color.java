package 枚举类;

enum Color
{
    RED("is red"), GREEN, GREY;

    private String msg;

    // 有几个枚举值，构造函数就会被调用几次。每个枚举值都是一个实例对象
    Color()
    {
        System.out.println("init enum");
    }

    // 被RED("is red") 使用
    Color(String msg)
    {
        this.msg = msg;
        System.out.println(this.name() + " " + msg);
    }

    public String getMsg()
    {
        return msg;
    }

    public static Color getColor(int i)
    {
        switch (i) {
            case 0:
                return Color.RED;
            case 1:
                return Color.GREEN;
            case 2:
                return Color.GREY;
            default:
                return Color.RED;
        }
    }
}
