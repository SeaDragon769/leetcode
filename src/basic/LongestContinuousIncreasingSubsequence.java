package basic;

public class LongestContinuousIncreasingSubsequence {
    public int findLengthOfLCIS(int[] nums) {
        int maxLen=1;

        int len=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]>nums[i-1]){
                len++;
            }else{
                if(len>maxLen){
                    maxLen=len;
                }
                len=1;
            }
        }
        return maxLen;
    }
}
