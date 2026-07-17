class Solution {

    class Node {
        char val;
        List<Node> neighbours;
        List<Node> parents;

        Node(char val) {
            this.val = val;
            this.neighbours = new ArrayList<>();
            this.parents = new ArrayList<>();
        }

        void addNeighbours(Node neighbour) {
            this.neighbours.add(neighbour);
            neighbour.parents.add(this);
        }
    }

    // private void printMap(Map<Character, Node> map) {
    //     for (Map.Entry<Character, Node> entry : map.entrySet()) {
    //         for (Node ch : entry.getValue().neighbours) {
    //             System.out.println(entry.getKey() + " " + ch.val);
    //         }
    //     }
    //     System.out.println("-------");
    // }

    public String foreignDictionary(String[] words) {
        if (words.length == 1) {
            return words[0];
        }

        Map<Character, Node> map = new HashMap<>();

        for (int i=0;i<words.length-1;i++) {
            String firstWord = words[i];
            String secondWord = words[i+1];
            for (Character ch : firstWord.toCharArray()) {
                map.putIfAbsent(ch, new Node(ch));
            }
            for (Character ch : secondWord.toCharArray()) {
                map.putIfAbsent(ch, new Node(ch));
            }
            if (secondWord.startsWith(firstWord)) {
                continue;
            }
            int k=0;
            while (k < Math.min(firstWord.length(), secondWord.length()) && firstWord.charAt(k) == secondWord.charAt(k)) {
                k++;
            }
            if (k == secondWord.length()) {
                return "";
            }
            if (!combine(map, firstWord.charAt(k), secondWord.charAt(k))) {
                return "";
            }
            // printMap(map);
        }
        return fetchResult(words[0].charAt(0), map);
    }

    private boolean combine(Map<Character, Node> map, char fch, char sch) {
        Set<Character> visited = new HashSet<>();
        if (isSmaller(map, sch, fch, visited)) {
            return false;
        }
        if (!isSmaller(map, fch, sch, visited)) {
            map.get(fch).addNeighbours(map.get(sch));
        }
        return true;
    }

    private boolean isSmaller(Map<Character, Node> map, char fch, char sch, Set<Character> visited) {
        visited.add(fch);
        for (Node neighbour : map.get(fch).neighbours) {
            if (!visited.contains(neighbour.val)) {
                if (neighbour.val == sch) {
                    return true;
                }
                if (isSmaller(map, neighbour.val, sch, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private String fetchResult(char startChar, Map<Character, Node> map) {
        StringBuilder sb = new StringBuilder();
        Set<Character> visited = new HashSet<>();
        // System.out.println("~~~~~~");
        // printMap(map);
        build(startChar, map, visited, sb);
        for (Character ch : map.keySet()) {
            build(ch, map, visited, sb);
        }
        return sb.toString();
    }

    private void build(char ch, Map<Character, Node> map, Set<Character> visited, StringBuilder sb) {
        if (visited.contains(ch)) {
            return;
        }
        for (Node parent : map.get(ch).parents) {
            if (!visited.contains(parent.val)) {
                return;
            }
        }
        visited.add(ch);
        sb.append(ch);
        for (Node node : map.get(ch).neighbours) {
            build(node.val, map, visited, sb);
        }
    }
}

// h -> e -> r -> n -> f


// words=["hrn","hrf", "en", "enr", "ene"]
// n -> f
// h -> e
// r -> e
