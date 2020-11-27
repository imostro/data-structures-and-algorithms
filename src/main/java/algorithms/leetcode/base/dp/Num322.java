package algorithms.leetcode.base.dp;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 322. 零钱兑换
 *
 * @author Gray
 * @date 2020/11/26 10:37
 */
public class Num322 {

    public static void main(String[] args) {
        Num322 num322 = new Num322();
        long start = System.currentTimeMillis();
        int change = num322.coinChange(new int[]{83,186,408, 419}, 6249);
        long end = System.currentTimeMillis();
        System.out.println(end-start);
        System.out.println(change);
    }

    /**
     * 动态规划的分析过程：
     * 1. 确定base case
     * 2. 确定状态，也就是原问题和子问题中会变化的变量
     * 3. 确定选择，也就是导致状态产生变化的行为
     * 4. 明确dp函数/数组的定义
     */
    public int coinChange(int[] coins, int amount){
//        map = new HashMap<>(amount);
        return coinChange_dp(coins, amount);
    }

    /**
     * 先通过递归自顶而下暴力求解
     */
    public int coinChange_dfs(int[] coins, int amount) {
        if (amount < 0) return -1;
        if (amount == 0)    return 0;

        int min = Integer.MAX_VALUE;
        for (int i=0; i<coins.length; i++){
            int change = coinChange_dfs(coins, amount - coins[i]);
            if (change != -1)  min = Math.min(change+1, min);
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }

    /**
     * 在递归自顶而下暴力求解的基础上加入HashMap作备忘录来去除重复项
     *
     * 该实现把一些重复计算的递归直接剪掉，大大的提高了性能
     */
    private HashMap<Integer, Integer> map;

    public int coinChange_dfs_hashmap(int[] coins, int amount) {
        if (amount < 0) return -1;
        if (amount == 0)    return 0;

        if (map.containsKey(amount))    return map.get(amount);
        int min = Integer.MAX_VALUE;
        for (int i=0; i<coins.length; i++){
            int change = coinChange_dfs_hashmap(coins, amount - coins[i]);
            if (change != -1)  min = Math.min(change+1, min);
        }
        min = min ==Integer.MAX_VALUE ? -1 : min;
        map.put(amount, min);
        return min;
    }


    /**
     * 自底向上解法
     *
     * 先构求解出小的额度最小金币数，然后再找大额度与小额度的关系
     */
    public int coinChange_dp(int[] coins, int amount) {
        int[] dp = new int[amount + 1];

        for (int n = 1; n <= amount; n++){
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (n - coin < 0 || dp[n-coin] == -1)   continue;
                min = Math.min(min, dp[n-coin]+1);
            }
            min = min == Integer.MAX_VALUE ? -1 : min;
            dp[n] = min;
        }

        return dp[amount];
    }
}
