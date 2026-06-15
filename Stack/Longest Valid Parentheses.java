/*
Approach: Stack + Indices

Solved the problem using a Stack to store indices instead of parentheses.
Used a sentinel value (-1) as the base index to handle edge cases and calculate valid substring lengths correctly.
For every '(', pushed its index onto the stack.
For every ')', popped from the stack:
If the stack became empty, pushed the current index as the new base.

Otherwise, calculated the length of the current valid parentheses substring using:

currentIndex - stack.peek()
Maintained the maximum valid length encountered during traversal.
*/

class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack=new Stack<>();
        stack.push(-1);
        int max=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='('){
                stack.push(i);
            }
            else{
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }
                else{
                    max=Math.max(max,i-stack.peek());
                }
            }
        }
        return max;
    }
}