package algorithms.leetcode.daily.year20.november;

import common.TreeNode;

/**
 * 222. 完全二叉树的节点个数
 *
 * @author Gray
 * @date 2020/11/24 23:14
 */
public class Day24 {

    public int countNodes(TreeNode root) {
        return dfs(root);
    }

    /**
     * dfs递归
     */
    public int dfs(TreeNode root){
        if (root == null)   return 0;

        int c = 1;

        c += dfs(root.left);
        c += dfs(root.right);

        return c;
    }
}
