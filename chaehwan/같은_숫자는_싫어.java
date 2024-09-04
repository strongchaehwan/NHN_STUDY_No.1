import java.util.ArrayDeque;
import java.util.Stack;
import java.util.Scanner;

public class 같은_숫자는_싫어 {

    private static Stack<Integer> solution(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        for (int num : arr) {
            if (stack.isEmpty() || stack.peek() != num) {
                stack.add(num);
            }
        }

        return stack;
    }

    public static void main(String[] args) {
        int[] arr = { 4, 4, 4, 3, 3 };
        System.out.println(solution(arr));

    }
}
