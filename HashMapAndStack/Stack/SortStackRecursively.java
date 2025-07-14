package stack_problems;
import java.util.Stack;

public class SortStackRecursively {

    static void sortedInsert(Stack<Integer> stack, int element) {
        if (stack.isEmpty() || element > stack.peek()) {
            stack.push(element);
            return;
        }
        int top = stack.pop();
        sortedInsert(stack, element);
        stack.push(top);
    }

    static void sortStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int top = stack.pop();
            sortStack(stack);
            sortedInsert(stack, top);
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(30);
        stack.push(5);
        stack.push(10);
        stack.push(1);
        sortStack(stack);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}