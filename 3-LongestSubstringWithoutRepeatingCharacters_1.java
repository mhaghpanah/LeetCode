class Solution {

  public int lengthOfLongestSubstring(String s) {
    int[] used = new int[128];
    int ans = 0;
    int lo = 0;
    int hi = 0;
    int n = s.length();
    while (hi < n) {
      char ch = s.charAt(hi++);
      lo = Math.max(lo, used[ch]);
      used[ch] = hi;
      ans = Math.max(ans, hi - lo);
    }
    return ans;
  }
}
