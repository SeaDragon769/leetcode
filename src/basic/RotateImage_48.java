package basic;

public class RotateImage_48 {
    public void rotate(int[][] matrix) {
        for(int i=0;i<matrix.length/2;i++){
            for(int j=i;j<matrix.length-1-i;j++){
                int a=matrix[i][j];
                int b=matrix[j][matrix.length-1-i];
                int c=matrix[matrix.length-1-i][matrix.length-1-j];
                int d=matrix[matrix.length-1-j][i];
                matrix[j][matrix.length-1-i]=a;
                matrix[matrix.length-1-i][matrix.length-1-j]=b;
                matrix[matrix.length-1-j][i]=c;
                matrix[i][j]=d;
            }
        }
    }

    public static void main(String[] args) {
        RotateImage_48 rotateImage_48=new RotateImage_48();
        int[][] nums=new int[][]{{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        rotateImage_48.rotate(nums);
    }
}
