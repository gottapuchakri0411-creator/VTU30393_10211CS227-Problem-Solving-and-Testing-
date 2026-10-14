import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'matrixRotation' function below.
     *
     * The accepts following parameters:
     *  1. 2D_INTEGER_ARRAY matrix
     *  2. INTEGER r
     */
    public static void matrixRotation(List<List<Integer>> matrix, int r) {
        int m = matrix.size();
        int n = matrix.get(0).size();
        
        int layers = Math.min(m, n) / 2;
        
        for (int layer = 0; layer < layers; layer++) {
            List<Integer> currentLayer = new ArrayList<>();
            
            int rTop = layer, rBot = m - 1 - layer;
            int cLeft = layer, cRight = n - 1 - layer;
            
            // 1. Top edge (left to right)
            for (int c = cLeft; c < cRight; c++) {
                currentLayer.add(matrix.get(rTop).get(c));
            }
            // 2. Right edge (top to bottom)
            for (int rIdx = rTop; rIdx < rBot; rIdx++) {
                currentLayer.add(matrix.get(rIdx).get(cRight));
            }
            // 3. Bottom edge (right to left)
            for (int c = cRight; c > cLeft; c--) {
                currentLayer.add(matrix.get(rBot).get(c));
            }
            // 4. Left edge (bottom to top)
            for (int rIdx = rBot; rIdx > rTop; rIdx--) {
                currentLayer.add(matrix.get(rIdx).get(cLeft));
            }
            
            int len = currentLayer.size();
            int effectiveRotations = r % len;
            
            // Rotate anti-clockwise by shifting elements
            List<Integer> rotatedLayer = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                rotatedLayer.add(currentLayer.get((i + effectiveRotations) % len));
            }
            
            // Put elements back into the matrix
            int idx = 0;
            // 1. Top edge
            for (int c = cLeft; c < cRight; c++) {
                matrix.get(rTop).set(c, rotatedLayer.get(idx++));
            }
            // 2. Right edge
            for (int rIdx = rTop; rIdx < rBot; rIdx++) {
                matrix.get(rIdx).set(cRight, rotatedLayer.get(idx++));
            }
            // 3. Bottom edge
            for (int c = cRight; c > cLeft; c--) {
                matrix.get(rBot).set(c, rotatedLayer.get(idx++));
            }
            // 4. Left edge
            for (int rIdx = rBot; rIdx > rTop; rIdx--) {
                matrix.get(rIdx).set(cLeft, rotatedLayer.get(idx++));
            }
        }
        
        // Print the resultant matrix
        for (int i = 0; i < m; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append(matrix.get(i).get(j));
                if (j < n - 1) {
                    sb.append(" ");
                }
            }
            System.out.println(sb.toString());
        }
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int m = Integer.parseInt(firstMultipleInput[0]);
        int n = Integer.parseInt(firstMultipleInput[1]);
        int r = Integer.parseInt(firstMultipleInput[2]);

        List<List<Integer>> matrix = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            String[] matrixRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
            List<Integer> matrixRowItems = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                int matrixItem = Integer.parseInt(matrixRowTempItems[j]);
                matrixRowItems.add(matrixItem);
            }

            matrix.add(matrixRowItems);
        }

        Result.matrixRotation(matrix, r);
        bufferedReader.close();
    }
}


Input (stdin)
4 4 1
1 2 3 4
5 6 7 8
9 10 11 12
13 14 15 16
Expected Output
2 3 4 8
1 7 11 12
5 6 10 16
9 13 14 15
