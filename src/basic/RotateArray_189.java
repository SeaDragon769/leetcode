package basic;

public class RotateArray_189 {
    class Solution {
        public void rotate(int[] nums, int k) {
            k=k%nums.length;
            for(int i=0;i<k;i++){
                rotateOne(nums);
            }
        }
        private void rotateOne(int[] nums){
            int last=nums[nums.length-1];
            for(int i=nums.length-1;i>=1;i--){
                nums[i]=nums[i-1];
            }
            nums[0]=last;
        }
    }
    public static class Solution2{
        public void rotate(int[] nums, int k) {
            k=k%nums.length;
            if(k==0){
                return;
            }
            int count=0;
            for(int i=0;count<nums.length;i++){
                int next=(i+k)%nums.length;
                int t=nums[i];
                while(i!=next){
                    int temp=nums[next];
                    nums[next]=t;
                    t=temp;
                    next=(next+k)%nums.length;
                    count++;
                }
                count++;
                nums[next]=t;
            }
        }
    }

    public static void main(String[] args) {
        Solution2 s=new RotateArray_189.Solution2();
        int[] input=new int[]{1,2,3,4,5,6};
        s.rotate(input,2);
    }
}
