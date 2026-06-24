class Solution {
    public char findTheDifference(String s, String t) {
        char ch=0;
        for(char a :s.toCharArray()){
            ch=(char)(ch^a);
        }
        for(char b:t.toCharArray()){
            ch=(char)(ch^b);
        }
        return ch;
    }
}