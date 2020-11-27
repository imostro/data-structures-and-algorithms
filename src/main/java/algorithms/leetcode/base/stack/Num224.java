package algorithms.leetcode.base.stack;

import java.util.*;

/**
 * 224. 基本计算器
 *
 * @author Gray
 * @date 2020/11/27 15:59
 */
public class Num224 {

    public static void main(String[] args) {
        Num224 num224 = new Num224();
        System.out.println(num224.calculate("(5-(1+(5)))"));
    }

    public int calculate(String s) {
        Stack<Character> stack = new Stack<>();
        int len = s.length();
        int idx = 0;

        while (idx < len){
            char ch = s.charAt(idx++);
            if (ch == ' ')  continue;
            if (ch == ')'){
                StringBuilder sb = new StringBuilder();
                while(stack.peek() != '('){
                    sb.append(stack.pop());
                }
                stack.pop();
                int result = simpleCalculate(sb.reverse().toString());
                if (result < 0){
                    Character operator = stack.isEmpty() ?  '+' : stack.pop();
                    if (operator.equals('+')){
                        stack.push('-');
                    }else{
                        stack.push('+');
                    }
                }
                char[] array = String.valueOf(Math.abs(result)).toCharArray();
                for (char c : array) {
                    stack.add(c);
                }
            }else{
                stack.add(ch);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }

        return simpleCalculate(sb.reverse().toString());
    }

    private int simpleCalculate(String s){
        int idx = 0;
        int len = s.length();
        Stack<String> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();

        while(idx < len){
            char ch = s.charAt(idx++);
            if (ch == ' ')  continue;
            if ((ch == '+' || ch == '-') && queue.size() > 0){
                convert(stack, queue);
                stack.push(String.valueOf(ch));
            }else{
                queue.add(ch);
            }
        }

        convert(stack, queue);
        return Integer.parseInt(stack.pop());
    }

    private void convert(Stack<String> stack, Queue<Character> queue){
        StringBuilder sb = new StringBuilder();
        while (queue.size() > 0){
            sb.append(queue.poll());
        }
        stack.push(sb.toString());
        if (stack.size() > 2){
            int num2 = Integer.parseInt(stack.pop());
            String operate = stack.pop();
            int num1 = Integer.parseInt(stack.pop());
            if ("+".equals(operate)){
                num1 += num2;
            }else{
                num1 -= num2;
            }
            stack.push(String.valueOf(num1));
        }
    }
}
