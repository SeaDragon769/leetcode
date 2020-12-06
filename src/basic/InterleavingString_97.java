package basic;

public class InterleavingString_97 {

    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1==null||s2==null||s3==null){
            return false;
        }
        if(s3.length()!=s1.length()+s2.length()){
            return false;
        }

        int[][] flag=new int[s1.length()+1][s2.length()+1];
        flag[0][0]=1;
        for(int i=0;i<s1.length();i++){
            if(s1.substring(0,i+1).equals(s3.substring(0,i+1))){
                flag[i+1][0]=1;
            }else{
                flag[i+1][0]=-1;
            }
        }

        for(int j=0;j<s2.length();j++){
            if(s2.substring(0,j+1).equals(s3.substring(0,j+1))){
                flag[0][j+1]=1;
            }else{
                flag[0][j+1]=-1;
            }
        }

        bp(s1,s1.length(),s2,s2.length(),s3,flag);

        return flag[s1.length()][s2.length()]==1;
    }

    private void bp(String s1,int n,String s2,int m,String s3,int[][] flag){
        if(n<=0||m<=0||flag[n][m]!=0){
            return;
        }
        if(s1.charAt(n-1)!=s3.charAt(m+n-1)&&s2.charAt(m-1)!=s3.charAt(m+n-1)){
            flag[n][m]=-1;
        }else if(s1.charAt(n-1)==s3.charAt(m+n-1)&&s2.charAt(m-1)!=s3.charAt(m+n-1)){
            bp(s1,n-1,s2,m,s3,flag);
            flag[n][m]=flag[n-1][m];
        }else if(s1.charAt(n-1)!=s3.charAt(m+n-1)&&s2.charAt(m-1)==s3.charAt(m+n-1)){
            bp(s1,n,s2,m-1,s3,flag);
            flag[n][m]=flag[n][m-1];
        }else{
            bp(s1,n-1,s2,m,s3,flag);
            bp(s1,n,s2,m-1,s3,flag);
            if(flag[n-1][m]==1||flag[n][m-1]==1){
                flag[n][m]=1;
            }else{
                flag[n][m]=-1;
            }
        }
    }


    public static void main(String[] args) {
        String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac";
        InterleavingString_97 i=new InterleavingString_97();
        System.out.println(i.isInterleave(s1,s2,s3));
    }



}
