package pack;

public class MatrixSearchII {

    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0){
            return false;
        }

        int i=0;
        int j=matrix[0].length-1;
        while(i<matrix.length&&j>=0){
            if(matrix[i][j]>target){
                j--;
            }else if(matrix[i][j]<target){
                i++;
            }else {
                return true;
            }
        }
        return false;

    }


}
