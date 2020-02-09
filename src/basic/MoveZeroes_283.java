package basic;


public class MoveZeroes_283 {
    public void moveZeroes(int[] nums) {
        int noZeroIndex=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                if(noZeroIndex!=i){
                    nums[noZeroIndex]=nums[i];
                }
                noZeroIndex++;
            }
        }
        for(int i=noZeroIndex;i<nums.length;i++){
            nums[i]=0;
        }
    }
}
