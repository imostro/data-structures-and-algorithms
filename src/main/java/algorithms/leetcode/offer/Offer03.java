package algorithms.leetcode.offer;

import java.util.HashMap;
import java.util.HashSet;

/**
 * leetcode
 * 剑指 Offer 03. 数组中重复的数字
 *
 * @author Gray
 * @date 2020/11/19 22:23
 */
public class Offer03 {

    public static void main(String[] args) {
        Offer03 offer03 = new Offer03();
        offer03.findRepeatNumber(new int[]{2, 3, 1, 0, 2, 5, 3});
    }

    /**
     * hash set 解法
     *
     * 遍历整个数组，如果元素不在集合中，则把它添加进集合，否则直接返回
     */
    public int findRepeatNumber_hash(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)){
                return num;
            }
            set.add(num);
        }

        return -1;
    }

    /**
     * 原地交换算法
     *
     * 如果当前索引下的值不等于索引，则索引下的值与以索引下值作为索引的值是否相等，相等则返回，否则交换
     */
    public int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i && nums[nums[i]] == nums[i]){
                return nums[i];
            }
            int idx = nums[i];
            nums[i] = nums[idx];
            nums[idx] = idx;
        }

        return -1;
    }
}
