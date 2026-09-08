class Solution {
    public int minPatches(int[] arr, int n) {
        int count=0,i=0;
        long miss=1;
        while(miss<=n){
            if(i<arr.length&&arr[i]<=miss){
                miss+=arr[i];
                i++;
            }
            else{
                miss+=miss;
                count++;
            }
        }
        return count;
    }
}