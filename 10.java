import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

class TestClass {
    public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int q = Integer.parseInt(br.readLine().trim()); // Number of queries
        Stack<Integer> stack = new Stack<>();
        long stackSum = 0; // Keep track of the sum of elements in the stack
        
        while (q-- > 0) {
            String[] input = br.readLine().trim().split(" ");
            int queryType = Integer.parseInt(input[0]); // First element is the query type
            
            switch (queryType) {
                case 1: // Push a single integer
                    int x = Integer.parseInt(input[1]);
                    stack.push(x);
                    stackSum += x;
                    break;
                
                case 2: // Push element x, n times
                    int n = Integer.parseInt(input[1]);
                    x = Integer.parseInt(input[2]);
                    for (int i = 0; i < n; i++) {
                        stack.push(x);
                        stackSum += x;
                    }
                    break;
                
                case 3: // Print and pop the top element
                    if (!stack.isEmpty()) {
                        int top = stack.pop();
                        stackSum -= top;
                        System.out.println(top);
                    } else {
                        System.out.println(0); // Print 0 if stack is empty
                    }
                    break;
                
                case 4: // Pop the top n elements and print their sum
                    n = Integer.parseInt(input[1]);
                    long poppedSum = 0;
                    for (int i = 0; i < n && !stack.isEmpty(); i++) {
                        int popped = stack.pop();
                        poppedSum += popped;
                        stackSum -= popped;
                    }
                    System.out.println(poppedSum);
                    break;
                
                case 5: // Print the sum of all elements in the stack
                    System.out.println(stackSum);
                    break;
            }
        }
    }
}
