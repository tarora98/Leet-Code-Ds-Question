class AtLeastK {
    public int longestSubstring(String s, int k) {
        boolean valid = true;
        int start = 0;
        int maxlen = 0;
        int freq[] = new int[26];
        char str[] = s.toCharArray();
        
        for(char c : str){
            int index = c - 'a';
            freq[index]++;
        }
        
        for(int end=0;end<s.length();end++){
            if(freq[str[end] - 'a'] > 0 && freq[str[end] - 'a'] < k) {
                String maxstring = s.substring(start, end);
                maxlen = Math.max(maxlen, longestSubstring(maxstring, k));        
                valid = false;
                start = end + 1;
            }
        }
        
        if(valid) {
            return s.length();
        } else {
            return Math.max(maxlen, longestSubstring(s.substring(start), k));
        }
    }
}       