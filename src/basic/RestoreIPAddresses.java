package basic;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> result=new ArrayList<>();
        List<String> former=new ArrayList<>(4);
        split(s,0,4,former,result);
        return result;
    }

    private void split(String s, int start, int sepNum,List<String> former,List<String> result){
        if(sepNum==0){
            if(start==s.length()) {
                StringBuilder sb = new StringBuilder();
                for (String k : former) {
                    sb.append(k);
                    sb.append(".");
                }
                result.add(sb.substring(0, sb.length() - 1));
            }
            return ;
        }
        if(start>=s.length()||sepNum*3<s.length()-start){
            return;
        }
        for(int i=1;i<=3;i++){
            if(start+i>s.length()){
                break;
            }
            String substr=s.substring(start,i+start);
            if(Integer.parseInt(substr)<=255){
                former.add(substr);
                split(s,start+i,sepNum-1,former,result);
                former.remove(former.size()-1);
            }
            if(s.charAt(start)=='0'){
                break;
            }
        }
    }

    public static void main(String[] args) {
        String s="25525511135";
        RestoreIPAddresses res=new RestoreIPAddresses();
        List<String> result=res.restoreIpAddresses(s);
        for(String r:result){
            System.out.println(r);
        }
    }




}
