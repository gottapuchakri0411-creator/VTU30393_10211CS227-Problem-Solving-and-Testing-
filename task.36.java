import java.io.*;
import java.util.*;

class Result {

    public static List<Integer> maxSubarray(List<Integer> arr) {
        int maxSubarray = arr.get(0);
        int currentSubarray = arr.get(0);
        
        int maxSubsequence = arr.get(0);
        int maxElement = arr.get(0);
        boolean allNegative = true;
        
        if (maxElement > 0) {
            allNegative = false;
        }

        for (int i = 1; i < arr.size(); i++) {
            int val = arr.get(i);
            
            // Kadane's Algorithm for Maximum Subarray
            currentSubarray = Math.max(val, currentSubarray + val);
            maxSubarray = Math.max(maxSubarray, currentSubarray);
            
            // Maximum Subsequence calculation
            if (val > 0) {
                if (allNegative) {
                    maxSubsequence = val;
                    allNegative = false;
                } else {
                    maxSubsequence += val;
                }
            } else {
                if (allNegative && val > maxElement) {
                    maxElement = val;
                }
            }
        }
        
        if (allNegative) {
            maxSubsequence = maxElement;
        }

        List<Integer> result = new ArrayList<>();
        result.add(maxSubarray);
        result.add(maxSubsequence);
        return result;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int t = scanner.nextInt();
        
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            List<Integer> arr = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                arr.add(scanner.nextInt());
            }
            List<Integer> res = Result.maxSubarray(arr);
            System.out.println(res.get(0) + " " + res.get(1));
        }
        scanner.close();
    }
}


Input (stdin)
2
4
1 2 3 4
6
2 -1 2 3 4 -5
Your Output (stdout)
10 10
10 11
Expected Output
