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
    UnionFind uf = new UnionFind(20_010);
    for (int[] a : stones) {
      uf.union(a[0], a[1] + 10_000);
    }
    Set<Integer> c = new HashSet<>();
    for (int[] a : stones) {
      c.add(uf.find(a[0]));
    }
    return n - c.size();
  }
}
