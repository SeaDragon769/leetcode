package basic;

import java.util.HashMap;
import java.util.Map;

public class LemonadeChange_860 {

    public boolean lemonadeChange(int[] bills) {
        Map<Integer,Integer> billCount=new HashMap<>();
        for(int b:bills){
            if(b==10){
                if(billCount.getOrDefault(5,0)==0){
                    return false;
                }else{
                    billCount.computeIfPresent(5,(k,v)->v-1);
                }
            }else if(b==20){
                if(billCount.getOrDefault(10,0)>0&&billCount.getOrDefault(5,0)>0){
                    billCount.computeIfPresent(5,(k,v)->v-1);
                    billCount.computeIfPresent(10,(k,v)->v-1);
                }else if(billCount.getOrDefault(5,0)>2){
                    billCount.computeIfPresent(5,(k,v)->v-3);
                }else{
                    return false;
                }
            }
            billCount.merge(b,1,(a,c)->a+c);
        }
        return true;
    }

    public static void main(String[] args) {
        LemonadeChange_860 lemonadeChange_860=new LemonadeChange_860();
        boolean result=lemonadeChange_860.lemonadeChange(new int[]{5,5,5,10,20});
        System.out.println(result);
    }
}
