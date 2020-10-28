class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        boolean arr[][] = new boolean[n][n];
        int count = 0;
        for (int gap = 0; gap < n; gap++) {
            for (int i = 0, j = gap; j < n; i++, j++) {
                if (gap == 0) {
                    arr[i][j] = true;
                    count++;
                }
                else if (gap == 1) {
                    if (s.charAt(i) == s.charAt(j)) {
                        count++;
                        arr[i][j] = true;
                    }
                }
                else {
                    if (s.charAt(i) == s.charAt(j) && arr[i + 1][j - 1]) {
                        arr[i][j] = true;
                        count++;
                    }
                }
            }
        }
        return count;
    }
}

