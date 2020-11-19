package algorithms.leetcode.offer;

import java.util.Stack;

/**
 * @author Gray
 * @date 2020/11/19 23:37
 */
public class Offer09 {

    /**
     * 一个作进栈，一个作出栈。
     * 当出栈out为空时，把进栈in的导进out
     */
    class CQueue {
        Stack<Integer> in;
        Stack<Integer> out;

        public CQueue() {
            in = new Stack<>();
            out = new Stack<>();
        }

        public void appendTail(int value) {
            in.push(value);
        }

        public int deleteHead() {
            if (out.isEmpty()){
                while (!in.isEmpty()){
                    out.push(in.pop());
                }
            }
            if (out.isEmpty()) return -1;
            return out.pop();
        }
    }

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
}
