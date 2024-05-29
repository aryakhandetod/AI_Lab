import java.util.*;

public class idfs {
    private static class Node
    {
        int value;
        List<Node> neighbors;

        public Node(int value) {
            this.value = value;
            this.neighbors = new ArrayList<>();
        }
    }

    public static boolean iddfs(Node start, Node target, int maxDepth) 
    {
        for (int depth = 0; depth <= maxDepth; depth++) {
            if (dfs(start, target, depth)) {
                return true;
            }
        }
        return false;
    }

    private static boolean dfs(Node node, Node target, int depth) 
    {
        if (depth == 0 && node == target) {
            return true;
        }

        if (depth > 0) {
            for (Node neighbor : node.neighbors) {
                if (dfs(neighbor, target, depth - 1)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) 
    {
        // Create a sample graph
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        node1.neighbors.add(node2);
        node1.neighbors.add(node3);
        node2.neighbors.add(node4);
        node3.neighbors.add(node5);

        Node start = node1;
        Node target = node5;
        int maxDepth = 3;

        boolean found = iddfs(start, target, maxDepth);

        if (found) {
            System.out.println("Node " + target.value + " is present within the depth limit.");
        } else {
            System.out.println("Node " + target.value + " is absent within the depth limit.");
        }
    }
}
