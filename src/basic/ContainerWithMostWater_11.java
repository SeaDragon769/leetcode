package basic;

public class ContainerWithMostWater_11 {
    public int maxArea(int[] height) {
        if(height==null||height.length<2){
            return 0;
        }
        int left=0;
        int right=height.length-1;
        int max=0;
        while (left<right){
            max=Math.max(Math.min(height[right],height[left])*(right-left),max);
            if(height[left]<height[right]){
                left++;
            }else {
                right--;
            }
        }
        return max;


    }
}
