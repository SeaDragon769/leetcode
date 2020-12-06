package basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum_18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);

        List<Integer> solution=new ArrayList<>();
        List<List<Integer>> result=new ArrayList<>();

        backtrace(nums,target,solution,result,1,0);

        return result;
    }

    private void backtrace(int[] nums,int target,List<Integer> solution,List<List<Integer>> result,int k,int index){
        if(index>=nums.length){
            return;
        }
        if(k==4){
            for(int i=index;i<nums.length;i++){
                if(target>=0&&target<nums[i]){
                    break;
                }
                if(i>index&&nums[i]==nums[i-1]){
                    continue;
                }
                if(nums[i]==target){
                    solution.add(nums[i]);
                    result.add(new ArrayList<>(solution));
                    solution.remove(solution.size()-1);
                }
            }


            return;
        }
        if(target>=0&&target<nums[index]){
            return;
        }
        for(int i=index;i<nums.length;i++){
            if(target>=0&&target<nums[i]){
                break;
            }
            if(i>index&&nums[i]==nums[i-1]){
                continue;
            }
            solution.add(nums[i]);
            backtrace(nums,target-nums[i],solution,result,k+1,i+1);
            solution.remove(solution.size()-1);
        }

    }

    public static void main(String[] args) {
        FourSum_18 fourSum_18=new FourSum_18();
        int[] nums=new int[]{1,-2,-5,-4,-3,3,3,5};
        int target=-11;
        fourSum_18.fourSum(nums,target);
    }


}
