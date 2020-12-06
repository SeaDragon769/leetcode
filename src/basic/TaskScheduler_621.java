package basic;

import java.util.Arrays;

public class TaskScheduler_621 {
    public int leastInterval(char[] tasks, int n) {
        int[] count=new int[26];

        for(char c:tasks){
            count[c-'A']++;
        }
        Arrays.sort(count);
        int sameMax=1;
        for(int i=count.length-2;i>=0;i--){
            if(count[i]==count[i+1]){
                sameMax++;
            }else{
                break;
            }
        }
        int result;
        if(n>sameMax-1){
            result=sameMax*count[count.length-1]+(count[count.length-1]-1)*(n-sameMax+1);
        }else{
            result=sameMax*count[count.length-1];
        }

        return Math.max(result,tasks.length);
    }



}
