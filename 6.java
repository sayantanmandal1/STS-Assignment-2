class Solution {
    public Node rearrange(Node head) {
        // Dummy heads for even and odd sublist
        Node evenDummyHead = new Node(), oddDummyHead = new Node();
        // Pointers for even and odd sublist
        Node evenPtr = evenDummyHead, oddPtr = oddDummyHead;

        // Traverse the linked list
        while (head != null) {
            if (head.val % 2 == 0) { // Check if even
                evenPtr.next = head;
                evenPtr = evenPtr.next;
            } else { // Otherwise it is odd
                oddPtr.next = head;
                oddPtr = oddPtr.next;
            }
            head = head.next; // Move to the next node
        }

        // Connect even sublist to odd sublist
        evenPtr.next = oddDummyHead.next;
        oddPtr.next = null; // End the list

        // Return the rearranged list
        return evenDummyHead.next;
    }
}