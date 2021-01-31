class Solution {

  public int[][] insert(int[][] intervals0, int[] newInterval) {
    int[][] intervals1 = new int[][]{newInterval};
    int n = intervals0.length;
    int m = intervals1.length;
    LinkedList<int[]> ans = new LinkedList<>();
    int i = 0;
    int j = 0;

    while (i < n || j < m) {
      int[] t;
      if (i == n) {
        t = intervals1[j++];
      } else if (j == m) {
        t = intervals0[i++];
      } else if (intervals0[i][0] < intervals1[j][0]) {
        t = intervals0[i++];
      } else {
        t = intervals1[j++];
      }

      if (ans.isEmpty() || ans.getLast()[1] < t[0]) {
        ans.add(t);
      } else {
        int[] prev = ans.removeLast();
        prev[1] = Math.max(prev[1], t[1]);
        ans.add(prev);
      }
    }

    return ans.toArray(new int[ans.size()][2]);
  }
}
