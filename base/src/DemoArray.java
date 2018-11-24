import java.lang.reflect.Array;
import java.util.Arrays;

public class DemoArray
{
    public static void main(String[] args)
    {
        // 一维数组
        int[] arr = {1, 2, 3, 4, 5, 6, 7};

        int[] arr2 = Arrays.copyOf(arr, 3);
        System.out.println(Arrays.toString(arr2));

        int[] arr3 = Arrays.copyOf(arr, arr.length * 2);
        System.out.println(Arrays.toString(arr3));

        int r = (int) (Math.random() * 10);
        System.out.println(r);

        int[] s = {4, 3, 6, 2, 3, 7, 6, 5};
        Arrays.sort(s);

        System.out.println(Arrays.toString(s));

        int find = Arrays.binarySearch(s, 5);
        System.out.println(find);

        Arrays.fill(s, 0);
        System.out.println(Arrays.toString(s));

        int[] a = {1, 2, 3};
        int[] b = {1, 2, 3};
        System.out.println(Arrays.equals(a, b));

        // 多维数组
        int[][] duo = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        for (int i = 0; i < duo.length; i++)
        {
            for (int j = 0; j < duo[i].length; j++)
            {
                System.out.println(duo[i][j]);
            }
        }

        System.out.println(Arrays.deepToString(duo));
    }
}
