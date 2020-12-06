package basic;

import java.util.ArrayDeque;
import java.util.Queue;

public class l_01Matrix_542 {
    public int[][] updateMatrix(int[][] matrix) {
        Queue<int[]> queue=new ArrayDeque<>();
        int[][] result=new int[matrix.length][matrix[0].length];

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    queue.offer(new int[]{i,j});
                    result[i][j]=0;
                }else{
                    result[i][j]=-1;
                }
            }
        }

        while(!queue.isEmpty()){
            int qLen=queue.size();
            for(int i=0;i<qLen;i++){
                int[] index=queue.poll();
                if(index[0]>0&&result[index[0]-1][index[1]]==-1){
                    result[index[0]-1][index[1]]=result[index[0]][index[1]]+1;
                    queue.offer(new int[]{index[0]-1,index[1]});
                }
                if(index[1]>0&&result[index[0]][index[1]-1]==-1){
                    result[index[0]][index[1]-1]=result[index[0]][index[1]]+1;
                    queue.offer(new int[]{index[0],index[1]-1});
                }
                if(index[0]<matrix.length-1&&result[index[0]+1][index[1]]==-1){
                    result[index[0]+1][index[1]]=result[index[0]][index[1]]+1;
                    queue.offer(new int[]{index[0]+1,index[1]});
                }
                if(index[1]<matrix[0].length-1&&result[index[0]][index[1]+1]==-1){
                    result[index[0]][index[1]+1]=result[index[0]][index[1]]+1;
                    queue.offer(new int[]{index[0],index[1]+1});
                }
            }
        }
        return result;

    }
}
