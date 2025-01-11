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

    // Function to merge two sorted linked lists
    public static Node mergeSortedLists(Node list1, Node list2) {
        // Dummy node to simplify the merging process
        Node dummy = new Node(0);
        Node tail = dummy;

        while (list1 != null && list2 != null) {
            if (list1.data <= list2.data) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }

        // Append remaining nodes of list1 or list2
        if (list1 != null) {
            tail.next = list1;
        } else {
            tail.next = list2;
        }

        return dummy.next; // Return the head of the merged list
    }

    // Helper function to print the linked list
    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + "->");
            current = current.next;
        }
        System.out.println("NULL");
    }

    // Helper function to create a linked list from an array
    public static Node createList(int[] arr) {
        Node head = null, tail = null;

        for (int data : arr) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
                tail = head;
            } else {
                tail.next = newNode;
                tail = tail.next;
            }
        }

        return head;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read size and elements of the first list
        int size1 = Integer.parseInt(br.readLine().trim());
        int[] list1Array = Arrays.stream(br.readLine().trim().split(" "))
                                 .mapToInt(Integer::parseInt)
                                 .toArray();

        // Read size and elements of the second list
        int size2 = Integer.parseInt(br.readLine().trim());
        int[] list2Array = Arrays.stream(br.readLine().trim().split(" "))
                                 .mapToInt(Integer::parseInt)
                                 .toArray();

        // Create linked lists from the input arrays
        Node list1 = createList(list1Array);
        Node list2 = createList(list2Array);

        // Merge the sorted linked lists
        Node mergedList = mergeSortedLists(list1, list2);

        // Print the merged list
        printList(mergedList);
    }
}