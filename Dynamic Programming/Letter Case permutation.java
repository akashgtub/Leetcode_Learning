class Solution {
    static List<String> list;
    static void solve(String s,int idx,String cur){
        if(idx==s.length()){
             list.add(cur);
             return;
        }
        char ch=s.charAt(idx);
        if(Character.isDigit(ch)){
            solve(s,idx+1,cur+ch);
        }
        else{
            solve(s,idx+1,cur+Character.toLowerCase(ch));
            solve(s,idx+1,cur+Character.toUpperCase(ch));
        }

    }
    public List<String> letterCasePermutation(String s) {
        list=new ArrayList<>();
        solve(s,0,"");
        return list;
    }
}