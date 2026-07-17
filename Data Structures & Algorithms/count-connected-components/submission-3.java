class Solution {

    class Node {
        int val;
        List<Node> neighbors;

        Node(int val) {
            this.val = val;
            this.neighbors = new ArrayList<>();
        }
    }

    public int countComponents(int n, int[][] edges) {
        if (edges.length == 0) {
            return n;
        }
        Map<Integer, Node> map = new HashMap<>();
        for (int[] edge : edges) {
            Node firstNode = map.getOrDefault(edge[0], new Node(edge[0]));
            Node secondNode = map.getOrDefault(edge[1], new Node(edge[1]));
            firstNode.neighbors.add(secondNode);
            secondNode.neighbors.add(firstNode);
            map.put(edge[0], firstNode);
            map.put(edge[1], secondNode);
        }
        Set<Integer> visited = new HashSet<>();
        int count = 0;
        for (int[] edge : edges) {
            if (!visited.contains(edge[0])) {
                count++;
                dfs(map.get(edge[0]), visited);
            }
        }
        return Math.max(count, n-visited.size()+1);
    }

    private void dfs(Node root, Set<Integer> visited) {
        visited.add(root.val);
        for (Node neighbor : root.neighbors) {
            if (!visited.contains(neighbor.val)) {
                dfs(neighbor, visited);
            }
        }
    }
}
