class Solution {

  public List<Integer> toList(int[] nums) {
    List<Integer> ans = new ArrayList<>();
    for (int a : nums) {
      ans.add(a);
    }
    return ans;
  }

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

  public boolean next(int[] nums) {
    int i = nums.length - 2;
    while (i >= 0 && nums[i] >= nums[i + 1]) {
      i--;
    }
    if (i < 0) {
      return false;
    }
    int j = nums.length - 1;
    while (nums[i] >= nums[j]) {
      j--;
    }
    swap(nums, i, j);
    rev(nums, i + 1);
    return true;
  }

  public List<List<Integer>> permute(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> ans = new ArrayList<>();
    do {
      ans.add(toList(nums));
    } while (next(nums));
    return ans;
  }
}
