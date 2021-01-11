class Solution {

  public int longestIncreasingPath(int[][] matrix) {
    List<int[]> indexes = new ArrayList<>();
    int n = matrix.length;
    int m = matrix[0].length;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        indexes.add(new int[]{i, j});
      }
    }
    Collections.sort(indexes, (a, b) -> matrix[a[0]][a[1]] - matrix[b[0]][b[1]]);
    int ans = 0;
    int[][] dp = new int[n][m];
    int[] d = new int[]{0, 1, 0, -1, 0};
    for (int[] a : indexes) {
      int i = a[0];
      int j = a[1];
      for (int k = 0; k < 4; k++) {
        int ii = i + d[k];
        int jj = j + d[k + 1];
        if (ii < 0 || jj < 0 || ii >= n || jj >= m || matrix[i][j] <= matrix[ii][jj]) {
          continue;
        }
        dp[i][j] = Math.max(dp[i][j], dp[ii][jj]);
      }
      dp[i][j]++;
      ans = Math.max(ans, dp[i][j]);
    }
    return ans;
  }
}
