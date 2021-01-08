class Solution {

  public int maxSubArray(int[] nums) {
    long ans = Long.MIN_VALUE;
    int lo = 0;
    int n = nums.length;
    long sum = 0;
    for (int hi = 0; hi < n; hi++) {
      sum += nums[hi];
      ans = Math.max(ans, sum);
      while (sum < 0) {
        sum -= nums[lo++];
      }
    }
    return (int) ans;
  }
}
