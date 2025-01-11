/*
    Time Complexity: O(N)
    Space Complexity:O(N)

    Where 'N' is the no. of operations performed.
*/

import java.util.Stack;

public class Solution {

    static class MinStack {

        Stack<Integer> stack, Min;

        // Constructor
        MinStack() {
            stack = new Stack<Integer>();
            Min = new Stack<Integer>();
        }

        // Function to add another element equal to num at the top of stack.
        void push(int num) {
            stack.push(num);
            if (Min.empty() || Min.peek() >= num) {
                Min.push(num);
            }
        }

        // Function to remove the top element of the stack.
        int pop() {
            if (!Min.empty() && Min.peek() == stack.peek()) {
                Min.pop();
            }

            int ret = -1;

            if (!stack.empty()) {
                ret = stack.peek();
                stack.pop();
            }

            return ret;
        }

        // Function to return the top element of stack if it is present. Otherwise
        // return -1.
        int top() {
            int ret = -1;
            if (!stack.empty()) {
                ret = stack.peek();
            }
            return ret;
        }

        // Function to return minimum element of stack if it is present. Otherwise
        // return -1.
        int getMin() {
            int ret = -1;
            if (!Min.empty()) {
                ret = Min.peek();
            }
            return ret;
        }
    }
}