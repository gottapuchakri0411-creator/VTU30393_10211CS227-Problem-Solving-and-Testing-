import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        
        ArrayList<ArrayList<Integer>> lines = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int d = scanner.nextInt();
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < d; j++) {
                row.add(scanner.nextInt());
            }
            lines.add(row);
        }
        
        if (!scanner.hasNextInt()) return;
        int q = scanner.nextInt();
        
        for (int i = 0; i < q; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            
            try {
                // 1-based index for line, 1-based index for position
                int val = lines.get(x - 1).get(y - 1);
                System.out.println(val);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("ERROR!");
            }
        }
        
        scanner.close();
    }
}


Compiler Message
Success
Input (stdin)
5
5 41 77 74 22 44
1 12
4 37 34 36 52
0
3 20 22 33
5
1 3
3 4
3 1
4 3
5 5
Expected Output
74
52
37
ERROR!
ERROR!
