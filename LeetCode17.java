class LeetCode17 {
    static String[] words={"",":;/","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz","&*%","#@$","&*%"};
    public List<String> letterCombinations(String digits) {
        return solved(digits,0);
    }
    static List<String> solved(String digits,int idx){
        if(digits.length()==0){
            List<String> base=new ArrayList<String>();
            return base;
        }
        if(idx==digits.length()){
            List<String> base=new ArrayList<String>();
            base.add("");
            return base;
        }
        int chi=digits.charAt(idx)-'0';// convert string to integer
        String word=words[chi];
        int count=0;
        List<String> small=solved(digits,idx+1);
        List<String> myAns=new ArrayList<String>();
        
        for(String s:small){
            for(int i=0;i<word.length();i++){
                myAns.add(word.charAt(i)+s);
            }
        }
        return myAns;
        
        
    } 
}