package algorithms.leetcode.daily.year20.november;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * 164. 最大间距
 *
 * @author Gray
 * @date 2020/11/26 16:06
 */
public class Num26 {

    /**
     * 桶排序
     */
    public int maximumGap(int[] nums) {
        if (nums.length < 2)    return 0;
        int min =  Arrays.stream(nums).min().getAsInt();
        int max =  Arrays.stream(nums).max().getAsInt();

        int[] bucket = new int[max - min+1];
        Arrays.fill(bucket, -1);
        for (int i = 0; i < nums.length; i++) {
            bucket[nums[i] - min] = nums[i];
        }

        int prev = min;
        int res = Integer.MIN_VALUE;
        for (int i = 1; i < bucket.length; i++) {
            if (bucket[i] == -1) continue;
            res = Math.max(bucket[i] - prev, res);
            prev = bucket[i];
        }

        return res;
    }

}
