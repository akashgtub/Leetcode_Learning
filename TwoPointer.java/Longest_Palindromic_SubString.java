class Solution {
    int start=0;
    int max=0;
    public void exp(String s,int left,int right){
        while(left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)){
            int len=right-left+1;
            if(len>max){
                max=len;
                start=left;
            }
            left--;
            right++;
        }
    }
    public String longestPalindrome(String s) {
        for(int i=0;i<s.length();i++){
            exp(s,i,i);
            exp(s,i,i+1);
        }
        return s.substring(start,start+max);
    }
}