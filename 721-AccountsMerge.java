class Solution {

  public List<List<String>> accountsMerge(List<List<String>> accounts) {
    int n = accounts.size();
    Map<String, List<Integer>> email2id = new HashMap<>();
    for (int i = 0; i < accounts.size(); i++) {
      List<String> acc = accounts.get(i);
      for (int j = 1; j < acc.size(); j++) {
        email2id.computeIfAbsent(acc.get(j), k -> new ArrayList()).add(i);
      }
    }

    UnionFind uf = new UnionFind(n);
    for (List<Integer> list : email2id.values()) {
      for (int i = 0; i < list.size() - 1; i++) {
        uf.union(list.get(i), list.get(i + 1));
      }
    }

    int[] c = new int[n];
    for (int i = 0; i < n; i++) {
      c[i] = uf.find(i);
    }
    Map<Integer, TreeSet<String>> comp2email = new HashMap<>();
    for (int i = 0; i < n; i++) {
      comp2email.putIfAbsent(c[i], new TreeSet<>());
      TreeSet<String> set = comp2email.get(c[i]);
      List<String> acc = accounts.get(i);
      for (int j = 1; j < acc.size(); j++) {
        set.add(acc.get(j));
      }
    }

    List<List<String>> ans = new ArrayList<>();
    for (int comp : comp2email.keySet()) {
      List<String> list = new ArrayList<>();
      list.add(accounts.get(comp).get(0));
      for (String email : comp2email.get(comp)) {
        list.add(email);
      }
      ans.add(list);
    }
    return ans;

  }

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
      int px = find(x);
      int py = find(y);
      if (px == py) {
        return false;
      }
      if (r[px] == r[py]) {
        r[px]++;
      }
      if (r[px] > r[py]) {
        p[py] = px;
      } else {
        p[px] = py;
      }
      return true;
    }
  }
}
