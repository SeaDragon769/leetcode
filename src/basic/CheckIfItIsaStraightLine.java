package basic;

public class CheckIfItIsaStraightLine {
    public boolean checkStraightLine(int[][] coordinates) {
        if(coordinates.length<=2){
            return true;
        }
        int[] x=coordinates[0];
        int[] y=coordinates[1];
        for(int i=2;i<coordinates.length;i++){
            int[] z=coordinates[i];
            if((z[1]-x[1])*(y[0]-x[0])!=(y[1]-x[1])*(z[0]-x[0])){
                return false;
            }
        }
        return true;


    }
}
