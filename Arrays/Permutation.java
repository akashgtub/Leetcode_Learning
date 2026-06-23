class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        boolean[] used=new boolean[nums.length];
        back(nums,res,used,new ArrayList<>());
        return res;
    }
    public static void back(int nums[],List<List<Integer>> res,boolean[] used,ArrayList<Integer> cur){
        if(cur.size()==nums.length){
            res.add(new ArrayList<>(cur));
            return ;
        }
        for(int i=0;i<nums.length;i++){
            if(used[i]){
                continue;
            }
            used[i]=true;
            cur.add(nums[i]);
            back(nums,res,used,cur);
            cur.remove(cur.size()-1);
            used[i]=false;
        }
    }
}