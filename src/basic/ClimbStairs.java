package basic;

public class ClimbStairs {
    public int climbStairs(int n) {
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        int a=1;
        int b=2;
        int result=a+b;
        for(int i=3;i<=n;i++){
            result=a+b;
            a=b;
            b=result;
        }
        return result;
    }

    public static void main(String[] args) {
        ClimbStairs climbStairs=new ClimbStairs();
        System.out.println(climbStairs.climbStairs(3));
    }

}
