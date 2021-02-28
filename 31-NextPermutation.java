class Solution {

  public void swap(int[] nums, int i, int j) {
    int t = nums[i];
    nums[i] = nums[j];
    nums[j] = t;
  }

  public void rev(int[] nums, int lo) {
    int hi = nums.length - 1;
    while (lo < hi) {
      swap(nums, lo++, hi--);
    }
  }

  public void nextPermutation(int[] nums) {
    int n = nums.length;
    int i = n - 2;
    while (i >= 0 && nums[i] >= nums[i + 1]) {
      i--;
    }
    if (i != -1) {
      int j = n - 1;
      while (nums[i] >= nums[j]) {
        j--;
      }
      swap(nums, i, j);
    }
    rev(nums, i + 1);
  }
}
