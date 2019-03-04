package cn.algorithm;

import java.util.Arrays;

public class BubbleSort
{
    // 冒泡排序 两种方式
    public static void main(String[] args)
    {
//        int[] arr = new int[]{3, 9, 2, 6, 5, 1, 8, 6, 5, 0};
        int[] arr = new int[]{6, 3, 8, 2, 9, 1};
//        run1(arr);
        run2(arr);

        System.out.println(Arrays.toString(arr));
    }

    public static void run1(int[] arr)
    {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i; j < arr.length; j++) { // 一轮排完后，最左边为最小的，以此为基础继续排
                if (arr[i] > arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }

    public static void run2(int[] arr)
    {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) { // 一轮排完后，最边边为最大的，以此为基础继续排
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
