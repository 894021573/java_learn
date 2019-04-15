package 泛型;

import java.util.ArrayList;
import java.util.List;

public class Demo4
{
    public static void main(String[] args)
    {
        List<String> list = new ArrayList<>();

        // 不能创建一个确定的包含泛型Arraylist的数组。因为泛型擦除后，不知道ArrayList中包含的类型
//        List<String>[] list1 = new ArrayList<String>[10];
        List<?>[] lists2 = new ArrayList<?>[10];

        lists2[0] = new ArrayList<>();
        lists2[1] = new ArrayList<>();
    }
}
