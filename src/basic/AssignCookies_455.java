package basic;

import java.util.Arrays;

public class AssignCookies_455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int num=0;
        int gi=0;
        int si=0;
        while(gi<g.length&&si<s.length){
            if(s[si]>=g[gi]){
                si++;
                gi++;
                num++;
            }else{
                si++;
            }
        }
        return num;
    }
}
