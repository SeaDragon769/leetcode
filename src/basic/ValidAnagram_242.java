package basic;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram_242 {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        Map<Character,Integer> count=new HashMap<>();
        for(int i=0;i<s.length();i++){
            count.merge(s.charAt(i),1,(a,b)->a+b);
        }
        for(int i=0;i<t.length();i++){
            if(count.containsKey(t.charAt(i))){
                if(count.get(t.charAt(i))==1){
                    count.remove(t.charAt(i));
                }else{
                    count.replace(t.charAt(i),count.get(t.charAt(i))-1);
                }
            }else{
                return false;
            }
        }
        return true;

    }
}
