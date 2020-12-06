package basic;

public class TwoSumII_167 {
    public int[] twoSum(int[] numbers, int target) {
        if(numbers==null||numbers.length<2){
            return null;
        }
        int[] result=new int[2];
        int start=0;
        int end=numbers.length-1;
        while (start<end){
            if(numbers[start]+numbers[end]==target){
                break;
            }else if(numbers[start]+numbers[end]<target){
                start++;
            }else {
                end--;
            }
        }
        result[0]=start+1;
        result[1]=end+1;
        return result;
    }
}
