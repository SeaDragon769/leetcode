package basic;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class KClosestPointstoOrigin_973 {

    public int[][] kClosest(int[][] points, int K) {
        Queue<int[]> q = new PriorityQueue<>(K+1, (a, b)->{
            return a[1]-b[1];
        });
        for(int i=0;i<points.length;i++){
            q.offer(new int[]{i,points[i][0]*points[i][0]+points[i][1]*points[i][1]});
            if(q.size()>K){
                q.poll();
            }
        }
        int[][] result=new int[K][];
        for(int i=0;i<K;i++){
            result[i]=points[q.poll()[0]];
        }
        return result;
    }



}
