class Solution {
    public long countCommas(long n) {
        if(n<1000){
            return 0;
        }
        long th=1000;
        long c=0;
        while(n>=th){
            c+=n-th+1;
            th*=1000;
        }
        return c;
    }
}