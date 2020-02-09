package basic;

public class PlusOne_66 {
    public int[] plusOne(int[] digits) {
        if(digits[digits.length-1]!=9){
            digits[digits.length-1]=digits[digits.length-1]+1;
            return digits;
        }
        boolean all9=true;
        for(int i:digits){
            if(i!=9){
                all9=false;
                break;
            }
        }
        if(all9){
            int[] res=new int[digits.length+1];
            res[0]=1;
            return res;
        }else{
            int n=digits.length-1;
            while(digits[n]==9){
                digits[n]=0;
                n--;
            }
            digits[n]=digits[n]+1;
        }
        return digits;
    }
}
