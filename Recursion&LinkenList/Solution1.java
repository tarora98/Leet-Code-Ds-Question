import java.util.*;
import java.lang.*;
import java.io.*;
class Solution1 {
    static boolean solved(String input,int idx,String st,HashSet<String> word, int len){
        // Base Case
        if(idx==input.length()){
            return true;
        }
        int count=0;
         //Loop
         for(int i=0;i-idx<=len && i<=input.length();i++){
             String s=input.substring(0,i);
             if(word.contains(s)){
                 solved(input,idx+1,st+s+" ",word,len);
                 count++;
             }
         }
        if(count==0){
        return false;
        }
        return true;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> word=new HashSet<>();
        int len=0;
        for(int str=0;str<=wordDict.size();str++){
         word.add(wordDict.get(str));
         String st=wordDict.get(str);
         len = Math.max(len,st.length());
        }
      return (solved(s,0,"",word,len));   
    }
}