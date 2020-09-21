import java.util.*;
import java.lang.*;
import java.io.*;
public class WordBreak {
    static int solved(String input,int idx,String st,HashSet<String> word, int len){
        // Base Case
        if(idx==input.length()){
            return 1;
        }
         //Loop
        int count=0;
         for(int i=idx;i-idx<=len && i<=input.length();i++){
             String s=input.substring(idx,i);
             if(word.contains(s)){
                 count+=solved(input,i,st+s+" ",word,len);
             }
         }
        return count;
    }
    static boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> word=new HashSet<>();
        int len=0;
        for(int str=0;str<wordDict.size();str++){
         word.add(wordDict.get(str));
         String st=wordDict.get(str);
         len = Math.max(len,st.length());
        }
        int count =solved(s,0,"",word,len);
        if(count!=0){
            return true;
        }
        return false;
    }
    public static void main(String[] args){
        String s="aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
        List<String> array={"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"};
    }
}
// "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab"
