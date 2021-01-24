package basic;

public class StrToInt {
    public int myAtoi(String s) {
        int i=0;
        while(i<s.length()&&s.charAt(i)==' '){
            i++;
        }
        if(i<s.length()&&(s.charAt(i)=='+'||s.charAt(i)=='-'||s.charAt(i)>='0'&&s.charAt(i)<='9')){
            int result=0;
            boolean neg=false;
            if(s.charAt(i)=='-'){
                neg=true;
                i++;
            }else if(s.charAt(i)=='+'){
                i++;
            }
            while(i<s.length()&&s.charAt(i)>='0'&&s.charAt(i)<='9'){
                if(result>(Integer.MAX_VALUE-(s.charAt(i)-'0'))/10){
                    if(neg){
                        return Integer.MIN_VALUE;
                    }else{
                        return Integer.MAX_VALUE;
                    }
                }else{
                    result=result*10+s.charAt(i)-'0';
                }
                i++;
            }
            if(neg){
                return -result;
            }else{
                return result;
            }
        }else{
            return 0;
        }

    }
}
