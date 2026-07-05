class Solution {
    static List<List<Integer>> list;
    static void solve(int[] arr,int idx,List<Integer> cur){
    list.add(new ArrayList<>(cur));
    for(int i=idx;i<arr.length;i++){
        cur.add(arr[i]);
        solve(arr,i+1,cur);
        cur.remove(cur.size()-1);
        // int nxt=i+1;
        while(i+1<arr.length&&arr[i]==arr[i+1]){
            i++;
        }
        // solve(arr,i+1,cur);
    }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        list=new ArrayList<>();
        solve(nums,0,new ArrayList<>());
        return list;
    }
}