package algorithms.leetcode.offer;

import util.ListNode;

import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * leetcode
 * 剑指 Offer 06. 从尾到头打印链表
 *
 * @author Gray
 * @date 2020/11/19 22:44
 */
public class Offer06 {

    /**
     * Stack解法
     */
    public int[] reversePrint_stack(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null){
            stack.push(head.val);
            head = head.next;
        }

        int[] res = new int[stack.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = stack.pop();
        }

        return res;
    }

    public int[] reversePrint(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        recur(head, list);

        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    void recur(ListNode head, List<Integer> list){
        if (head == null){
            return;
        }
        recur(head.next, list);
        list.add(head.val);
    }
}
