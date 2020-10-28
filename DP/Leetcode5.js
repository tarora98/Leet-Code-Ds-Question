class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int arr[][] = new int[n][n];
        int count = 0;
        int lenght = 0;
        int si = 0;
        int ei = 0;
        for (int gap = 0; gap < n; gap++) {
            for (int i = 0, j = gap; j < n; i++, j++) {
                if (gap == 0) {
                    arr[i][j] = 1;
                }
                else if (gap == 1) {
                    if (s.charAt(i) == s.charAt(j)) {
                        arr[i][j] = 2;
                    }
                }
                else {
                    if (s.charAt(i) == s.charAt(j) && arr[i + 1][j - 1] > 0) {
                        arr[i][j] = arr[i + 1][j - 1] + 2;
                    }
                }
                if (arr[i][j] > lenght) {
                    lenght = arr[i][j];
                    si = i;
                    ei = j;
                }
            }
        }
        return s.substring(si, ei + 1);
    }
}