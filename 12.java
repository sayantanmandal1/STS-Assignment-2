/*class Node{
    int val;
    Node next;
    Node(int x){
        val = x; 
        next = null;
    }
}*/

static Node rotateRight(Node head, int R) {
    // Base cases: if the list is empty, has only one node, or no rotations are needed
    if (head == null || head.next == null || R == 0) return head;

    // Step 1: Find the length of the linked list
    Node current = head;
    int length = 1;
    while (current.next != null) {
        current = current.next;
        length++;
    }

    // Step 2: Make the list circular
    current.next = head; // Connect last node to the head

    // Step 3: Calculate effective rotations
    R = R % length; // If R >= length, effective rotations are R % length
    int stepsToNewHead = length - R;

    // Step 4: Traverse to the new tail (one node before the new head)
    Node newTail = head;
    for (int i = 1; i < stepsToNewHead; i++) {
        newTail = newTail.next;
    }

    // Step 5: Break the circular list to form the new head
    Node newHead = newTail.next;
    newTail.next = null; // Break the circular link

    return newHead;
}
