class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> counts = new HashMap<>();
        int l=0, res=0, maxf=0;
        for (int r=0;r<s.length();r++) {
            counts.put(s.charAt(r), counts.getOrDefault(s.charAt(r), 0) + 1);
            maxf = Math.max(maxf, counts.get(s.charAt(r)));
            while(r-l+1 - maxf > k) {
                counts.put(s.charAt(l), counts.get(s.charAt(l))-1);
                l++;
            }
            res = Math.max(res, r-l+1);
        }
        return res;
    }
}
