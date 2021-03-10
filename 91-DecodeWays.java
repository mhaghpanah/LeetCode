class Solution {

  public int numDecodings(String s) {
    int n = s.length();
    int[] dp = new int[n + 1];
    dp[0] = 1;
    for (int i = 0; i < n; i++) {
      int d = s.charAt(i) - '0';
      if (d > 0) {
        dp[i + 1] = dp[i];
      }
      if (i > 0) {
        d += (s.charAt(i - 1) - '0') * 10;
        if (10 <= d && d <= 26) {
          dp[i + 1] += dp[i - 1];
        }
      }
    }

    return dp[n];
  }
}
