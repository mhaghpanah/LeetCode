class Solution {

  public List<List<Integer>> subsets(int[] nums) {
    int n = nums.length;
    List<List<Integer>> ans = new ArrayList<>();
    ans.add(new ArrayList<>());
    for (int i = 0; i < n; i++) {
      int sz = ans.size();
      for (int j = 0; j < sz; j++) {
        List<Integer> list = new ArrayList<>(ans.get(j));
        list.add(nums[i]);
        ans.add(list);
      }
    }

    return ans;
  }
}
