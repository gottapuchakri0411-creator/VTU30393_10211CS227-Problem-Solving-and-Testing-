class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        
        // Prefix sum matrix of size (m + 1) x (n + 1)
        int[][] dp = new int[m + 1][n + 1];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i + 1][j + 1] = mat[i][j] + dp[i][j + 1] + dp[i + 1][j] - dp[i][j];
            }
        }
        
        int[][] answer = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int r1 = Math.max(0, i - k);
                int c1 = Math.max(0, j - k);
                int r2 = Math.min(m - 1, i + k);
                int c2 = Math.min(n - 1, j + k);
                
                // Convert to 1-indexed coordinates for the dp matrix
                r1++; c1++; r2++; c2++;
                
                answer[i][j] = dp[r2][c2] - dp[r1 - 1][c2] - dp[r2][c1 - 1] + dp[r1 - 1][c1 - 1];
            }
        }
        
        return answer;
    }
}


Input
mat =
[[1,2,3],[4,5,6],[7,8,9]]
k =
1
Output
[[12,21,16],[27,45,33],[24,39,28]]
