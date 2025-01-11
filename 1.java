/* Node is defined as

class Node
{
    int data;
    Node next;
    Node(int d) {data = d; next = null; }
}

*/


class Solution {
    public static Node detectCycle(Node head) {
        if (head == null || head.next == null) {
            return null; // No cycle if the list is empty or has only one node
        }

        Node slow = head;
        Node fast = head;

        // Step 1: Detect if a cycle exists
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                // Step 2: Find the start of the cycle
                Node cycleStart = head;

                while (cycleStart != slow) {
                    cycleStart = cycleStart.next;
                    slow = slow.next;
                }

                return cycleStart; // Start of the cycle
            }
        }

        return null; // No cycle detected
    }
}