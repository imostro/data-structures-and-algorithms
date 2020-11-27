package algorithms.classical.sort;

import static common.CommonUtils.less;
import static common.CommonUtils.swap;

/**
 * 插入排序
 *
 * 算法思想: 每次选择一个元素插入到已经排好序的数组中
 *
 * @Author: Gray
 * @date 2020/10/29 22:46
 */
public class InsertionSort {

    public static void sort(Comparable[] arr){
        int len = arr.length;

        for (int i=1; i<len; i++){
            for (int j = i; j>0 && less(arr[j], arr[j-1]); j--){
                swap(arr,j,j-1);
            }
        }
/*        for (int i = 1; i<len; i++){
            Comparable c = arr[i];
            for (int j = 0; j<i; j++){
                if (less(arr[i], arr[j])){
                    for (int k=i; k>j; k--){
                        arr[k] = arr[k-1];
                    }
                    arr[j] = c;
                }
            }
        }*/
    }
}
