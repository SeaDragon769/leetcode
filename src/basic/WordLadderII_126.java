package basic;

import java.util.*;

public class WordLadderII_126 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result=new ArrayList<>();
        if(wordList.size()==0||!wordList.contains(endWord)){
            return result;
        }

        Map<String, Set<String>> wordGraph=new HashMap<>();

        for(int i=0;i<wordList.size();i++){
            if(wordDistance(beginWord,wordList.get(i))==1){
                if(wordGraph.containsKey(beginWord)){
                    wordGraph.get(beginWord).add(wordList.get(i));
                }else{
                    Set<String> set=new HashSet<>();
                    set.add(wordList.get(i));
                    wordGraph.put(beginWord,set);
                }
            }
            for(int j=0;j<wordList.size();j++){
                if(j==i){
                    continue;
                }
                if(wordDistance(wordList.get(i),wordList.get(j))==1){
                    if(wordGraph.containsKey(wordList.get(i))){
                        wordGraph.get(wordList.get(i)).add(wordList.get(j));
                    }else{
                        Set<String> set=new HashSet<>();
                        set.add(wordList.get(j));
                        wordGraph.put(wordList.get(i),set);
                    }
                }
            }
        }

        Queue<String> queue=new LinkedList<>();
        queue.add(beginWord);
        Map<String,List<List<String>>> nodePath=new HashMap<>();

        Set<String> searched=new HashSet<>();
        nodePath.put(beginWord,null);

        while(!queue.isEmpty()){

            String word=queue.poll();
            searched.add(word);
            List<List<String>> allPath=nodePath.get(word);

            if(word.equals(endWord)){
                if(result.size()==0){
                    for(int i=0;i<allPath.size();i++){
                        if(i>0){
                            if(allPath.get(i).size()==result.get(0).size()-1){
                                List<String> temp=new ArrayList<>(allPath.get(i));
                                temp.add(word);
                                result.add(temp);
                            }
                        }else {
                            List<String> temp=new ArrayList<>(allPath.get(i));
                            temp.add(word);
                            result.add(temp);
                        }

                    }

                }else{
                    List<String> path0=result.get(0);
                    if(allPath.get(0).size()==path0.size()-1){
                        for(List<String> list:allPath){
                            List<String> temp=new ArrayList<>(list);
                            temp.add(word);
                            result.add(temp);
                        }
                    }
                }
            }else{
                List<List<String>> parentPath=new ArrayList<>();
                if(allPath==null){
                    parentPath=new ArrayList<>();
                    List<String> temp=new ArrayList<>();
                    temp.add(word);
                    parentPath.add(temp);
                }else{
                    for(List<String> list:allPath){
                        List<String> temp=new ArrayList<>(list);
                        temp.add(word);
                        parentPath.add(temp);
                    }
                }
                if(wordGraph.containsKey(word)) {
                    for (String next : wordGraph.get(word)) {
                        if (!searched.contains(next)) {
                            if (nodePath.containsKey(next)) {
                                nodePath.get(next).addAll(parentPath);
                            } else {
                                nodePath.put(next, parentPath);
                            }
                            if (!queue.contains(next)) {
                                queue.add(next);
                            }
                        }
                    }
                }

            }
        }
        return result;
    }
    private int wordDistance(String w1,String w2){
        int distance=0;
        for(int i=0;i<w1.length();i++){
            if(w1.charAt(i)!=w2.charAt(i)){
                distance++;
            }
        }
        return distance;
    }

    public static void main(String[] args) {
        String beginWord = "red";
        String endWord = "tax";

        List<String> wordList =Arrays.asList(new String[]{"ted","tex","red","tax","tad","den","rex","pee"});


        WordLadderII_126 w=new WordLadderII_126();
        List<List<String>> result=w.findLadders(beginWord,endWord,wordList);
        System.out.println(result.size());

    }



}
