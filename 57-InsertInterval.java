class Solution {

  public int[][] insert(int[][] intervals, int[] newInterval) {
    int s = newInterval[0];
    int e = newInterval[1];

    int n = intervals.length;
    LinkedList<int[]> ans = new LinkedList<>();
    int idx = 0;
    while (idx < n && intervals[idx][0] < s) {
      ans.add(intervals[idx++]);
    }

    if (ans.isEmpty() || ans.getLast()[1] < s) {
      ans.add(newInterval);
    } else {
      int[] t = ans.removeLast();
      t[1] = Math.max(t[1], e);
      ans.add(t);
    }

    while (idx < n) {
      newInterval = intervals[idx++];
      s = newInterval[0];
      e = newInterval[1];
      if (ans.isEmpty() || ans.getLast()[1] < s) {
        ans.add(newInterval);
      } else {
        int[] t = ans.removeLast();
        t[1] = Math.max(t[1], e);
        ans.add(t);
      }
    }

    return ans.toArray(new int[ans.size()][2]);
  }
}
