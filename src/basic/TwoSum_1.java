package basic;

import java.util.HashMap;
import java.util.Map;

public class TwoSum_1 {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] t=new int[2];
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(target-nums[i])){
                t[0]=map.get(target-nums[i]);
                t[1]=i;
            }else {
                map.put(nums[i], i);
            }
        }
        return t;

    }

    public static void main(String[] args) {
        int[] t=new int[]{2,3,3,5};
        int[] res=twoSum(t,6);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }
}
