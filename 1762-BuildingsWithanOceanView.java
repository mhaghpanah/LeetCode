class Solution {

  public int[] findBuildings(int[] heights) {
    int max = Integer.MIN_VALUE;
    LinkedList<Integer> ans = new LinkedList<>();
    for (int i = heights.length - 1; i >= 0; i--) {
      if (heights[i] > max) {
        ans.addFirst(i);
        max = heights[i];
      }
    }
    int[] arr = new int[ans.size()];
    int index = 0;
    for (int a : ans) {
      arr[index++] = a;
    }
    return arr;
  }
}
