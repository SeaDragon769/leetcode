package basic;


import java.util.HashSet;
import java.util.Set;

public class NumberofProvinces_547 {
    public int findCircleNum(int[][] isConnected) {
        UnionSearch unionSearch=new UnionSearch(isConnected.length);
        for(int i=0;i<isConnected.length;i++){
            for(int j=i+1;j<isConnected.length;j++){
                if(isConnected[i][j]==1){
                    unionSearch.union(i,j);
                }
            }
        }

        return unionSearch.groupNum();
    }

    class UnionSearch{
        int[] data;
        UnionSearch(int num){
            this.data=new int[num];
            for(int i=0;i<data.length;i++){
                data[i]=i;
            }
        }

        int find(int x){
            if(data[x]==x){
                return x;
            }else{
                return find(data[x]);
            }
        }

        void union(int x,int y){
            int xRoot=find(x);
            int yRoot=find(y);
            if(xRoot!=yRoot){
                data[yRoot]=xRoot;
            }
        }

        int groupNum(){
            Set<Integer> set=new HashSet<>();
            for(int i=0;i<data.length;i++){
                set.add(find(i));
            }
            return set.size();
        }

    }

    public static void main(String[] args) {

        int[][] nums=new int[][]{{1,0,0,1},{0,1,1,0},{0,1,1,1},{1,0,1,1}};
        NumberofProvinces_547 numberofProvinces_547=new NumberofProvinces_547();
        System.out.println(numberofProvinces_547.findCircleNum(nums));
    }

}
