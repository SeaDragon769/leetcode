package basic;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ContainsDuplicate_217 {
    public boolean containsDuplicate(int[] nums) {
        if(nums==null||nums.length==0){
            return false;
        }
        Set<Integer> set=new HashSet<>();
//        Map<Integer,Integer> map=new HashMap<>();
        for(int i:nums){
            if(set.contains(i)){
                return true;
            }else{
                set.add(i);
            }
        }
        return false;
    }
}
