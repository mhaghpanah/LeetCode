class Solution {

  int n;
  int m;
  int[][] matrix;
  int[][] memo;
  int[] d = new int[]{0, 1, 0, -1, 0};

  public int dfs(int i, int j) {
    if (memo[i][j] > 0) {
      return memo[i][j];
    }
    int ans = 0;
    for (int k = 0; k < 4; k++) {
      int ii = i + d[k];
      int jj = j + d[k + 1];
      if (ii < 0 || jj < 0 || ii >= n || jj >= m || matrix[i][j] >= matrix[ii][jj]) {
        continue;
      }
      ans = Math.max(ans, dfs(ii, jj));
    }
    return memo[i][j] = ans + 1;
  }

  public int longestIncreasingPath(int[][] matrix) {
    n = matrix.length;
    m = matrix[0].length;
    this.matrix = matrix;
    memo = new int[n][m];
    int ans = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (memo[i][j] == 0) {
          ans = Math.max(ans, dfs(i, j));
        }
      }
    }
    return ans;
  }
}
