package algorithms.leetcode.base.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 46. 全排列
 * https://leetcode-cn.com/problems/permutations/
 *
 * @author Gray
 * @date 2020/11/26 14:01
 */
public class Num46 {

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    boolean[] used;
    public List<List<Integer>> permute(int[] nums) {
        used = new boolean[nums.length];
        backtrack(nums);
        return result;
    }

    private void backtrack(int[] nums){
        if (nums.length == list.size()){
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i=0; i<nums.length; i++){
            if (used[i])    continue;
            used[i] = true;
            list.add(nums[i]);
            backtrack(nums);
            used[i] = false;
            list.remove(list.size()-1);
        }
    }
}
