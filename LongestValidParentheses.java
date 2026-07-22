import java.util.*;

public class LongestValidParentheses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the string (only '(' and ')'): ");

        String s = "";
        if (sc.hasNextLine()) {
            s = sc.nextLine();
        }

        
        s = s.replaceAll("[^()]", "");

        int result = longestValidParentheses(s);
        System.out.println("Cleaned input: \"" + s + "\"");
        System.out.println("Length of longest valid parentheses substring: " + result);

        sc.close();
    }
    public static int longestValidParentheses(String s) {
        int maxLen = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(i);
            } else if (ch == ')') {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }

        return maxLen;
    }
}