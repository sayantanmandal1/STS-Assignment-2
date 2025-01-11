class PairWiseSwap {
    public Node pairwiseSwap(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node previous = null;
        Node current = head;
        Node newHead = head.next;  // New head is the second node initially

        while (current != null && current.next != null) {
            Node nextNode = current.next.next;  // Save the node after the next node

            // Swap current and current.next nodes
            current.next.next = current;  // Link the second node to the current
            if (previous != null) {
                previous.next = current.next;  // Link the previous node to the second node
            }

            // Move pointers two steps forward
            previous = current;
            current = nextNode;
        }

        // Handle the last node if the list has an odd number of nodes
        if (previous != null) {
            previous.next = current;
        }

        return newHead;
    }
}