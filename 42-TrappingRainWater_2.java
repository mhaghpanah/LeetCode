class Solution {

  public int trap(int[] height) {
    if (height == null || height.length == 0) {
      return 0;
    }
    int n = height.length;
    int ans = 0;
    int lo = 0;
    int hi = n - 1;
    int left_max = 0;
    int right_max = 0;
    while (lo <= hi) {
      if (height[lo] < height[hi]) {
        left_max = Math.max(left_max, height[lo]);
        ans += (left_max - height[lo]);
        lo++;
      } else {
        right_max = Math.max(right_max, height[hi]);
        ans += (right_max - height[hi]);
        hi--;
      }
    }
    return ans;
  }
}
