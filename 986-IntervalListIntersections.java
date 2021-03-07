class Solution {

  public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
    int n = firstList.length;
    int m = secondList.length;
    int i = 0;
    int j = 0;
    List<int[]> ans = new ArrayList<>();
    while (i < n && j < m) {
      int v0 = Math.max(firstList[i][0], secondList[j][0]);
      int v1 = Math.min(firstList[i][1], secondList[j][1]);
      if (v0 <= v1) {
        ans.add(new int[]{v0, v1});
      }
      if (firstList[i][1] < secondList[j][1]) {
        i++;
      } else {
        j++;
      }
    }
    return ans.toArray(new int[ans.size()][2]);
  }
}
