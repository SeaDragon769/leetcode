package basic;


import java.util.*;

public class WordBreakII_140 {
    public List<String> wordBreak(String s, List<String> wordDict) {
        WordList wordList=new WordList(wordDict);
        List<String> result=new ArrayList<>();
        StringBuilder sentence=new StringBuilder();
        Map<Integer,List<String>> allResult=new HashMap<>();
        backtrace(s,0,s.length(),wordList,result,sentence,allResult);
        return result;

    }

    private void backtrace(String s,int start,int end,WordList wordList,List<String> result,StringBuilder sentence,Map<Integer,List<String>> allResult){

        if(allResult.containsKey(start)){
            for(String sent:allResult.get(start)) {
                result.add(sentence.toString()+" "+sent);
            }
            return;
        }

        for(int i=start;i<end;i++){
            String temp=s.substring(start,i+1);
            if(temp.length()>wordList.maxLength){
                break;
            }
            if(wordList.search(temp)){
                if(i==end-1){
                    sentence.append(temp);
                    result.add(sentence.toString());
                }else {
                    int tempLen=sentence.length();
                    sentence.append(temp).append(' ');
                    backtrace(s, i + 1, end, wordList, result, sentence,allResult);
                    sentence.delete(tempLen,sentence.length());
                }
            }
        }



    }


    private class WordList{
        Set<String> set;
        int maxLength=0;
        WordList(List<String> wordDict){
            set=new HashSet<>();
            for(String word:wordDict){
                if(word.length()>maxLength){
                    maxLength=word.length();
                }
                set.add(word);
            }
        }

        private void add(String word){
            set.add(word);
        }
        private boolean search(String word){
            return set.contains(word);
        }
    }

    public static void main(String[] args) {

        String s="catsanddog";
        List<String> list=new ArrayList<>();
        list.add("cat");
        list.add("cats");
        list.add("and");
        list.add("sand");
        list.add("dog");
        WordBreakII_140 wordBreakII_140=new WordBreakII_140();
        wordBreakII_140.wordBreak(s,list);
    }

}
