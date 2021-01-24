class Solution {

  public boolean dfs(int v, List<Integer>[] g, int[] c, List<Integer> rtopol) {
    if (c[v] == 1) {
      return true;
    }
    if (c[v] == 2) {
      return false;
    }
    c[v] = 1;
    for (int nei : g[v]) {
      if (dfs(nei, g, c, rtopol)) {
        return true;
      }
    }
    c[v] = 2;
    rtopol.add(v);
    return false;
  }

  public int[] findOrder(int n, int[][] pre) {
    List<Integer>[] g = new List[n];
    for (int i = 0; i < n; i++) {
      g[i] = new ArrayList<>();
    }
    for (int[] p : pre) {
      g[p[0]].add(p[1]);
    }

    int[] c = new int[n];
    List<Integer> rtopol = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      if (c[i] == 0) {
        if (dfs(i, g, c, rtopol)) {
          return new int[0];
        }
      }
    }

    int[] ans = new int[n];
    for (int i = 0; i < n; i++) {
      ans[i] = rtopol.get(i);
    }

    return ans;
  }
}
