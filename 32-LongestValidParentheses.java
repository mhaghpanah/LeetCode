class Solution {

  public int longestValidParentheses(String s) {
    int n = s.length();
    int[] dp = new int[n];
    int ans = 0;
    for (int i = 1; i < n; i++) {
      if (s.charAt(i) == ')') {
        if (s.charAt(i - 1) == '(') {
          dp[i] = i - 2 >= 0 ? dp[i - 2] + 2 : 2;
        } else if (i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
          dp[i] = dp[i - 1] + (i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] - 2] : 0) + 2;
        }

        ans = Math.max(ans, dp[i]);
      }
    }
    return ans;
  }
}
