package basic;

import java.util.ArrayList;
import java.util.List;

public class WiggleSubsequence_376 {
    public int wiggleMaxLength(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        List<Integer> list=new ArrayList<>();
        list.add(nums[0]);
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=nums[i-1]){
                list.add(nums[i]);
            }
        }
        int result=0;
        for(int i=0;i<list.size();i++){
            if(i==0||i==list.size()-1){
                result++;
            }else{
                if(list.get(i)>list.get(i-1)&&list.get(i)>list.get(i+1)){
                    result++;
                }
                if(list.get(i)<list.get(i-1)&&list.get(i)<list.get(i+1)){
                    result++;
                }
            }
        }
        return result;
    }
}
