package algorithms.classical.sort;

import static common.CommonUtils.swap;

/**
 * 快速排序
 * 二分法思路
 *
 * @Author: Gray
 * @date 2020/10/28 22:14
 */
public class QuickSort {

    public static void sort(Comparable[] arr){
        sort(arr,0, arr.length-1);
    }

    /**
     * 递归分片
     */
    public static void sort(Comparable[] arr, int lo, int hi){
        if (lo >= hi) return;

        int mid = partition(arr, lo, hi);
        sort(arr, lo, mid-1);
        sort(arr, mid+1, hi);
    }

    /**
     * 分片算法
     * @param arr 数组
     * @param lo 低位
     * @param hi 高位
     * @return 分片索引位置
     */
    private static int partition(Comparable[] arr, int lo, int hi){
        int l = lo, r = hi+1;
        Comparable midVal = arr[lo];

        while (l < r){
            while (midVal.compareTo(arr[++l]) >= 0)     if (l == hi) break;
            while (midVal.compareTo(arr[--r]) < 0)  if (r == lo) break;;
            if (l >= r)    break;
            swap(arr, l, r);
        }
        swap(arr,r,lo);
        return r;
    }
}
