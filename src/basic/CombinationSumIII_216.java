package basic;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII_216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> solution=new ArrayList<>();
        List<List<Integer>> result=new ArrayList<>();
        backtrace(solution,result,1,k,n);
        return result;
    }

    private void backtrace(List<Integer> solution,List<List<Integer>> result,int start,int k,int n){
        if(n<0){
            return;
        }
        if(k>10-start){
            return;
        }

        if(k==1){
            for(int i=start;i<10;i++){
                if(i==n){
                    solution.add(i);
                    result.add(new ArrayList<>(solution));
                    solution.remove(solution.size()-1);
                    return;
                }
            }
        }

        for(int i=start;i<10;i++){
            solution.add(i);
            backtrace(solution,result,i+1,k-1,n-i);
            solution.remove(solution.size()-1);
        }
    }

}
