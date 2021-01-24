class Solution {

  public int[] findOrder(int n, int[][] pre) {
    int[] d = new int[n];
    List<Integer>[] g = new List[n];
    for (int i = 0; i < n; i++) {
      g[i] = new ArrayList<>();
    }
    for (int[] p : pre) {
      d[p[1]]++;
      g[p[0]].add(p[1]);
    }

    Queue<Integer> q = new LinkedList<>();
    for (int i = 0; i < n; i++) {
      if (d[i] == 0) {
        q.add(i);
      }
    }

    int[] ans = new int[n];
    int k = 0;
    while (!q.isEmpty()) {
      int top = q.remove();
      ans[n - 1 - k++] = top;
      for (int nei : g[top]) {
        d[nei]--;
        if (d[nei] == 0) {
          q.add(nei);
        }
      }
    }

    return k == n ? ans : new int[0];
  }
}
