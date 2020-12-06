package basic;

import java.util.ArrayList;
import java.util.List;

public class Combinations_77 {

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> current=new ArrayList<>();
        search(result,current,n,k,1);
        return result;
    }

    private static void search(List<List<Integer>> result,List<Integer> current,int n,int k,int m){
        if(current.size()==k) {
            result.add(new ArrayList<>(current));
            return;
        }

        for(int i=m;i<=n;i++){
            current.add(i);
            search(result,current,n,k,i+1);
            current.remove(current.size()-1);
        }

    }

    public static void main(String[] args) {
        List<List<Integer>> result=combine(4,2);
        System.out.println(result.size());
    }

}
