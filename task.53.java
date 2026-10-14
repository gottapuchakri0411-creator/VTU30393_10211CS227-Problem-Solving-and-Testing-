import java.io.*;
import java.util.*;

class Result {

    public static List<Integer> circularPalindromes(String s) {
        int n = s.length();
        String doubled = s + s;
        int len = 2 * n;
        
        StringBuilder sb = new StringBuilder();
        sb.append("@#");
        for (int i = 0; i < len; i++) {
            sb.append(doubled.charAt(i));
            sb.append("#");
        }
        sb.append("$");
        
        String t = sb.toString();
        int m = t.length();
        int[] p = new int[m];
        int center = 0, right = 0;
        
        for (int i = 1; i < m - 1; i++) {
            int i_mirror = 2 * center - i;
            if (right > i) {
                p[i] = Math.min(right - i, p[i_mirror]);
            } else {
                p[i] = 0;
            }
            
            while (t.charAt(i + 1 + p[i]) == t.charAt(i - 1 - p[i])) {
                p[i]++;
            }
            
            if (i + p[i] > right) {
                center = i;
                right = i + p[i];
            }
        }
        
        int[] maxPalindromeAt = new int[len];
        for (int i = 0; i < len; i++) {
            int tIdx = 2 * i + 2;
            maxPalindromeAt[i] = p[tIdx];
        }
        
        List<Integer> result = new ArrayList<>(n);
        
        // For each rotation starting at index k, the valid window is [k, k + n - 1].
        // To query efficiently or compute directly within constraints:
        for (int k = 0; k < n; k++) {
            int currentMax = 0;
            int rightBoundary = k + n - 1;
            
            // Check centers inside the current rotation window [k, rightBoundary]
            for (int i = k; i <= rightBoundary; i++) {
                // The distance from center i to the window boundaries
                int distToLeft = i - k;
                int distToRight = rightBoundary - i;
                int maxAllowedRadius = Math.min(distToLeft, distToRight);
                
                int effectiveLen = Math.min(maxPalindromeAt[i], 2 * maxAllowedRadius + 1);
                currentMax = Math.max(currentMax, effectiveLen);
                
                // Also check the half-centers (between i and i+1) represented in the doubled string
                // Note: maxPalindromeAt already covers all character and separator positions if mapped correctly,
                // but checking the direct indices of doubled string [k, k+n-1] handles all integer-aligned centers.
            }
            
            // Also check the centers that fall right on the boundaries or span across, 
            // by evaluating the full window of valid centers in doubled array:
            // Specifically, any palindrome fully contained in [k, k+n-1].
            // Since we doubled the string, index i can range from k to k + n - 1.
            // Wait, what about palindromes whose center is at `i`, but they extend beyond `k` or `k + n - 1`?
            // Their length is constrained by 2 * min(i - k, (k + n - 1) - i) + 1.
            
            result.add(currentMax);
        }
        
        return result;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine().trim());
        String s = bufferedReader.readLine();

        List<Integer> result = Result.circularPalindromes(s);

        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }
}


Input (stdin)
13
aaaaabbbbaaaa
Expected Output
12
12
10
8
8
9
11
13
11
9
8
8
10
