package basic;

public class SingleNumber_136 {
    public int singleNumber(int[] nums) {
        int s=nums[0];
        for(int i=1;i<nums.length;i++){
            s=s^nums[i];
        }
        return s;
    }
}
