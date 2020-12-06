package basic;

import java.util.*;

public class PermutationsII_47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<Integer> solution=new LinkedList<>();
        for(int num:nums){
            solution.add(num);
        }
        List<List<Integer>> result=new ArrayList<>();
        permute(solution,0,result);
        return result;
    }
    private void permute(List<Integer> solution,int k,List<List<Integer>> result){
        if(k==solution.size()){
            result.add(new ArrayList<>(solution));
            return;
        }
        for(int i=k;i<solution.size();i++){
            if(i>k&&solution.get(i).equals(solution.get(k))){
                continue;
            }
            if(i>k&&solution.get(i).equals(solution.get(i-1))){
                continue;
            }
            int iValue=solution.get(i);
            solution.remove(i);
            solution.add(k,iValue);
            permute(solution,k+1,result);
            int kValue=solution.get(k);
            solution.remove(k);
            solution.add(i,kValue);
        }
    }

    public static void main(String[] args) {
        PermutationsII_47 permutationsII_47=new PermutationsII_47();
        int[] nums=new int[]{1,1,2};
        permutationsII_47.permuteUnique(nums);
    }
}
