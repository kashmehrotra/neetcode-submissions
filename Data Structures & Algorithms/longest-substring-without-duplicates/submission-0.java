class Solution {
    public int lengthOfLongestSubstring(String s) {
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
}