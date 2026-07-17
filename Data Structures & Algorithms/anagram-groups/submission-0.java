class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> result = new HashMap<>();
        for (String str : strs) {
            String s = sort(str);
            List<String> anagrams = result.getOrDefault(s, new ArrayList<>());
            anagrams.add(str);
            result.put(s, anagrams);
        }
        return new ArrayList(result.values());
    }

    String sort(String str) {
        char[] charArr = new char[26];
        for (char ch: str.toCharArray()) {
            charArr[ch-'a']++;
        }
        return new String(charArr);
    }
}