class Solution {

  public boolean solve(String s, int i, String p, int j, Boolean[][] memo) {
    if (i < 0) {
      return false;
    }
    if (j == 0) {
      return i == 0;
    }
    if (memo[i][j] != null) {
      return memo[i][j];
    }
    char ch = p.charAt(j - 1);
    if (ch == '*') {
      memo[i][j] = solve(s, i, p, j - 2, memo);
      if (j > 1) {
        memo[i][j] |= solve(s, i - 1, p, j, memo) && (p.charAt(j - 2) == '.' || p.charAt(j - 2) == s
            .charAt(i - 1));
      }
    } else if (ch == '.') {
      memo[i][j] = solve(s, i - 1, p, j - 1, memo);
    } else {
      memo[i][j] = solve(s, i - 1, p, j - 1, memo) && s.charAt(i - 1) == p.charAt(j - 1);
    }
    return memo[i][j];
  }

  public boolean isMatch(String s, String p) {
    int n = s.length();
    int m = p.length();
    return solve(s, n, p, m, new Boolean[n + 1][m + 1]);
  }
}
