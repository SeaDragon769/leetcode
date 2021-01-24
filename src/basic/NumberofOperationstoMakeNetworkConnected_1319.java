package basic;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class NumberofOperationstoMakeNetworkConnected_1319 {


    public int makeConnected(int n, int[][] connections) {
        if(connections.length<n-1){
            return -1;
        }
        UnionSet unionSet=new UnionSet(n);
        for(int i=0;i<connections.length;i++){
            unionSet.union(connections[i][0],connections[i][1]);
        }
        return unionSet.rootNum()-1;
    }

    class UnionSet{

        int[] rank;
        int[] t;
        int count;
        UnionSet(int n){
            rank=new int[n];
            Arrays.fill(rank,1);
            t=new int[n];
            count=n;
            for(int i=0;i<t.length;i++){
                t[i]=i;
            }
        }
        int findRoot(int x){
            if(t[x]==x){
                return x;
            }
            t[x]=findRoot(t[x]);
            return t[x];
        }
        void union(int x,int y){
            int rootX=findRoot(x);
            int rootY=findRoot(y);
            if(rootX!=rootY){
                if(rank[rootX]<rank[rootY]){
                    t[rootX]=rootY;
                }else if(rank[rootX]>rank[rootY]){
                    t[rootY]=rootX;
                }else{
                    t[rootX]=rootY;
                    rank[rootY]++;
                }
                count--;
            }
        }

        int rootNum(){
//            Set<Integer> set=new HashSet<>();
//            for(int i=0;i<t.length;i++){
////                int k=findRoot(i);
//                set.add(findRoot(i));
//            }
//            return set.size();
            return count;
        }

    }

    public static void main(String[] args) {
        int[][] connections=new int[][]{{0,1},{0,2},{3,4},{2,3}};
        NumberofOperationstoMakeNetworkConnected_1319 num=new NumberofOperationstoMakeNetworkConnected_1319();
        num.makeConnected(5,connections);

    }

}
