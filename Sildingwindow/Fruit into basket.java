class Solution {
    public int totalFruit(int[] arr) {
       Map<Integer,Integer> map=new HashMap<>();
       int left=0,max=0,n=arr.length;
       for(int i=0;i<n;i++){
        map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        while(map.size()>2){
            map.put(arr[left],map.get(arr[left])-1);
            if(map.get(arr[left])==0){
                map.remove(arr[left]);
            }
            left++;
        }
        if(map.size()<=2){
            max=Math.max(max,i-left+1);
        }
       } 
       return max;
    }
}