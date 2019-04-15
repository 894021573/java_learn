package 泛型;

public class Demo2
{
    public static void main(String[] args)
    {

    }
}

// 泛型接口
interface User<T>
{

}

//class QQUser implements User<T> 不能这样写,会报错
class QQUser<T> implements User<T>
{
    public T getObj()
    {
        return null;
    }
}

//class WeixinUser<Hello> implements User<Hello> 不能这样写,会报错
class WeixinUser implements User<Hello>
{
    public Hello getObj()
    {
        return new Hello();
    }
}

class Hello
{

}