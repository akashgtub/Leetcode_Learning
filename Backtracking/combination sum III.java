class Solution {
    static int[] sol;
    static int n;
    static  List<List<Integer>> res;
    static void solve(int idx,int[] arr,int sum,List<Integer> cur){
  
        if(sum==0){
             res.add(new ArrayList<>(cur));
             return;
        }
              if(sum<0||idx==n){
            return;
        }
        // sol[idx]=1;
        cur.add(arr[idx]);
        solve(idx+1,arr,sum-arr[idx],cur);
        //   sol[idx]=0;
          cur.remove(cur.size()-1);
          int nxt=idx+1;
          while(nxt<n&&arr[nxt]==arr[idx]){
            nxt++;
          }
          solve(nxt,arr,sum,cur);

    }
    public List<List<Integer>> combinationSum2(int[] arr, int target) {
        sol=new int[arr.length];
        res=new ArrayList<>();
        n=arr.length;
        Arrays.sort(arr);
          solve(0,arr,target,new ArrayList<>());
          return res;
    }
}