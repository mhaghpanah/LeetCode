class Solution {

  public int shortestDistance(int[][] grid) {
    int n = grid.length;
    int m = grid[0].length;
    int[] d = new int[]{0, 1, 0, -1, 0};
    int[][] dist = new int[n][m];
    int walk = 0;
    int ans = Integer.MAX_VALUE;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (grid[i][j] == 1) {
          ans = Integer.MAX_VALUE;
          Queue<int[]> q = new LinkedList<>();
          q.add(new int[]{i, j});
          int t = 0;
          while (!q.isEmpty()) {
            int sz = q.size();
            t++;
            for (int k = 0; k < sz; k++) {
              int[] top = q.remove();
              for (int r = 0; r < 4; r++) {
                int x = top[0] + d[r];
                int y = top[1] + d[r + 1];
                if (x < 0 || y < 0 || x >= n || y >= m || grid[x][y] != walk) {
                  continue;
                }
                grid[x][y]--;
                dist[x][y] += t;
                ans = Math.min(ans, dist[x][y]);
                q.add(new int[]{x, y});
              }
            }
          }
          walk--;
        }
      }
    }

    return ans == Integer.MAX_VALUE ? -1 : ans;
  }
}
