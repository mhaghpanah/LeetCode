class Solution {

  public int lengthOfLongestSubstring(String s) {
    boolean[] used = new boolean[128];
    int ans = 0;
    int lo = 0;
    int hi = 0;
    int n = s.length();
    while (hi < n) {
      char ch = s.charAt(hi++);
      while (used[ch]) {
        used[s.charAt(lo++)] = false;
      }
      used[ch] = true;
      ans = Math.max(ans, hi - lo);
    }
    return ans;
  }
}
