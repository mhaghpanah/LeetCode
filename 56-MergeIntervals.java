class Solution {

  public int[][] merge(int[][] intervals) {
    List<int[]> ans = new ArrayList<>();
    Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
    int b = 0;
    int e = 0;
    for (int i = 0; i <= intervals.length; i++) {
      if (i == intervals.length || e < intervals[i][0]) {
        if (i > 0) {
          ans.add(new int[]{b, e});
        }
        if (i < intervals.length) {
          b = intervals[i][0];
          e = intervals[i][1];
        }
      } else {
        e = Math.max(e, intervals[i][1]);
      }
    }
    return ans.toArray(new int[ans.size()][2]);
  }
}
