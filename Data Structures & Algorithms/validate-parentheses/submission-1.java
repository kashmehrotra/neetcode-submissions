class Solution {
    public boolean isValid(String s) {
        char[] stack = new char[1001];
        int curr = 0;
        Map<Character, Character> par = new HashMap<>();
        par.put('(', ')');
        par.put('{', '}');
        par.put('[', ']');
        Map<Character, Character> parClose = new HashMap<>();
        parClose.put(')', '(');
        parClose.put('}', '{');
        parClose.put(']', '[');
        // Set<Pair<Character, Character>>> openClose = new HashSet<>();
        // openClose.add(new Pair<>('(', ')'));
        // // open.add('{');
        // // open.add('[');
        // Set<Character> close = new HashSet<>();
        // close.add(')');
        // close.add('}');
        // close.add(']');
        for (char ch : s.toCharArray()) {
            if (par.containsKey(ch)) {
                stack[curr++] = ch;
            } else {
                if (curr <= 0) {
                    return false;
                }
                if (parClose.get(ch) != stack[curr-1]) {
                    return false;
                }
                curr--;
            }
        }
        return curr == 0;
        // Stack<Character> stack = new Stack<>();
    }
}
