class Solution {

  public int[] solve(String s, int lo, int hi) {
    int n = s.length();
    while (lo >= 0 && hi < n && s.charAt(lo) == s.charAt(hi)) {
      lo--;
      hi++;
    }
    return new int[]{lo + 1, hi - 1};
  }

  public String longestPalindrome(String s) {
    int n = s.length();
    int[] ans = new int[]{0, 0};
    int[] interval;
    for (int i = 0; i < n; i++) {
      interval = solve(s, i, i);
      if (ans[1] - ans[0] < interval[1] - interval[0]) {
        ans = interval;
      }
      interval = solve(s, i, i + 1);
      if (ans[1] - ans[0] < interval[1] - interval[0]) {
        ans = interval;
      }
    }
    return s.substring(ans[0], ans[1] + 1);
  }
}
