class Solution {

  class UnionFind {

    int[] p;
    int[] r;

    public UnionFind(int n) {
      p = new int[n];
      r = new int[n];
      for (int i = 0; i < n; i++) {
        p[i] = i;
      }
    }

    public int find(int x) {
      if (p[x] == x) {
        return x;
      }
      return p[x] = find(p[x]);
    }

    public boolean union(int x, int y) {
      x = find(x);
      y = find(y);
      if (x == y) {
        return false;
      }
      if (r[x] == r[y]) {
        r[x]++;
      }
      if (r[x] > r[y]) {
        p[y] = x;
      } else {
        p[x] = y;
      }
      return true;
    }
  }

  public int removeStones(int[][] stones) {
    int n = stones.length;
    UnionFind uf = new UnionFind(n);
    int ans = 0;
    Integer[] index = new Integer[n];
    for (int i = 0; i < n; i++) {
      index[i] = i;
    }

    Arrays.sort(index, (a, b) -> stones[a][0] - stones[b][0]);
    for (int i = 1; i < n; i++) {
      int j = index[i - 1];
      int k = index[i];
      if (stones[j][0] == stones[k][0] && uf.union(j, k)) {
        ans++;
      }
    }

    Arrays.sort(index, (a, b) -> stones[a][1] - stones[b][1]);
    for (int i = 1; i < n; i++) {
      int j = index[i - 1];
      int k = index[i];
      if (stones[j][1] == stones[k][1] && uf.union(j, k)) {
        ans++;
      }
    }
    return ans;
  }
}
