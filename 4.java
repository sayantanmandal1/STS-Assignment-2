import java.io.BufferedReader;
import java.io.InputStreamReader;
 
class Node {
    int val;
    Node next;
 
    Node() {
        val = 0;
        next = null;
    }
 
    Node(int x) {
        val = x;
        next = null;
    }
}
 
public class TestClass {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // Number of nodes in the linked list
        String[] values = br.readLine().split(" "); // Values of the nodes
        int loopIndex = Integer.parseInt(br.readLine()); // Index where the loop starts (-1 if no loop)
 
        // Create the linked list
        Node head = null, tail = null;
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(Integer.parseInt(values[i]));
            if (head == null) {
                head = nodes[i];
                tail = head;
            } else {
                tail.next = nodes[i];
                tail = tail.next;
            }
        }
 
        // Create a loop if loopIndex is not -1
        if (loopIndex != -1) {
            tail.next = nodes[loopIndex];
        }
 
        // Detect and remove loop
        boolean hasLoop = detectAndRemoveLoop(head);
        System.out.println(hasLoop ? "Loop removed" : "No loop");
 
        // Print the list after removing the loop
        Node current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
 
    static boolean detectAndRemoveLoop(Node root) {
        if (root == null || root.next == null) {
            return false; // No loop if the list is empty or has only one node
        }
 
        Node slow = root;
        Node fast = root;
 
        // Step 1: Detect if a cycle exists
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
 
            if (slow == fast) {
                // Step 2: Remove the loop
                removeLoop(root, slow);
                return true; // Loop detected and removed
            }
        }
 
        return false; // No loop detected
    }
 
    private static void removeLoop(Node head, Node meetingPoint) {
        Node start = head;
        Node prev = null;
 
        // Step 3: Find the start of the loop
        while (start != meetingPoint) {
            prev = meetingPoint;
            start = start.next;
            meetingPoint = meetingPoint.next;
        }
 
        // Step 4: Break the loop
        prev.next = null;
    }
}