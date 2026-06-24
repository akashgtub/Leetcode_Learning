class Solution {
    public int maximumWealth(int[][] accounts) {
        int max=0;
        int n=accounts.length;
        int m=accounts[0].length;
        for(int i=0;i<n;i++){
                   int count=0;
            for(int j=0;j<m;j++){
                  count+=accounts[i][j];
            }
            if(count>max){
                max=count;
            }
        }
        return max;
    }
}