class Solution {

    class Node {
        int val;
        List<Node> neighbours;

        Node(int val) {
            this.val = val;
            this.neighbours = new ArrayList<>();
        }
    }

    public int countComponents(int n, int[][] edges) {
        int result = 0;
        Map<Integer, Node> graph = buildGraph(n, edges);
        Set<Integer> visited = new HashSet<>();
        for (int i=0;i<n;i++) {
            if (!visited.contains(i)) {
                dfs(graph.get(i), visited);
                result++;
            }
        }
        return result;
    }

    private Map<Integer, Node> buildGraph(int n, int[][] edges) {
        Map<Integer, Node> graph = new HashMap<>();
        for (int i=0;i<n;i++) {
            graph.put(i, new Node(i));
        }
        for (int[] edge : edges) {
            Node node = graph.get(edge[0]);
            node.neighbours.add(graph.get(edge[1]));
            Node node2 = graph.get(edge[1]);
            node2.neighbours.add(graph.get(edge[0]));
        }
        return graph;
    }

    private void dfs(Node startNode, Set<Integer> visited) {
        visited.add(startNode.val);
        for (Node neighbour : startNode.neighbours) {
            if (!visited.contains(neighbour.val)) {
                dfs(neighbour, visited);
            }
        }
    }
}
