package basic;



import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ReverseWordsinaStringIII_557 {

    public String reverseWords(String s) {
        String[]  words=s.split(" ");

        List<String> reversed=Arrays.stream(words).map(str->reverse(str)).collect(Collectors.toList());

        StringBuilder result=new StringBuilder();
        for(int i=0;i<reversed.size();i++){
            result.append(reversed.get(i));
            if(i!=reversed.size()-1){
                result.append(' ');
            }
        }
        return result.toString();
    }


    private String reverse(String s){
        char[] chars=s.toCharArray();
        StringBuilder stringBuilder=new StringBuilder();

        for(int i=chars.length-1;i>=0;i--){
            stringBuilder.append(chars[i]);
        }
        return stringBuilder.toString();

    }

}
