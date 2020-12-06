package basic;

public class WordSearch_79 {
    public boolean exist(char[][] board, String word) {
        boolean[][] searched=new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(dfs(board,searched,i,j,word,0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board,boolean[][] searched,int i,int j,String word,int wordIndex){
        if(wordIndex==word.length()){
            return true;
        }
        if(i<0||j<0||i>=board.length||j>=board[0].length){
            return false;
        }
        if(word.charAt(wordIndex)!=board[i][j]||searched[i][j]){
            return false;
        }
        searched[i][j]=true;
        if(dfs(board,searched,i-1,j,word,wordIndex+1)){
            return true;
        }
        if(dfs(board,searched,i,j-1,word,wordIndex+1)){
            return true;
        }
        if(dfs(board,searched,i+1,j,word,wordIndex+1)){
            return true;
        }
        if(dfs(board,searched,i,j+1,word,wordIndex+1)){
            return true;
        }
        searched[i][j]=false;
        return false;

    }

    public static void main(String[] args) {
        char[][] input=new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String targte="SEE";
        WordSearch_79 wordSearch=new WordSearch_79();
        wordSearch.exist(input,targte);

    }

}
