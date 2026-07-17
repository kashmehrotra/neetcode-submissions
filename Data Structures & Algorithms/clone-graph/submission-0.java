/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Node result = new Node(node.val);
        Node[] visited = new Node[101];
        Arrays.fill(visited, null);
        dfs(node, result, visited);
        return result;
    }

    private void dfs(Node node, Node result, Node[] visited) {
        visited[result.val] = result;
        for (Node neighbor : node.neighbors) {
            if (visited[neighbor.val] == null) {
                Node newNode = new Node(neighbor.val);
                result.neighbors.add(newNode);
                dfs(neighbor, newNode, visited);
            } else {
                result.neighbors.add(visited[neighbor.val]);
            }
        }
    }
}