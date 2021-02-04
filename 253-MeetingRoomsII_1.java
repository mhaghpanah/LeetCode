class Solution {

  public int minMeetingRooms(int[][] intervals) {
    if (intervals == null || intervals.length == 0) {
      return 0;
    }
    int n = intervals.length;
    int[] a = new int[n];
    int[] b = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = intervals[i][0];
      b[i] = intervals[i][1];
    }
    Arrays.sort(a);
    Arrays.sort(b);
    int j = 0;
    for (int i = 0; i < n; i++) {
      if (a[i] >= b[j]) {
        j++;
      }
    }
    return n - j;
  }
}
