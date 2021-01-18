class Solution {

  public int maxOperations(int[] nums, int k) {
    Map<Integer, Integer> count = new HashMap<>();
    int ans = 0;
    for (int a : nums) {
      int c = k - a;
      if (count.getOrDefault(c, 0) > 0) {
        ans++;
        count.put(c, count.get(c) - 1);
      } else {
        count.put(a, count.getOrDefault(a, 0) + 1);
      }
    }
    return ans;
  }
}
