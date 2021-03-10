class Solution {

  public int numDecodings(String s) {
    int n = s.length();
    int oneBack = 1;
    int twoBack = 0;
    for (int i = 0; i < n; i++) {
      int d = s.charAt(i) - '0';
      int ans = 0;
      if (d > 0) {
        ans = oneBack;
      }
      if (i > 0) {
        d += (s.charAt(i - 1) - '0') * 10;
        if (10 <= d && d <= 26) {
          ans += twoBack;
        }
      }
      twoBack = oneBack;
      oneBack = ans;
    }

    return oneBack;
  }
}
