package algorithms.classical.search;

/**
 * @author Gray
 * @date 2020/11/18 0:39
 */
public class BinarySearch {

    public static <T extends Comparable<T>> int search(T[] arr, T key){
        int lo = 0, hi = arr.length;
        return search(arr, key, lo, hi);
    }

    public static <T extends Comparable<T>> int search(T[] arr, T key,int lo, int hi){
        if (lo > hi)   return lo;

        int mid = lo + (hi-lo) /2;
        int cmp = arr[mid].compareTo(key);
        if (cmp > 0)    return search(arr, key, lo, mid-1);
        else if (cmp < 0)  return search(arr, key, mid+1, hi);
        else return mid;
    }

    public static <T extends Comparable<T>> int rank(T[] arr, T key){
        int lo = 0, hi = arr.length;

        while (lo <= hi){
            int mid = lo + (hi-lo) /2;
            int cmp = arr[mid].compareTo(key);
            if (cmp > 0)    hi = mid-1;
            else if (cmp < 0)  lo = mid+1;
            else return mid;
        }

        return lo;
    }
}
