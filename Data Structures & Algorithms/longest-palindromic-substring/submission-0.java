class Solution {
    public String longestPalindrome(String s) {
        if (s.length() == 1) {
            return s;
        }
        String max = "";
        for (int i=0;i<s.length();i++) {
            String one = findLongestPalindromeSubstring(s, i, i);
            String two = findLongestPalindromeSubstring(s, i, i+1);
            max = max.length() > one.length() ? max : one;
            max = max.length() > two.length() ? max : two;
        }
        return max;
    }

    private String findLongestPalindromeSubstring(String s, int i, int j) {
        if (i < 0 || j <= 0 || j >= s.length()) {
            return "";
        }
        String localMax = "";
        if (s.charAt(i) == s.charAt(j)) {
            String sub = findLongestPalindromeSubstring(s, i-1, j+1);
            localMax = sub.length() > j-i+1 ? sub : s.substring(i, j+1);
        }
        return localMax;
    }
}