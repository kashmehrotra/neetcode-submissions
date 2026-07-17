class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        Map<Character, Integer> map = new HashMap<>();
        for (char ch: t.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        int left=0, minLeft=0, minRight = Integer.MAX_VALUE, targetCharRem = t.length();
        for(int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            if (map.containsKey(ch)) {
                if (map.get(ch) > 0) {
                    targetCharRem--;
                }
                map.put(ch, map.get(ch)-1);
            }
            while (targetCharRem == 0) {
                char chAtLeft = s.charAt(left);
                if (map.containsKey(chAtLeft)) {
                    if (map.get(chAtLeft) == 0) {
                        if (right-left < minRight-minLeft) {
                            minLeft = left;
                            minRight = right;
                        }
                        targetCharRem++;
                    }
                    map.put(chAtLeft, map.get(chAtLeft)+1);
                }
                left++;
            }
        }
        return minRight >= s.length() ? "" : s.substring(minLeft, minRight+1);
    }
}