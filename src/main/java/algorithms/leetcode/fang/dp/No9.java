package algorithms.leetcode.fang.dp;

/**
 * leetcode 718. 最长重复子数组
 *
 * @author Gray
 * @date 2020/11/18 11:06
 */
public class No9 {

    public static void main(String[] args) {
        No9 no9 = new No9();
        int i = no9.findLength_dp(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4, 7});
        System.out.println(i);
    }

    /**
     * 动态规划 还可以通过逆序减少空间复杂度
     */
    public int findLength_dp(int[] A, int[] B) {
        int l1 = A.length;
        int l2 = B.length;
        int[][] dp = new int[l1+1][l2+1];

        int max = 0;
        for (int i=0; i<l1; i++){
            for (int j=0; j<l2; j++){
                if (A[i] == B[j]){
                    dp[i+1][j+1] = dp[i][j] + 1;
                    max = Math.max(dp[i+1][j+1], max);
                }
            }
        }
        return max;
    }

    public int findLength(int[] A, int[] B) {
        return A.length < B.length ? findMax(A, B) : findMax(B, A);
    }

    int findMax(int[] A, int[] B) {
        int max = 0;
        int an = A.length, bn = B.length;
        for(int len=1; len <= an; len++) {
            max = Math.max(max, maxLen(A, 0, B, bn - len, len));
        }
        for(int j=bn-an; j >= 0;j--) {
            max = Math.max(max, maxLen(A, 0, B, j, an));
        }
        for(int i=1;i<an;i++) {
            max = Math.max(max, maxLen(A, i, B, 0, an - i));
        }
        return max;
    }

    /**
     * 滑动窗口解法
     *
     *  作者：stg
     */
    int maxLen(int[] a, int i, int[] b, int j, int len) {
        int count = 0, max = 0;
        for(int k = 0; k < len; k++) {
            if(a[i+k] == b[j+k]) {
                count++;
            } else if(count > 0) {
                max = Math.max(max, count);
                count = 0;
            }
        }
        return count > 0 ? Math.max(max, count) : max;
    }


}
