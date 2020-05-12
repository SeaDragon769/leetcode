package basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsPhoneNumber_17 {
    private Map<Character,String> digitLetter=new HashMap<>();
    private void setString(){
        digitLetter.put('2',"abc");
        digitLetter.put('3',"def");
        digitLetter.put('4',"ghi");
        digitLetter.put('5',"jkl");
        digitLetter.put('6',"mno");
        digitLetter.put('7',"pqrs");
        digitLetter.put('8',"tuv");
        digitLetter.put('9',"wxyz");
    }
    private String getString(char c){
        if(digitLetter.containsKey(c)){
            return digitLetter.get(c);
        }
        return null;
    }

    public List<String> letterCombinations(String digits) {
        setString();
        return addAll(digits,0);
    }
    private List<String> addAll(String digits,int digitIndex){
        if(digitIndex>=digits.length()){
            return new ArrayList<>();
        }
        String chars=getString(digits.charAt(digitIndex));
        List<String> result=new ArrayList<>();
        List<String> next=addAll(digits,digitIndex+1);
        if(chars!=null){
            for(int i=0;i<chars.length();i++){
                if(next.size()>0) {
                    for (String s : next) {
                        result.add(chars.charAt(i) + s);
                    }
                }else{
                    result.add(String.valueOf(chars.charAt(i)));
                }
            }
        }else{
            result=next;
        }
        return result;
    }

    public static void main(String[] args) {
        LetterCombinationsPhoneNumber_17 l=new LetterCombinationsPhoneNumber_17();
        String s="23";
        List<String> result=l.letterCombinations(s);
        for(String sd:result){
            System.out.println(sd);
        }
    }

}