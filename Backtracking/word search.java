class Solution {
    static int[][] sol;
    static int n;
    static int m;
    static boolean solve(int i,int j,int idx,String word,char[][] board){
        if(i<0||i>=n||j<0||j>=m||sol[i][j]==1||board[i][j]!=word.charAt(idx)){
            return false;
        }
        if(idx+1==word.length()){
            return true;
        }
        sol[i][j]=1;
        if(solve(i,j+1,idx+1,word,board)){
            return true;
        }
        if(solve(i+1,j,idx+1,word,board)){
            return true;
        }
        if(solve(i-1,j,idx+1,word,board)){
            return true;
        }
        if(solve(i,j-1,idx+1,word,board)){
            return true;
        }
        sol[i][j]=0;
        return false;
    }
    static boolean is(String word,char[][] board){
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]==word.charAt(0)){
                    if(solve(i,j,0,word,board)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean exist(char[][] board, String word) {
         n=board.length;
         m=board[0].length;
        sol=new int[n][m];
        return is(word,board);
    }
}