class Solution {

  int MAX = 40_000 + 1;

  public int code(int a, int b) {
    return a * MAX + b;
  }

  public int minAreaRect(int[][] points) {
    int ans = Integer.MAX_VALUE;

    Set<Integer> set = new HashSet<>();
    Map<Integer, List<Integer>> map = new TreeMap<>();
    for (int[] p : points) {
      map.computeIfAbsent(p[0], k -> new ArrayList<>()).add(p[1]);
    }

    Map<Integer, Integer> last = new HashMap<>();
    for (Integer x : map.keySet()) {
      List<Integer> list = map.get(x);
      Collections.sort(list);
      for (int i = 0; i < list.size(); i++) {
        for (int j = i + 1; j < list.size(); j++) {
          int y0 = list.get(i);
          int y1 = list.get(j);
          if (last.containsKey(code(y0, y1))) {
            ans = Math.min(ans, (x - last.get(code(y0, y1))) * (y1 - y0));
          }
          last.put(code(y0, y1), x);
        }
      }
    }
    return ans == Integer.MAX_VALUE ? 0 : ans;
  }
}
