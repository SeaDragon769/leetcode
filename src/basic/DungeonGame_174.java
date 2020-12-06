package basic;

public class DungeonGame_174 {
    public int calculateMinimumHP(int[][] dungeon) {

        if(dungeon==null||dungeon.length==0||dungeon[0].length==0){
            return 1;
        }

        int[][] minHp=new int[dungeon.length][dungeon[0].length];
        int[][] hpRemain=new int[dungeon.length][dungeon[0].length];
        minHp[0][0]=dungeon[0][0];
        hpRemain[0][0]=dungeon[0][0];
        for(int i=0;i<dungeon.length;i++){
            for(int j=0;j<dungeon[0].length;j++){
                if(i==0&&j==0){
                    continue;
                }else if(i==0){
                    hpRemain[i][j]=hpRemain[i][j-1]+dungeon[i][j];
                    if(hpRemain[i][j]>=0||dungeon[i][j]>=0){
                        minHp[i][j]=minHp[i][j-1];
                    }else{
                        minHp[i][j]=Math.min(hpRemain[i][j],hpRemain[i][j-1]);
                    }
                }else if(j==0){
                    hpRemain[i][j]=hpRemain[i-1][j]+dungeon[i][j];
                    if(hpRemain[i][j]>=0||dungeon[i][j]>=0){
                        minHp[i][j]=minHp[i-1][j];
                    }else{
                        minHp[i][j]=Math.min(hpRemain[i][j],hpRemain[i-1][j]);
                    }
                }else{
//                    if(dungeon[i][j]>=0){
                    if(minHp[i-1][j]>minHp[i][j-1]){
                        hpRemain[i][j]=hpRemain[i-1][j]+dungeon[i][j];
                        if(hpRemain[i][j]>=0||dungeon[i][j]>=0){
                            minHp[i][j]=minHp[i-1][j];
                        }else{
                            minHp[i][j]=Math.min(hpRemain[i][j],hpRemain[i-1][j]);
                        }

                    }else{
                        hpRemain[i][j]=hpRemain[i][j-1]+dungeon[i][j];
                        if(hpRemain[i][j]>=0||dungeon[i][j]>=0){
                            minHp[i][j]=minHp[i][j-1];
                        }else{
                            minHp[i][j]=Math.min(hpRemain[i][j],hpRemain[i][j-1]);
                        }
                    }
//                    }
                }
            }
        }
        int result=minHp[dungeon.length-1][dungeon[0].length-1];
        if(result>0){
            return 1;
        }else{
            return 1-result;
        }

    }

    public static void main(String[] args) {
//        int [][] input=new int[][]{{-2,-3,3},{-5,-10,1},{10,30,-5}};
        int [][] input=new int[][]{{1,-3,3},{0,-2,0},{-3,-3,-3}};

        DungeonGame_174 d=new DungeonGame_174();
        System.out.println(d.calculateMinimumHP(input));
    }

}
