package basic;

import java.util.HashSet;
import java.util.Set;

public class JewelsandStones_771 {
    public int numJewelsInStones(String J, String S) {
        Set<Character> jewels=new HashSet<>();
        for(int i=0;i<J.length();i++){
            jewels.add(J.charAt(i));
        }
        int num=0;
        for(int i=0;i<S.length();i++){
            if(jewels.contains(S.charAt(i))){
                num++;
            }
        }
        return num;
    }
}
