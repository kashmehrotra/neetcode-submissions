class Solution {
    public boolean isValid(String s) {
        char[] stack = new char[1001];
        int curr = 0;
        Map<Character, Character> parClose = new HashMap<>();
        parClose.put(')', '(');
        parClose.put('}', '{');
        parClose.put(']', '[');
        for (char ch : s.toCharArray()) {
            if (parClose.containsKey(ch)) {
                if (curr <= 0) {
                    return false;
                }
                if (parClose.get(ch) != stack[curr-1]) {
                    return false;
                }
                curr--;
            } else {
                stack[curr++] = ch;
            }
        }
        return curr == 0;
        // Stack<Character> stack = new Stack<>();
    }
}
