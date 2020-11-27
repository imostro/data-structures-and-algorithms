package algorithms.leetcode.base.bdfs;

import common.TreeNode;

import java.util.LinkedList;

/**
 * 111. 二叉树的最小深度
 *
 * @author Gray
 * @date 2020/11/26 14:17
 */
public class Num111 {

    /**
     * bfs
     */
    public int minDepth(TreeNode root) {
        if (root == null)   return 0;

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int high = 0;
        while (!queue.isEmpty()){
            high++;
            int size = queue.size();
            for (int i=0; i<size; i++){
                TreeNode node = queue.pollFirst();
                if (node.left == null && node.right == null)    return high;
                if (node.left != null)  queue.add(node.left);
                if (node.right != null)  queue.add(node.right);
            }
        }
        return high;
    }

    /**
     * dfs
     */
    public int minDepth_dfs(TreeNode root) {
        if (root == null)   return 0;
        if (root.left == null && root.right == null)    return 0;
        if (root.left == null || root.right == null){
            return (root.left == null ? minDepth_dfs(root.right) : minDepth_dfs(root.left)) + 1;
        }

        return Math.min(minDepth_dfs(root.left), minDepth_dfs(root.right)) +1;
    }
}
