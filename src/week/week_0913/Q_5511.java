package week.week_0913;

public class Q_5511 {
    public int numSpecial(int[][] mat) {
        int rowSum[]=new int[mat.length];
        for(int i=0;i<mat.length;i++){
            int sum=0;
            for(int j=0;j<mat[0].length;j++){
                sum+=mat[i][j];
            }
            rowSum[i]=sum;
        }
        int columnSum[]=new int[mat[0].length];
        for(int j=0;j<mat[0].length;j++){
            int sum=0;
            for(int i=0;i<mat.length;i++){
                sum+=mat[i][j];
            }
            columnSum[j]=sum;
        }
        int result=0;
        for(int i=0;i<rowSum.length;i++){
            for (int j=0;j<columnSum.length;j++){
                if(mat[i][j]==1&&rowSum[i]==1&&columnSum[j]==1){
                    result++;
                }
            }
        }
        return result;

    }
}
