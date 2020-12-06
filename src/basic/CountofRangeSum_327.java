package basic;

public class CountofRangeSum_327 {
    public int countRangeSum(int[] nums, int lower, int upper) {
        long[] sum=new long[nums.length+1];
        for(int i=0;i<nums.length;i++){
            sum[i+1]=sum[i]+nums[i];
        }
        return mergeSum(sum,lower,upper,0,sum.length-1);
    }
    private int mergeSum(long[] sums,int lower,int upper,int start,int end){
        if(start==end){
            return 0;
        }
        int result=0;
        int middle=(end+start)/2;
        int left=mergeSum(sums,lower,upper,start,middle);
        int right=mergeSum(sums,lower,upper,middle+1,end);
        result+=left;
        result+=right;
        int l=start;
        int r=start;
        for(int i=middle+1;i<=end;i++){
            while(l<=middle&&sums[i]-sums[l]>upper){
                l++;
            }
            while(r<=middle&&sums[i]-sums[r]>=lower){
                r++;
            }
            result+=r-l;
        }
        long[] sorted=new long[end-start+1];
        int k=0;
        l=start;
        r=middle+1;
        while(l<=middle||r<=end){
            if(l>middle){
                sorted[k]=sums[r];
                r++;
            }else if(r>end){
                sorted[k]=sums[l];
                l++;
            }else{
                if(sums[l]>sums[r]){
                    sorted[k]=sums[r];
                    r++;
                }else{
                    sorted[k]=sums[l];
                    l++;
                }
            }
            k++;
        }

        k=0;
        for(int i=start;i<=end;i++){
            sums[i]=sorted[k];
            k++;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums=new int[]{-2,5,-1};
        int lower=-2;
        int upper=2;
        CountofRangeSum_327 count=new CountofRangeSum_327();
        System.out.println( count.countRangeSum(nums,lower,upper));

    }

}
