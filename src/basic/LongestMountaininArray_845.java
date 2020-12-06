package basic;

public class LongestMountaininArray_845 {
    public static int longestMountain(int[] A) {
        int max=0;
        boolean up=false;
        boolean down=false;
        int length=0;
        for(int i=1;i<A.length;i++){
            if(A[i]>A[i-1]){
                if(up&&down){
                    if(max<length){
                        max=length;
                    }
                    down=false;
                    length=0;
                }
                up=true;
                if(length==0){
                    length=2;
                }else{
                    length++;
                }
            }else if(A[i]<A[i-1]){
                if(!up){
                    length=0;
                }else {
                    down = true;
                    length++;
                }
            }else{
                if(up&&down){
                    if(max<length){
                        max=length;
                    }
                }
                up=false;
                down=false;
                length=0;
            }
        }
        if(up&&down){
            if(max<length){
                max=length;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] input=new int[]{2,3,2,3,4,5,2};
        int result=longestMountain(input);
        System.out.println(result);
    }
}
