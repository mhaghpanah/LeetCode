class Solution {

  int MAX = 40_000 + 1;

  public int code(int a, int b) {
    return a * MAX + b;
  }

  public int minAreaRect(int[][] points) {
    int ans = Integer.MAX_VALUE;

    Set<Integer> set = new HashSet<>();
    for (int[] p : points) {
      set.add(code(p[0], p[1]));
    }

    for (int i = 0; i < points.length; i++) {
      int x0 = points[i][0];
      int y0 = points[i][1];
      for (int j = i + 1; j < points.length; j++) {
        int x1 = points[j][0];
        int y1 = points[j][1];
        if (x0 != x1 && y0 != y1) {
          if (set.contains(code(x0, y1)) && set.contains(code(x1, y0))) {
            int dx = Math.abs(x0 - x1);
            int dy = Math.abs(y0 - y1);
            ans = Math.min(ans, dx * dy);
          }
        }
      }
    }
    return ans == Integer.MAX_VALUE ? 0 : ans;
  }
}
