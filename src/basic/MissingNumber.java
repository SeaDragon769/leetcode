package basic;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        int numSum=0;
        int allSum=0;
        for(int i=0;i<nums.length;i++){
            allSum+=i;
            numSum+=nums[i];
        }
        allSum+=nums.length;
        return allSum-numSum;
    }
}
