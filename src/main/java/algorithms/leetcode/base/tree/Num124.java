package algorithms.leetcode.base.tree;

import common.TreeNode;

/**
 * 124. 二叉树中的最大路径和
 *
 * @author Gray
 * @date 2020/11/24 23:59
 */
public class Num124 {

    int ans = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        oneSideMax(root);
        return ans;
    }

    private int oneSideMax(TreeNode root){
        if (root == null)   return 0;
        int left = oneSideMax(root.left);
        int right = oneSideMax(root.right);
        ans = Math.max(root.val + left + right, ans);
        return Math.max(left, right) + root.val;
    }
}
