/*
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
} */

class Solution {
    public Node sortedInsert(Node head, int data) {
        // code here
        
        Node newNode = new Node(data);

        if (head == null) {
            newNode.next = newNode;
            return newNode;
        }

        Node current = head;

        while (true) {
            if (current.data <= data && data <= current.next.data) {
                break;
            }

            if (current.data > current.next.data) {
                if (data >= current.data || data <= current.next.data) {
                    break;
                }
            }

            current = current.next;

            if (current == head) {
                break;
            }
        }

        newNode.next = current.next;
        current.next = newNode;

        return head.data < data ? head : newNode;
    }
}