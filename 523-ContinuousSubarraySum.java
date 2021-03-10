class Solution {

  public boolean checkSubarraySum(int[] nums, int k) {
    if (k < 0) {
      k *= -1;
    }
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, -1);
    int sum = 0;
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      if (k > 0) {
        sum %= k;
      }
      if (i - map.getOrDefault(sum, i) > 1) {
        return true;
      }
      map.putIfAbsent(sum, i);
    }
    return false;
  }
}
