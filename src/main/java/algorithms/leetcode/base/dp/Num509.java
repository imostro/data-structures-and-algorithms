package algorithms.leetcode.base.dp;

/**
 * 509. 斐波那契数
 *
 * @author Gray
 * @date 2020/11/26 10:19
 */
public class Num509 {

    /**
     * 动态规划的入门
     *
     * 可以从斐波那契数列中体会到自顶向下的递归的O(2^n)复杂度到减少重复项递归，再到没有递归直接自底向上的算法
     */
    public int fib(int N) {
        int a = 0, b = 1;
        int c= 1;
        while (N-- > 0){
            c = a + b;
            a = b;
            b = c;
        }

        return a;
    }
}
