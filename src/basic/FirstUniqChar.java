package basic;

import java.util.HashMap;

import java.util.Map;


public class FirstUniqChar {
    public int firstUniqChar(String s) {
        Map<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.merge(s.charAt(i),1,(a,b)->a+b);
        }
        for(int i=0;i<s.length();i++){
            if(map.get(s.charAt(i))==1){
                return i;
            }
        }
        return -1;
    }
}
