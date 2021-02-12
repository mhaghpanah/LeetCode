class Solution {

  public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> ans = new ArrayList<>();
    int n = nums.length;
    for (int i = 0; i < n; i++) {
      if (i == 0 || nums[i - 1] != nums[i]) {
        int lo = i + 1;
        int hi = n - 1;
        while (lo < hi) {
          if (nums[i] + nums[lo] + nums[hi] > 0) {
            hi--;
          } else if (nums[i] + nums[lo] + nums[hi] < 0) {
            lo++;
          } else {
            ans.add(Arrays.asList(nums[i], nums[lo++], nums[hi--]));
            while (lo < hi && nums[lo] == nums[lo - 1]) {
              lo++;
            }
          }
        }
      }
    }
    return ans;
  }
}
