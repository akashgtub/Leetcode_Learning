class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<numRows;i++){
            ArrayList<Integer> cur=new ArrayList<>();
            cur.add(1);
            for(int j=1;j<i;j++){
                int val=list.get(i-1).get(j-1)+list.get(i-1).get(j);
                cur.add(val);
            }
            if(i>0){
                cur.add(1);
            }
            list.add(cur);
        }
        return list;
    }
}