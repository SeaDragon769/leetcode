package daily;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle_118 {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result=new ArrayList<>(numRows);
        for(int i=0;i<numRows;i++){
            List<Integer> row=new ArrayList<>();
            if(i==0){
                row.add(1);
            }else{
                List<Integer> pre=result.get(result.size()-1);
                for(int j=0;j<=i;j++){
                    if(j==0||j==i){
                        row.add(1);
                    }else{
                        row.add(pre.get(j-1)+pre.get(j));
                    }
                }
            }
            result.add(row);
        }
        return result;
    }

    public static void main(String[] args) {
        generate(5);
    }
}
