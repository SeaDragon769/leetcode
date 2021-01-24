package basic;



import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class RemoveDuplicateLetters_316 {
    public static String removeDuplicateLetters(String s) {
        int[] lastIndex=new int[26];
        for(int i=0;i<s.length();i++){
            lastIndex[s.charAt(i)-'a']=i;
        }
        LinkedList<Character> stack=new LinkedList<>();
        Set<Character> allSet=new HashSet<>();
        for(int i=0;i<s.length();i++){
            if(allSet.contains(s.charAt(i))){
                continue;
            }
            while(!stack.isEmpty()){
                if(stack.getLast()>s.charAt(i)&&lastIndex[stack.getLast()-'a']>i){
                    allSet.remove(stack.pollLast());
                }else{
                    break;
                }
            }
            if(!allSet.contains(s.charAt(i))) {
                stack.addLast(s.charAt(i));
                allSet.add(s.charAt(i));
            }
        }
        StringBuilder sb=new StringBuilder();
        for(char c:stack){
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicateLetters("abacb"));
    }
}
