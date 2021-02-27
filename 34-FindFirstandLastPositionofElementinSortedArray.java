class Solution {

  public int f(int[] nums, int t, boolean lower) {
    int lo = 0;
    int hi = nums.length - 1;
    int ans = -1;
    while (lo <= hi) {
      int mid = lo + (hi - lo) / 2;
      if (nums[mid] == t) {
        ans = mid;
        if (lower) {
          hi = mid - 1;
        } else {
          lo = mid + 1;
        }
      } else if (nums[mid] < t) {
        lo = mid + 1;
      } else {
        hi = mid - 1;
      }
    }
    return ans;
  }

  public int[] searchRange(int[] nums, int target) {
    return new int[]{f(nums, target, true), f(nums, target, false)};
  }
}
