class Solution {

  public int maxProduct(int[] nums) {
    long ans = nums[0];
    long min = nums[0];
    long max = nums[0];
    for (int i = 1; i < nums.length; i++) {
      long tMin = Math.min(nums[i], Math.min(min * nums[i], max * nums[i]));
      long tMax = Math.max(nums[i], Math.max(min * nums[i], max * nums[i]));
      min = tMin;
      max = tMax;
      ans = Math.max(ans, Math.max(min, max));
    }
    return (int) ans;
  }
}
