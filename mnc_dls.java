import java.util.LinkedList;

class Node {
    int data;
    LinkedList<Node> children;

    Node(int value) {
        data = value;
        children = new LinkedList<>();
    }

    void addChild(Node child) {
        children.add(child);
    }
}

public class dls {

    public static boolean depthLimitedSearch(Node root, int target, int maxDepth) 
    {
        return depthLimitedSearchHelper(root, target, maxDepth, 0);
    }

    private static boolean depthLimitedSearchHelper(Node node, int target, int maxDepth, int currentDepth) 
    {
        if (currentDepth > maxDepth) 
        {
            return false;
        }

        if (node.data == target) 
        {
            System.out.println("Target found!");
            return true;
        }

        for (Node child : node.children) 
        {
            if (depthLimitedSearchHelper(child, target, maxDepth, currentDepth + 1)) 
            {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        // Example Usage
        Node root = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        root.addChild(node2);
        root.addChild(node3);
        node2.addChild(node4);
        node3.addChild(node5);

        int target = 5;
        int maxDepth = 1;

        boolean result = depthLimitedSearch(root, target, maxDepth);

        if (result) 
        {
            System.out.println("Target found within the specified depth limit.");
        } else 
        {
            System.out.println("Target not found within the specified depth limit.");
        }
    }
}
