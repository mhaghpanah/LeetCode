class Solution {

  int n;
  int m;
  char[][] g;
  int[] d = new int[]{0, 1, 0, -1, 0};

  public void dfs(int x, int y) {
    if (x < 0 || y < 0 || x >= n || y >= m || g[x][y] != '1') {
      return;
    }
    g[x][y] = '0';
    for (int k = 0; k < 4; k++) {
      dfs(x + d[k], y + d[k + 1]);
    }
  }

  public int numIslands(char[][] grid) {
    n = grid.length;
    m = grid[0].length;
    g = grid;
    int ans = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (grid[i][j] == '1') {
          ans++;
          dfs(i, j);
        }
      }
    }

    return ans;
  }
}
