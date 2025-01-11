import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");

        Node head = null, tail = null;
        for (String value : input) {
            int num = Integer.parseInt(value);
            if (num == -1) break; // End of input for the list
            Node newNode = new Node(num);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        Node result = rearrange(head);

        // Print the rearranged list
        Node current = result;
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) System.out.print(" ");
            current = current.next;
        }
    }

    public static Node rearrange(Node head) {
        if (head == null || head.next == null) return head;

        Node oddHead = null, oddTail = null;
        Node evenHead = null, evenTail = null;

        Node current = head;

        // Split the list into odd and even sublists
        while (current != null) {
            if (current.data % 2 != 0) { // Odd
                if (oddHead == null) {
                    oddHead = current;
                    oddTail = current;
                } else {
                    oddTail.next = current;
                    oddTail = current;
                }
            } else { // Even
                if (evenHead == null) {
                    evenHead = current;
                    evenTail = current;
                } else {
                    evenTail.next = current;
                    evenTail = current;
                }
            }
            current = current.next;
        }

        // Connect odd and even sublists
        if (oddTail != null) {
            oddTail.next = evenHead;
        }
        if (evenTail != null) {
            evenTail.next = null;
        }

        return oddHead != null ? oddHead : evenHead;
    }
}
