package cn.algorithm;

import java.util.Arrays;

public class QuickSort
{
    // 快速排序
    public static void main(String[] args)    {
        int[] arr = new int[]{3, 9, 2, 6, 5, 1, 8, 6, 5, 0};
        run(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void run(int[] arr, int start, int end)
    {
        if (start >= end) {

        } else {
            int base = arr[start]; // 标准数，取低位索引第一个

            int low = start; // 低位索引
            int high = end; // 高位索引

            while (low < high) {
                // 从高位索引开始
                while (low < high && arr[high] >= base) {
                    high--;
                }
                // 如果高位数小于标准数，交换
                int temp = arr[low];
                arr[low] = arr[high];
                arr[high] = temp;

                // 从低位索引开始
                while (low < high && arr[low] <= base) {
                    low++;
                }

                // 如果低位数大于标准数，交换
                temp = arr[high];
                arr[high] = arr[low];
                arr[low] = temp;
            }

            // 高位索引和低位索引重合，设置标准数
            arr[low] = base;

            // 递归，从开始索引到标准数索引位置
            run(arr, start, low);
            // 递归，从标准数索引位置+1,到结束索引
            run(arr, low + 1, end);
        }
    }
}
