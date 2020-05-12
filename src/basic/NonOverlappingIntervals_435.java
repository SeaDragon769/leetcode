package basic;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals_435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length==0){
            return 0;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1],o2[1]);
            }
        });
        int[] pre=intervals[0];
        int removeNum=0;
        for(int i=1;i<intervals.length;i++){
            int[] cur=intervals[i];
            if(cur[0]<pre[1]){
                removeNum++;
            }else{
                pre=cur;
            }
        }
        return removeNum;
    }
}
