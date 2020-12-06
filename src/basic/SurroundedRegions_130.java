package basic;

public class SurroundedRegions_130 {
    public void solve(char[][] board) {
        if(board==null||board.length==0||board[0].length==0){
            return;
        }

        for(int i=0;i<board.length;i++){
            dfs(board,i,0);
            dfs(board,i,board[0].length-1);
        }

        for(int j=0;j<board[0].length;j++){
            dfs(board,0,j);
            dfs(board,board.length-1,j);
        }

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }else if(board[i][j]=='S'){
                    board[i][j]='O';
                }
            }
        }


    }

    private void dfs(char[][] board,int i,int j){
        if(i<0||i>=board.length||j<0||j>=board[0].length){
            return;
        }

        if(board[i][j]=='O'){
            board[i][j]='S';
            dfs(board,i-1,j);
            dfs(board,i+1,j);
            dfs(board,i,j-1);
            dfs(board,i,j+1);
        }
    }


}
