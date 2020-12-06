package basic;

public class WildcardMatching_44 {

    public boolean isMatch(String s, String p) {
       if(s==null||p==null){
           return false;
       }
       if(s.length()==0&&p.length()==0){
           return true;
       }
       if(s.length()==0){
           return allStar(p);
       }
       if(p.length()==0){
          return false;
       }

       boolean [][] result=new boolean[s.length()][p.length()];
       result[0][0]=p.charAt(0)=='*'||p.charAt(0)=='?'||p.charAt(0)==s.charAt(0);
       for(int i=1;i<s.length();i++){
           result[i][0]=p.charAt(0)=='*';
       }
       for(int j=1;j<p.length();j++){
           if(s.charAt(0)==p.charAt(j)||p.charAt(j)=='?'){
               result[0][j]=allStar(p.substring(0,j));
           }else if(p.charAt(j)=='*'){
               result[0][j]=result[0][j-1];
           }else{
               result[0][j]=false;
           }
       }

       for(int i=1;i<s.length();i++){
           for(int j=1;j<p.length();j++){
               if(s.charAt(i)==p.charAt(j)||p.charAt(j)=='?'){
                   result[i][j]=result[i-1][j-1];
               }else if(p.charAt(j)=='*'){
                   result[i][j]=result[i][j-1]||result[i-1][j];
//                   boolean temp=false;
//                   for(int k=0;k<=i;k++){
//                       if(result[k][j-1]){
//                           temp=true;
//                       }
//                   }
//                   result[i][j]=temp;
               }else{
                   result[i][j]=false;
               }
           }
       }
       return result[s.length()-1][p.length()-1];

    }

    private boolean allStar(String p){
        if(p==null||p.length()==0){
            return false;
        }
        for(char c:p.toCharArray()){
            if('*'!=c){
                return false;
            }
        }
        return true;
    }

}
