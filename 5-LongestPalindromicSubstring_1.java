class Solution {

  public String longestPalindrome(String s) {
    int n = s.length();
    int start = 0;
    int end = 0;
    int len;
    for (int i = 0; i < n; i++) {
      len = solve(s, i, i);
      if (len > end - start) {
        start = i - len / 2;
        end = i + len / 2;
      }
      len = solve(s, i, i + 1);
      if (len > end - start) {
        start = i - len / 2 + 1;
        end = i + len / 2;
      }
    }
    return s.substring(start, end + 1);

  }

  public int solve(String s, int lo, int hi) {
    int n = s.length();
    while (0 <= lo && hi < n && s.charAt(lo) == s.charAt(hi)) {
      lo--;
      hi++;
    }
    return hi - lo - 1;
  }
}
