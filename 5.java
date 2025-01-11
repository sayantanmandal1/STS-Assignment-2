import java.util.* ;
import java.io.*; 
/****************************************************************

    Following is the class structure of the Node class:

      class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;

        public Node(T data) {
            this.data = data;
        }
    }

*****************************************************************/
public class Solution {

    public static Node<Integer> sortDLL(Node<Integer> head) {
        if (head == null || head.next == null) {
            return head; // Single node or empty list is already sorted
        }

        // Step 1: Find the peak node (where the list transitions from increasing to decreasing)
        Node<Integer> peak = head;
        while (peak.next != null && peak.data <= peak.next.data) {
            peak = peak.next;
        }

        // Step 2: Split the list into two halves
        Node<Integer> secondHalf = peak.next;
        if (secondHalf != null) {
            secondHalf.prev = null;
        }
        peak.next = null;

        // Step 3: Reverse the second half (which is in decreasing order)
        Node<Integer> reversedSecondHalf = reverseDLL(secondHalf);

        // Step 4: Merge the two sorted halves
        return mergeSortedLists(head, reversedSecondHalf);
    }

    private static Node<Integer> reverseDLL(Node<Integer> head) {
        Node<Integer> current = head;
        Node<Integer> prev = null;

        while (current != null) {
            Node<Integer> next = current.next;
            current.next = prev;
            current.prev = next;
            prev = current;
            current = next;
        }

        return prev;
    }

    private static Node<Integer> mergeSortedLists(Node<Integer> list1, Node<Integer> list2) {
        Node<Integer> dummy = new Node<>(-1); // Temporary dummy node
        Node<Integer> tail = dummy;

        while (list1 != null && list2 != null) {
            if (list1.data <= list2.data) {
                tail.next = list1;
                list1.prev = tail;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2.prev = tail;
                list2 = list2.next;
            }
            tail = tail.next;
        }

        // Attach the remaining nodes, if any
        if (list1 != null) {
            tail.next = list1;
            list1.prev = tail;
        } else if (list2 != null) {
            tail.next = list2;
            list2.prev = tail;
        }

        // Return the new head, skipping the dummy node
        Node<Integer> newHead = dummy.next;
        if (newHead != null) {
            newHead.prev = null;
        }
        return newHead;
    }
}