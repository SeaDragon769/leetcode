package basic;

public class ReverseInt {
    public int reverse(int x) {
        boolean neg=x<0;
        if(neg){
            x=-x;
        }
        long result=0;
        while(x>0){
            result=result*10+x%10;
            x=x/10;
        }
        if(result>Integer.MAX_VALUE){
            return 0;
        }else{
            if(neg){
                return -(int)result;
            }else{
                return (int)result;
            }
        }
    }
}
