package basic;

public class MergeSortedArray_88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int resultIndex=m+n-1;
        int index1=m-1;
        int index2=n-1;
        while(resultIndex>=0){
            if(index2<0||index1>=0&&nums1[index1]>nums2[index2]){
                nums1[resultIndex]=nums1[index1];
                index1--;
            }else{
                nums1[resultIndex]=nums2[index2];
                index2--;
            }
            resultIndex--;
        }
    }
}
