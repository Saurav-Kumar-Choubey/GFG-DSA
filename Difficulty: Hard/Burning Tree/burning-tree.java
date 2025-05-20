/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}  */
class Solution {
    static class NodeParent {
        Node node;
        Node parent;
        NodeParent(Node node, Node parent) {
            this.node = node;
            this.parent = parent;
        }
    }

    public static int minTime(Node root, int target) {
        Map<Node, Node> parentMap = new HashMap<>();
        Node targetNode = buildParentMap(root, null, target, parentMap);
        return burnTree(targetNode, parentMap);
    }

    private static Node buildParentMap(Node node, Node parent, int target, Map<Node, Node> parentMap) {
        if (node == null) return null;
        parentMap.put(node, parent);
        if (node.data == target) return node;
        Node left = buildParentMap(node.left, node, target, parentMap);
        if (left != null) return left;
        return buildParentMap(node.right, node, target, parentMap);
    }

    private static int burnTree(Node targetNode, Map<Node, Node> parentMap) {
        Queue<Node> queue = new LinkedList<>();
        Set<Node> visited = new HashSet<>();
        queue.add(targetNode);
        visited.add(targetNode);
        int time = -1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            time++;
            for (int i = 0; i < size; i++) {
                Node current = queue.poll();
                if (current.left != null && !visited.contains(current.left)) {
                    queue.add(current.left);
                    visited.add(current.left);
                }
                if (current.right != null && !visited.contains(current.right)) {
                    queue.add(current.right);
                    visited.add(current.right);
                }
                Node parent = parentMap.get(current);
                if (parent != null && !visited.contains(parent)) {
                    queue.add(parent);
                    visited.add(parent);
                }
            }
        }
        return time;
    }
}
