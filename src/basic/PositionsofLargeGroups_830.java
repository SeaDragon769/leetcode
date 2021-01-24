package basic;

import java.util.ArrayList;
import java.util.List;

public class PositionsofLargeGroups_830 {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> result=new ArrayList<>();

        int startIndex=0;
        while(startIndex<s.length()){
            int i=startIndex+1;
            while(i<s.length()&&s.charAt(i)==s.charAt(startIndex)){
                i++;
            }
            if(i-startIndex>3){
                List<Integer> large=new ArrayList<>();
                large.add(startIndex);
                large.add(i-1);
                result.add(large);
            }

            startIndex=i;

        }
        return result;


    }
}
