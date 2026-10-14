import java.io.*;
import java.util.*;

class Result {
    public static int alternatingCharacters(String s) {
        int deletions = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                deletions++;
            }
        }
        return deletions;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        
        int q = Integer.parseInt(bufferedReader.readLine().trim());

        for (int qItr = 0; qItr < q; qItr++) {
            String s = bufferedReader.readLine();
            int result = Result.alternatingCharacters(s);
            System.out.println(result);
        }

        bufferedReader.close();
    }
}


Input (stdin)
5
AAAA
BBBBB
ABABABAB
BABABA
AAABBB
Expected Output
3
4
0
0
4
