class Solution {

  public boolean isOneEditDistance(String s, String t) {
    int n = s.length();
    int m = t.length();
    if (n < m) {
      return isOneEditDistance(t, s);
    }
    for (int i = 0; i < m; i++) {
      if (t.charAt(i) == s.charAt(i)) {
        continue;
      }
      if (n == m) {
        return t.substring(i + 1).equals(s.substring(i + 1));
      } else {
        return t.substring(i).equals(s.substring(i + 1));
      }
    }

    return n == m + 1;
  }
}
