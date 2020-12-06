package basic;

import java.util.LinkedList;
import java.util.List;

public class PermutationSequence_60 {

    public String getPermutation(int n, int k) {
        int[] factor=new int[n+1];
        factor[0]=1;
        for(int i=1;i<factor.length;i++){
            factor[i]=i*factor[i-1];
        }

        List<Integer> nums=new LinkedList<>();
        for(int i=1;i<=n;i++){
            nums.add(i);
        }
        k--;
        StringBuilder result=getResult(n,k,factor,nums);

        return result.toString();

    }

    private StringBuilder getResult(int n,int k,int[] factor,List<Integer> nums){

        if(n==1){
            StringBuilder sb=new StringBuilder();
            sb.append(nums.get(0));
            return sb;
        }
        int index=k/factor[n-1];
        int rest=k%factor[n-1];

        int currentValue=nums.get(index);
        nums.remove(index);
        StringBuilder result=new StringBuilder();
        result.append(currentValue);
        result.append(getResult(n-1,rest,factor,nums));
        return result;
    }

    public static void main(String[] args) {
        PermutationSequence_60 permutationSequence=new PermutationSequence_60();
        System.out.println(permutationSequence.getPermutation(3,0));
    }


}
