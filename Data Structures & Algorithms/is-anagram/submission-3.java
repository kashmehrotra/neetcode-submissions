class Solution {
    public boolean isAnagram0(String s, String t) {
        int[] freqMap = new int[26];
        for (char ch : s.toCharArray()) {
            freqMap[ch-'a']++;
        }
        for (char ch : t.toCharArray()) {
            freqMap[ch-'a']--;
        }
        for (int i=0;i<26;i++) {
            if (freqMap[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char ch : s.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }
        for (char ch : t.toCharArray()) {
            if (!freqMap.containsKey(ch)) {
                return false;
            }
            int freq = freqMap.get(ch);
            freq--;
            if (freq == 0) {
                freqMap.remove(ch);
            } else {
                freqMap.put(ch, freq);
            }
        }
        if (freqMap.size() == 0) {
            return true;
        }
        return false;
    }

    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> letterCount = new HashMap<>();
        for (char c : s.toCharArray()) {
            letterCount.put(c, letterCount.getOrDefault(c, 0) + 1);
        }
        for (char c : t.toCharArray()) {
            if (!letterCount.containsKey(c)) {
                return false;
            }
            int count = letterCount.get(c);
            if (count == 1) {
                letterCount.remove(c);
            } else {
                letterCount.put(c, count-1);
            }
        }
        return letterCount.isEmpty();
    }

    public boolean isAnagram3(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] letterCount = new int[26];
        Arrays.fill(letterCount, 0);
        s = s.toLowerCase();
        t = t.toLowerCase();
        for (char c : s.toCharArray()) {
            letterCount[c-'a'] = letterCount[c-'a'] + 1;
        }
        for (char c : t.toCharArray()) {
            int count = letterCount[c-'a'];
            if (count == 0) {
                return false;
            }
            letterCount[c-'a'] = count-1;
        }
        for (int i=0;i<26;i++) {
            if (letterCount[i] > 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] sch = s.toCharArray();
        char[] tch = t.toCharArray();
        Arrays.sort(sch);
        Arrays.sort(tch);
        for (int i=0;i<sch.length;i++) {
            if (sch[i] != tch[i]) {
                return false;
            }
        }
        return true;
    }
}



























