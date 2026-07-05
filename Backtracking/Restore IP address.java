class Solution {
    static List<String> list;
    static void solve(int idx,int[] path,int n,String s){
        if(n==4&&idx==s.length()){
            list.add(path[0]+"."+path[1]+"."+path[2]+"."+path[3]);
            return;
        }
        if(n==4||idx==s.length()){
            return;
        }
        for(int len=1;len<=3&&idx+len<=s.length();len++){
            int val=Integer.parseInt(s.substring(idx,idx+len));
            if(val>255||(len>=2&&s.charAt(idx)=='0')){
                break;
            }
            path[n]=val;
            solve(idx+len,path,n+1,s);
            path[n]=-1;
        }
    }
    public List<String> restoreIpAddresses(String s) {
        list=new ArrayList<>();
        int[] path=new int[4];
        solve(0,path,0,s);
        return list;
    }
}