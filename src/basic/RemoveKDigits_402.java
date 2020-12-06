package basic;


import java.util.LinkedList;

public class RemoveKDigits_402 {
    //超时
    public String removeKdigits(String num, int k) {
        char[] chars=num.toCharArray();
        LinkedList<Character> list=new LinkedList<>();
        for(int i=0;i<chars.length;i++){
            list.add(chars[i]);
        }

        for(int i=0;i<k;i++){
            int start=0;
            while(start<list.size()&&list.get(start)=='0'){
                start++;
            }
            while(start<list.size()-1&&list.get(start)<=list.get(start+1)){
                start++;
            }
            if(start==list.size()){
                list.remove(start-1);
            }else if(start==list.size()-1){
                list.remove(start);
            }else if(list.get(start)>list.get(start+1)){
                list.remove(start);
            }else{
                list.remove(start+1);
            }
        }
        StringBuilder result=new StringBuilder();
        int i=0;
        while(i<list.size()&&list.get(i)=='0'){
            i++;
        }
        for(int j=i;j<list.size();j++){
            result.append(list.get(j));
        }
        if(result.length()==0){
            return "0";
        }
        return result.toString();
    }


    public String removeKdigits2(String num, int k) {
        LinkedList<Character> list=new LinkedList<>();
        for(int i=0;i<num .length();i++){
            if(list.size()==0||list.getLast()<=num.charAt(i)){
                list.addLast(num.charAt(i));
            }else{
                while(k>0&&list.size()>0&&list.getLast()>num.charAt(i)){
                    list.removeLast();
                    k--;
                }
                list.addLast(num.charAt(i));
            }
        }
        while(k>0){
            list.removeLast();
            k--;
        }
        StringBuilder result=new StringBuilder();
        while(!list.isEmpty()&&list.getFirst()=='0'){
            list.removeFirst();
        }
        while(!list.isEmpty()){
            result.append(list.poll());
        }
        if(result.length()==0){
            return "0";
        }else{
            return result.toString();
        }

    }


    public static void main(String[] args) {
        String str="10";int k=2;
        RemoveKDigits_402 removeKDigits_402=new RemoveKDigits_402();
        removeKDigits_402.removeKdigits(str,k);
    }
}
