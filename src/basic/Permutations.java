package basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> list= new ArrayList<>();
        for(int num:nums){
            list.add(num);
        }
        dfs(list,0,result);
        return result;

    }

    private void dfs(List<Integer> list,int k,List<List<Integer>> result){

        if(k==list.size()){
            result.add(new ArrayList<>(list));
            return;
        }

        for(int i=k;i<list.size();i++){
            Collections.swap(list,i,k);
            dfs(list,k+1,result);
            Collections.swap(list,i,k);
        }


    }


}
