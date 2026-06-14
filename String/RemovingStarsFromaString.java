/*
Today, I decided to solve some string problems to improve my logical thinking and problem-solving skills. While searching for a suitable problem, I came across this one and initially thought of solving it using a Stack.

The idea was to use the stack to process characters one by one and then reconstruct the final string from the stack contents.
*/
class Solution {
    public String removeStars(String s) {
     Stack<Character> stack=new Stack<>();
     for(int i=0;i<s.length();i++){
        if(s.charAt(i)=='*'){
            if(!stack.isEmpty()){
                stack.pop();
                continue;
            }

        }
        stack.push(s.charAt(i));
        
     }   
     StringBuilder sb=new StringBuilder();
     for(char c:stack){
        sb.append(c);
     }
     return sb.toString();
    }
}