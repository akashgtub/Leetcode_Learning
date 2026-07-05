class Solution {
   static List<List<String>> list;
   static void solve(int idx,String s,List<String> cur){
    if(idx==s.length()){
        list.add(new ArrayList<>(cur));
  return;
    }
    for(int i=idx;i<s.length();i++){
        if(isPalindrome(s,idx,i)){
            cur.add(s.substring(idx,i+1));
            solve(i+1,s,cur);
            cur.remove(cur.size()-1);
        }

    }
   }
   static boolean isPalindrome(String s,int left,int right){
    while(left<right){
        if(s.charAt(left++)!=s.charAt(right--)){
            return false;
        }
    }
    return true;
   }
    public List<List<String>> partition(String s) {
        list=new ArrayList<>();
        solve(0,s,new ArrayList<>());
        return list;
    }
}