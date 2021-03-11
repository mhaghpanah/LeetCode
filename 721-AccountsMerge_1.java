class Solution {

  public List<List<String>> accountsMerge(List<List<String>> accounts) {
    int n = accounts.size();
    UnionFind uf = new UnionFind(n);

    Map<String, Integer> email2id = new HashMap<>();
    Map<String, String> email2name = new HashMap<>();
    for (int i = 0; i < accounts.size(); i++) {
      List<String> acc = accounts.get(i);
      String name = acc.get(0);
      for (int j = 1; j < acc.size(); j++) {
        String email = acc.get(j);
        if (email2id.containsKey(email)) {
          uf.union(i, email2id.get(email));
        } else {
          email2id.put(email, i);
          email2name.put(email, name);
        }
      }
    }

    Map<Integer, List<String>> map = new HashMap<>();
    for (String email : email2id.keySet()) {
      int index = uf.find(email2id.get(email));
      map.computeIfAbsent(index, k -> new ArrayList<>()).add(email);
    }

    List<List<String>> ans = new ArrayList<>();
    for (List<String> emails : map.values()) {
      Collections.sort(emails);
      emails.add(0, email2name.get(emails.get(0)));
      ans.add(emails);
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
