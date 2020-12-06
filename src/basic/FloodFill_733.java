package basic;

public class FloodFill_733 {


    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        int color=image[sr][sc];
        dfs(image,sr,sc,color);
        for(int i=0;i<image.length;i++){
            for(int j=0;j<image[0].length;j++){
                if(image[i][j]==-1){
                    image[i][j]=newColor;
                }
            }
        }

        return image;
    }


    private void dfs(int[][] image,int sr, int sc,int currentColor){
        if(sr<0||sr>=image.length||sc<0||sc>=image[0].length){
            return;
        }
        if(image[sr][sc]==currentColor){
            image[sr][sc] = -1;
            dfs(image, sr-1, sc, currentColor);
            dfs(image, sr+1, sc, currentColor);
            dfs(image, sr, sc-1, currentColor);
            dfs(image, sr, sc+1, currentColor);
        }
    }

}
