package wiki.laona.leetcode.datastructure.stack;

/**
 * @program: LeetCode
 * @description: 测试类
 * @author: HuaiAnGG
 * @create: 2021-01-20 02:03
 **/
public class Main {

    public static void main(String[] args) {
        Stack<Integer> stack  = new Stack<>();
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
