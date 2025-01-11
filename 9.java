import java.io.BufferedReader;
import java.io.InputStreamReader;
 
class TestClass {
    public static void main(String args[]) throws Exception {
        // BufferedReader for fast input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // Read the number of elements in the stack
        int n = Integer.parseInt(br.readLine().trim());
        
        // Read the stack elements from bottom to top
        int[] stack = new int[n];
        for (int i = 0; i < n; i++) {
            stack[i] = Integer.parseInt(br.readLine().trim());
        }
        
        // Read the value of x
        int x = Integer.parseInt(br.readLine().trim());
        
        // Find the deepest position of x
        int deepestPosition = -1;
        for (int i = 0; i < n; i++) {
            if (stack[i] == x) {
                deepestPosition = i + 1; // 1-based index
                break; // Stop at the first occurrence from the bottom
            }
        }
        
        // Output the result
        System.out.println(deepestPosition);
    }
}