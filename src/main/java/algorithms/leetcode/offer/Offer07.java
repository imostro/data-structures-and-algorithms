package algorithms.leetcode.offer;

import util.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Gray
 * @date 2020/11/19 23:07
 */
public class Offer07 {

    public static void main(String[] args) {
        Offer07 offer07 = new Offer07();
        offer07.buildTree(new int[]{1,2}, new int[]{2,1});
    }

    int idx = 0;
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0)    return null;

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return build(preorder, 0, preorder.length-1);
    }

    TreeNode build(int[] preorder, int left, int right){
        if (left > right)   return null;

        int i = preorder[idx++];
        TreeNode root = new TreeNode(i);
        if (left == right){
            return root;
        }
        int mid = map.get(i);
        root.left = build(preorder, left, mid-1);
        root.right = build(preorder, mid+1, right);

        return root;
    }

}
