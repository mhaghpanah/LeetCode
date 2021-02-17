class Solution {

  public int subarraySum(int[] nums, int k) {
    int ans = 0;
    int sum = 0;
    Map<Integer, Integer> map = new HashMap<>();
    for (int a : nums) {
      map.put(sum, map.getOrDefault(sum, 0) + 1);
      sum += a;
      int t = sum - k;
      ans += map.getOrDefault(t, 0);
    }
    return ans;
  }
}
