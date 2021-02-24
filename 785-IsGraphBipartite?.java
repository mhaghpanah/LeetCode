class Solution {

  public boolean dfs(int v, int[][] g, int[] c, int color) {
    if (c[v] >= 0) {
      return c[v] == color;
    }
    c[v] = color;
    for (int nei : g[v]) {
      if (!dfs(nei, g, c, 1 - color)) {
        return false;
      }
    }
    return true;
  }

  public boolean isBipartite(int[][] graph) {
    int n = graph.length;
    int[] c = new int[n];
    Arrays.fill(c, -1);
    for (int i = 0; i < n; i++) {
      if (c[i] == -1 && !dfs(i, graph, c, 0)) {
        return false;
      }
    }
    return true;
  }
}
