package basic;

public class Mirror {
    public void rotate(int[][] matrix) {
        for(int i= 0;i<matrix.length/2;i++){
            for(int j=i;j<matrix.length-i-1;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[matrix.length-1-j][i];
                matrix[matrix.length-1-j][i]=matrix[matrix.length-1-i][matrix.length-1-j];
                matrix[matrix.length-1-i][matrix.length-1-j]=matrix[j][matrix.length-1-i];
                matrix[j][matrix.length-1-i]=temp;
            }
        }
    }
    public void reverseString(char[] s) {
        char temp;
        for (int i =0;i< s.length/2;i++){
            temp=s[i];
            s[i]=s[s.length-1-i];
            s[s.length-1-i]=temp;
        }
    }
}
