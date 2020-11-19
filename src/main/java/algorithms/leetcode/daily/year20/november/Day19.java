package algorithms.leetcode.daily.year20.november;

import java.util.Arrays;

/**
 * 11.19 打卡
 * leetcode 283. 移动零
 *
 * @author Gray
 * @date 2020/11/19 22:11
 */
public class Day19 {

    /**
     * 统计覆盖
     */
    public void moveZeroes(int[] nums) {
        int idx = 0;
        for (int i=0; i<nums.length; i++){
            if (nums[i] == 0)   continue;
            nums[idx++] = nums[i];
        }
        while (idx < nums.length){
            nums[idx++] = 0;
        }
    }

    /**
     * 双指针解法
     */
    public void moveZeroes_tp(int[] nums) {
        int l = 0, r = -1;
        while (++r < nums.length){
            if (nums[r] != 0){
                int temp = nums[r];
                nums[r] = nums[l];
                nums[l] = temp;
                l++;
            }
        }
    }
}
