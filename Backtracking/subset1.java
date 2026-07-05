class Solution {
    static List<List<Integer>> list=new ArrayList<>();
    static void solve(int[] arr,int idx,List<Integer> cur){
        list.add(new ArrayList<>(cur));
        for(int i=idx;i<arr.length;i++){
            cur.add(arr[i]);
            solve(arr,i+1,cur);
            cur.remove(cur.size()-1);
        }
    }
    public List<List<Integer>> subsets(int[] nums) {
           list=new ArrayList<>();
           Arrays.sort(nums);
           solve(nums,0,new ArrayList<>());
           return list;
    }
}