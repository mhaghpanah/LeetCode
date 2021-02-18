class Solution {

  public int lengthOfLongestSubstringKDistinct(String s, int k) {
    int[] count = new int[128];
    int lo = 0;
    int hi = 0;
    int ans = 0;
    char[] ca = s.toCharArray();
    int n = ca.length;
    while (hi < n) {
      char ch = ca[hi++];
      count[ch]++;
      if (count[ch] == 1) {
        k--;
      }
      while (k < 0) {
        ch = ca[lo++];
        count[ch]--;
        if (count[ch] == 0) {
          k++;
        }
      }
      ans = Math.max(hi - lo, ans);
    }
    return ans;
  }
}
