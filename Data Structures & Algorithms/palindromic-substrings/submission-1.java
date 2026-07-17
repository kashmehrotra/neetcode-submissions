class Solution {
    public int countSubstrings(String s) {
        int res = s.length();
        for (int i=0;i<s.length()-1;i++) {
            int even = countPalindromes(s, i, i+1);
            int odd = countPalindromes(s, i-1, i+1);
            res += even + odd;
        }
        return res;
    }

    public int countPalindromes(String s, int left, int right) {
        int count = 0;
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
        return count;
    }
}
