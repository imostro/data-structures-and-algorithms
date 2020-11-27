package algorithms.leetcode.base.binarysearch;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 *
 * @author Gray
 * @date 2020/11/27 21:15
 */
public class Num34 {

    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        int left = 0;
        int right = nums.length-1;

        while (left <= right){
            int mid = left + (right - left) / 2;
            if (nums[mid] == target){
                right = mid - 1;
            } else if (nums[mid] < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        if (left >= nums.length || nums[left] != target) {
            result[0] = -1;
        }else{
            result[0] = left;
        }

        right = nums.length-1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (nums[mid] == target){
                left = mid + 1;
            } else if (nums[mid] < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        if (right < 0 || nums[right] != target) {
            result[1] = -1;
        }else{
            result[1] = left;
        }

        return result;
    }


}
