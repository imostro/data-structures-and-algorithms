package common;

import java.util.Random;

/**
 * @Author: Gray
 * @date 2020/10/28 22:31
 */
public class CommonUtils {

    public static <T extends  Comparable<T>> void swap(T[] arr, int i, int j){
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static Integer[] randomArr(int len){
        Random r = new Random();
        Integer[] arr = new Integer[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(50);
        }
        return arr;
    }

    public static Integer[] randomArr(){
        return randomArr(30);
    }

    public static boolean less(Comparable o1, Comparable o2){
        return o1.compareTo(o2) < 0;
    }
}
