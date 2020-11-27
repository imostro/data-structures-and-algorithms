package algorithms.classical.sort;

import static common.CommonUtils.less;

/**
 * 归并排序
 *
 * 分治思想
 *
 * 比较次数：C(N/2) + C(N/2) + N/2 <= C(N) ≤ C(N/2) + C(N/2) + N
 * 时间复杂度：O（NlgN）
 *
 *  因为递归会使小规模问题中方法的调用过于频繁，所以改进对它们的处理方法就能改进整个算法。
 *  使用插入排序处理小规模的子数组（比如长度小于 15）一般可以将归并排序的运行时间缩短 10% ～ 15%
 *
 * @Author: Gray
 * @date 2020/10/28 23:26
 */
public class MergeSort {

    static Comparable[] buffered;


    /**
     * 自顶而下解法
     * 先把大的数组分成不可再分的然后再合并
     */
    public static void sort(Comparable[] arr){
       buffered = new Comparable[arr.length];
       sort(arr,0,arr.length-1);
    }

    /**
     * 自底而上的一种解法
     * 通过先合并微小数组，然后不断2倍扩大完成合并过程
     *
     * 自底向上的归并排序比较适合用链表组织的数据。想象一下将链表先按大小为 1 的子链表进行
     * 排序，然后是大小为 2 的子链表，然后是大小为 4 的子链表等。这种方法只需要重新组织链表链接
     * 就能将链表原地排序（不需要创建任何新的链表结点）。
     */
    public static void sortBU(Comparable[] arr){
        int N = arr.length;
        buffered = new Comparable[arr.length];

        for (int sz = 1; sz < N; sz <<=1 ){ // 1 2 4 8  2倍递增，直到覆盖整个数组为止
            for (int lo = 0; lo < N - sz; lo += sz+sz){
                merge(arr,lo, lo+sz-1, Math.min(lo+sz+sz-1,  N-1));
            }
        }
    }

    public static void sort(Comparable[] arr, int lo, int hi){      // 设为C(N)
        if (lo >= hi)   return;
        int mid = lo + (hi - lo)/2;
        sort(arr, lo, mid);             // 每次递归减为设为C(N/2)
        sort(arr, mid+1, hi);       // 每次递归减为设为C(N/2)
        merge(arr, lo, mid, hi);
    }

    /**
     * 合并两个数组 需要借助辅助数组来完成
     *
     * @param arr 排序数组
     * @param lo 低位索引
     * @param mid 分割索引
     * @param hi 高位索引
     */
    public static void merge(Comparable[] arr, int lo, int mid, int hi){
        int i = lo, j = mid+1;

        for (int k=0; k<= hi; k++){
            buffered[k] = arr[k];
        }

        // 最少比较N/2次， 最多比较N次
        for (int k=lo; k<=hi; k++){
            if (i > mid)    arr[k] = buffered[j++];
            else if (j > hi) arr[k] = buffered[i++];
            else if (less(buffered[i], buffered[j]))  arr[k]  = buffered[i++];
            else arr[k] = buffered[j++];
        }
    }
}
