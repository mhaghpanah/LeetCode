class Solution {

  public String multiply(String num1, String num2) {
    int n = num1.length();
    int m = num2.length();
    int[] ans = new int[n + m + 1];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        ans[i + j] += (num1.charAt(n - 1 - i) - '0') * (num2.charAt(m - 1 - j) - '0');
      }
    }

    for (int i = 0; i < n + m; i++) {
      ans[i + 1] += ans[i] / 10;
      ans[i] %= 10;
    }

    StringBuilder sb = new StringBuilder();
    int i = n + m;
    while (i >= 0 && ans[i] == 0) {
      i--;
    }
    while (i >= 0) {
      sb.append(ans[i--]);
    }
    return sb.length() == 0 ? "0" : sb.toString();
  }

}
