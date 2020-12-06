package basic;

import java.util.HashMap;
import java.util.Map;

public class SplitArrayintoConsecutiveSubsequences_659 {
    public static boolean isPossible(int[] nums) {
        Map<Integer,Integer> countMap=new HashMap<>();
        Map<Integer,Integer> preMap=new HashMap<>();

        for(int n:nums){
            countMap.merge(n,1,(a,b)->a+b);
        }

        for(int n:nums){
            if(countMap.get(n)<=0){
                continue;
            }
            if(preMap.containsKey(n-1)){
                preMap.merge(n,1,(a,b)->a+b);
                preMap.merge(n-1,1,(a,b)->a-b);
                if(preMap.get(n-1)==0){
                    preMap.remove(n-1);
                }
                countMap.merge(n,1,(a,b)->a-b);
            }else{
                if(countMap.containsKey(n)&&countMap.get(n)>0&&
                        countMap.containsKey(n+1)&&countMap.get(n+1)>0
                        &&countMap.containsKey(n+2)&&countMap.get(n+2)>0){
                    countMap.merge(n,1,(a,b)->a-b);
                    countMap.merge(n+1,1,(a,b)->a-b);
                    countMap.merge(n+2,1,(a,b)->a-b);
                    preMap.merge(n+2,1,(a,b)->a+b);
                }else{
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums=new int[]{1,2,3,3,4,5};
        isPossible(nums);
    }

}
