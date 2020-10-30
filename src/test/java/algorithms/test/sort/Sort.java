package algorithms.test.sort;

import algorithms.classical.sort.InsertionSort;
import algorithms.classical.sort.MergeSort;
import algorithms.classical.sort.SelectionSort;
import org.junit.Test;
import util.CommonUtils;

import java.util.Arrays;

/**
 * @Author: Gray
 * @date 2020/10/28 23:29
 */
public class Sort {

    @Test
    public void mergeSortTest(){
        Integer[] arr = CommonUtils.randomArr(30);
        MergeSort.sortBU(arr);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void selectionSortTest(){
        Integer[] arr = CommonUtils.randomArr(30);
        System.out.println(Arrays.toString(arr));
        SelectionSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void insertionSortTesT(){
        Integer[] arr = CommonUtils.randomArr(30);
        InsertionSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
