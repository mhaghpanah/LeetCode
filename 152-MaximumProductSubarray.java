class Solution {

  public int maxProduct(int[] nums) {
    long ans = Integer.MIN_VALUE;
    long prod = 1L;
    long prodNeg = 0L;
    for (int hi = 0; hi < nums.length; hi++) {
      if (prod < 0 && prodNeg == 0) {
        prodNeg = 1L;
      }
      prod *= nums[hi];
      prodNeg *= nums[hi];
      ans = Math.max(ans, prod);
      if (prodNeg != 0) {
        ans = Math.max(ans, prodNeg);
      }
      if (nums[hi] == 0) {
        prod = 1L;
        prodNeg = 0L;
      }
    }
    return (int) ans;
  }
}
