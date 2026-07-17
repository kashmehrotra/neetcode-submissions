class Solution {
    public String longestPalindrome(String s) {
        String max = "";
        for (int i=0;i<s.length();i++) {
            String one = checkPalindrome(s, i, i+1);
            String two = checkPalindrome(s, i, i);
            max = max.length() > one.length() ? max : one;
            max = max.length() > two.length() ? max : two;
        }
        return max;
    }

    private String checkPalindrome(String s, int l, int r) {
        if (l < 0 || r >= s.length()) {
            return "";
        }
        String localMax = "";
        if (s.charAt(l) == s.charAt(r)) {
            String sub = checkPalindrome(s, l-1, r+1);
            localMax = sub.length() > r-l+1 ? sub : s.substring(l, r+1);
        }
        return localMax;
    }
}
