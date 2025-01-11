// Node is defined as:
// class Node{
//     int val;
//     Node next;
//     Node(){
//         val =0;
//         next = null;
//     }
//     Node(int x){
//     	val = x; next = null;
//     }
// }
class Solution{
    static int solve(Node root){
        if (root == null || root.next == null) {
            return -1; // No loop if the list is empty or has only one node
        }

        Node slow = root;
        Node fast = root;

        // Step 1: Detect if a cycle exists
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                // Step 2: Calculate loop length
                int loopLength = 1;
                Node current = slow;
                while (current.next != slow) {
                    current = current.next;
                    loopLength++;
                }
                return loopLength ; // Return X-1 as required
            }
        }

        return -1; // No loop detected
    }
}
