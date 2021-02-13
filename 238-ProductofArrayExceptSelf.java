class Solution {

  public int[] productExceptSelf(int[] nums) {
    int n = nums.length;
    int[] left = new int[n + 1];
    left[n] = 1;
    for (int i = n - 1; i >= 0; i--) {
      left[i] = nums[i] * left[i + 1];
    }
    int[] ans = new int[n];
    int curr = 1;
    for (int i = 0; i < n; i++) {
      ans[i] = curr * left[i + 1];
      curr *= nums[i];
    }
    return ans;
  }
}
