class Solution {

  public boolean isValid(int[] nums, int m, int v) {
    int n = nums.length;
    int sum = 0;
    int c = 1;
    for (int i = 0; i < n; i++) {
      if (nums[i] > v) {
        return false;
      }
      if (sum + nums[i] > v) {
        c++;
        sum = 0;
      }
      sum += nums[i];
    }
    return c <= m;
  }

  public int splitArray(int[] nums, int m) {
    int lo = 0;
    int hi = 1_000_000_000;
    int ans = hi;
    while (lo <= hi) {
      int mid = lo + (hi - lo) / 2;
      if (isValid(nums, m, mid)) {
        ans = mid;
        hi = mid - 1;
      } else {
        lo = mid + 1;
      }
    }
    return ans;
  }
}
