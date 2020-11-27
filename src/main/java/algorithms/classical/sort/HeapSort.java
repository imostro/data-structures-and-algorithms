package algorithms.classical.sort;

import static common.CommonUtils.randomArr;
import static common.CommonUtils.swap;

/**
 * 堆排序
 *
 * @Author: Gray
 * @date 2020/8/26 15:17
 */
public class HeapSort {

    /**
     * 堆排，通过不断的buildHeap过程来完成最值上移到树根，然后把最值交换到数组尾部，再进行下一轮排序
     * @param arr 排序数组
     */
    public static <T extends  Comparable<T>> void sort(T[] arr){
        int len = arr.length;
        for (int i = len-1; i > 0; i--) {
            buildHeap(arr, i+1);
            swap(arr, 0, i);
        }
    }

    /**
     * 建堆过程。可以他会从最低的非叶子节点开始，不断的heapify,最后保证树的最值在树根
     * @param arr 排序数组
     * @param len 数组可用长度
     */
    private static <T extends  Comparable<T>> void buildHeap(T[] arr, int len){
        // 求出倒数第一个非叶子节点索引
        int ep = len/2 - 1;
        for (int i = ep; i >= 0; i--) {
            heapify(arr, i,len);
        }
    }

    /**
     * heapify过程，可以通过递归的方式交换，把当前节点以及该节点的孩子节点的最值上移。
     * 可以说，传入一个数组，以及一个树节点索引，那么最后该索引返回的则是以该节点为根的树的最大值
     *
     * @param arr   需要排序的数组
     * @param start 起始索引
     * @param len  数组的可用长度
     */
    private static <T extends Comparable<T>> void heapify(T[] arr, int start, int len){
        // 通过根节点求它的孩子节点
        int p1 = start*2+1;
        int p2 = start*2+2;

        int mi = start;
        if (p1 < len && arr[p1].compareTo(arr[mi]) > 0){
            swap(arr, p1, mi);
            mi = p1;
        }

        if (p2 < len && arr[p2].compareTo(arr[mi]) > 0){
            swap(arr, p2, mi);
            mi = p2;
        }

        if (mi != start){
            heapify(arr, mi, len);
        }
    }

}
