package basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionofTwoArraysII_350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i:nums2){
            if(map.containsKey(i)){
                map.put(i,map.get(i)+1);
            }else{
                map.put(i,1);
            }
        }
        List<Integer> res=new ArrayList<>();
        for(int i:nums1){
            if(map.containsKey(i)){
                res.add(i);
                if(map.get(i)==1){
                    map.remove(i);
                }else{
                    map.put(i,map.get(i)-1);
                }
            }
        }
        int[] arrRes=new int[res.size()];
        for(int i=0;i<res.size();i++){
            arrRes[i]=res.get(i);
        }
        return arrRes;
    }
}
