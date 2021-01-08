class Solution {

  public long helper(int[] nums, int lo, int hi, int step) {
    long ans = Long.MIN_VALUE;
    long sum = 0;
    for (int i = lo; i != hi; i += step) {
      sum += nums[i];
      ans = Math.max(ans, sum);
    }
    return ans;
  }

  public long solve(int[] nums, int lo, int hi) {
    if (lo + 1 == hi) {
      return nums[lo];
    }
    int mid = lo + (hi - lo) / 2;
    long left = solve(nums, lo, mid);
    long right = solve(nums, mid, hi);
    long prefix = helper(nums, mid - 1, lo - 1, -1);
    long suffix = helper(nums, mid, hi, 1);
    return Math.max(suffix + prefix, Math.max(left, right));
  }

  public int maxSubArray(int[] nums) {
    return (int) solve(nums, 0, nums.length);
  }
}
