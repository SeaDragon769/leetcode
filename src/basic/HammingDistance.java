package basic;

public class HammingDistance {
    public int hammingDistance(int x, int y) {
        int c=x^y;
        int result=0;
        while(c!=0){
            c=c&(c-1);
            result++;
        }
        return result;
    }
}
