package basic;

public class ReversePairs_493 {
    public int reversePairs(int[] nums) {
        if(nums==null||nums.length<=1){
            return 0;
        }
        return mergeCount(nums,0,nums.length-1);
    }

    private int mergeCount(int[] nums ,int start,int end){
        if(start==end){
            return 0;
        }
        int result=0;
        int middle=(start+end)/2;
        int left=mergeCount(nums,start,middle);
        int right=mergeCount(nums,middle+1,end);
        result+=left+right;
        int r=middle+1;
        for(int i=start;i<=middle;i++){
            while(r<=end&&(long)nums[i]>(long)nums[r]*2){
                r++;
            }
            result+=r-(middle+1);
        }
        int[] sorted=new int[end-start+1];
        int k=0;
        int l=start;
        r=middle+1;
        while(l<=middle||r<=end){
            if(l>middle){
                sorted[k]=nums[r];
                r++;
            }else if(r>end){
                sorted[k]=nums[l];
                l++;
            }else{
                if(nums[l]>nums[r]){
                    sorted[k]=nums[r];
                    r++;
                }else{
                    sorted[k]=nums[l];
                    l++;
                }
            }
            k++;
        }
        k=0;
        for(int i=start;i<=end;i++){
            nums[i]=sorted[k];
            k++;
        }
        return result;
    }


}

