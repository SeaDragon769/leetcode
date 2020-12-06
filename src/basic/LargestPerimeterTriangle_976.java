package basic;

import java.util.Arrays;

public class LargestPerimeterTriangle_976 {
    public int largestPerimeter(int[] A) {
        if(A==null||A.length<3){
            return 0;
        }
        Arrays.sort(A);
        int result=0;
        for(int i=A.length-1;i>=2;i--){
            if(A[i-1]+A[i-2]>A[i]){
                result=A[i-1]+A[i-2]+A[i];
                break;
            }
        }
        return result;
    }
}
