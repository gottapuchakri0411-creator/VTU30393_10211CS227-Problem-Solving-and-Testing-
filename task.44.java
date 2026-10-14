import java.io.*;
import java.util.*;

public class Solution {

    public static long stringSimilarity(String s) {
        int n = s.length();
        int[] z = new int[n];
        long total = n;
        
        int l = 0, r = 0;
        for (int i = 1; i < n; i++) {
            if (i <= r) {
                z[i] = Math.min(r - i + 1, z[i - l]);
            }
            while (i + z[i] < n && s.charAt(z[i]) == s.charAt(i + z[i])) {
                z[i]++;
            }
            if (i + z[i] - 1 > r) {
                l = i;
                r = i + z[i] - 1;
            }
            total += z[i];
        }
        
        return total;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bufferedReader.readLine().trim());

        for (int i = 0; i < t; i++) {
            String s = bufferedReader.readLine();
            long result = stringSimilarity(s);
            System.out.println(result);
        }
    }
}


Input (stdin)
2
ababaa
aa
Your Output (stdout)
11
3
Expected Output
11
3
