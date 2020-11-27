package algorithms.leetcode.base.binarysearch;

/**
 * 704. 二分查找
 *
 * @author Gray
 * @date 2020/11/27 20:44
 */
public class Num704 {

    public int search(int[] nums, int target) {
        int left =0, right = nums.length-1;
        while (left <= right){
            int mid = left + (right-left)/2;

            if (nums[mid] == target){
                return mid;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        return -1;
    }
}
