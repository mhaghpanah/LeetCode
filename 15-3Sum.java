class Solution {

  public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    Set<List<Integer>> ans = new HashSet<>();
    int n = nums.length;
    for (int i = 0; i < n; i++) {
      int lo = i + 1;
      int hi = n - 1;
      while (lo < hi) {
        if (nums[i] + nums[lo] + nums[hi] > 0) {
          hi--;
        } else if (nums[i] + nums[lo] + nums[hi] < 0) {
          lo++;
        } else {
          List<Integer> list = new ArrayList<>();
          list.add(nums[i]);
          list.add(nums[lo]);
          list.add(nums[hi]);
          ans.add(list);
          lo++;
          hi--;
        }
      }
    }
    return new ArrayList<>(ans);
  }
}
