package algorithms.classical.sort;

import static util.CommonUtils.less;
import static util.CommonUtils.swap;

/**
 * 选择排序
 *
 * 算法思路：每次从数组中选取最小的元素，并放在数组的头部
 *
 * @Author: Gray
 * @date 2020/10/29 22:32
 */
public class SelectionSort {

    public static void sort(Comparable[] arr){
        int len = arr.length;

        for (int i=0; i<len; i++){
            int min = i;
            for (int j=i+1; j<len; j++){
                if (less(arr[j], arr[min])){
                    min = j;
                }
            }
            swap(arr, min, i);
        }
    }
}
