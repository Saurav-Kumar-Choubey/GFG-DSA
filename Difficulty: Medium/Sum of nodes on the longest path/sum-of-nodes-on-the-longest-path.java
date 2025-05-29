/*
class Node {
    int data;
    Node left, right;

    public Node(int data){
        this.data = data;
    }
} */
class Solution {
    private int maxLen = 0;
    private int maxSum = 0;

    public int sumOfLongRootToLeafPath(Node root) {
        solve(root, 0, 0);
        return maxSum;
    }

    private void solve(Node node, int currSum, int currLen) {
        if (node == null) {
            if (currLen > maxLen) {
                maxLen = currLen;
                maxSum = currSum;
            } else if (currLen == maxLen) {
                maxSum = Math.max(maxSum, currSum);
            }
            return;
        }

        currSum += node.data;
        solve(node.left, currSum, currLen + 1);
        solve(node.right, currSum, currLen + 1);
    }
}
