class Solution {
    public int lengthOfLongestSubstring2(String s) {
        Map<Character, Integer> m = new HashMap<>();
        int startPos = 0, maxLength = 0;
        for (int i=0;i<s.length();i++) {
            if (m.containsKey(s.charAt(i))) {
                maxLength = Math.max(maxLength, i-startPos);
                startPos = Math.max(startPos, m.get(s.charAt(i))+1);
            }
            m.put(s.charAt(i), i);
        }
        return Math.max(maxLength, s.length()-startPos);
    }




























    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> charPos = new HashMap<>();
        int res = 0, startPos = 0;
        for (int i=0;i<s.length();i++) {
            char ch = s.charAt(i);
            if (charPos.containsKey(ch)) {
                res = Math.max(res, i-startPos);
                startPos = Math.max(startPos, charPos.get(ch) + 1);
            }
            charPos.put(ch, i);
        }
        return Math.max(res, s.length()-startPos);
    }
}