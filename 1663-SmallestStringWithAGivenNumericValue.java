class Solution {

  public String getSmallestString(int n, int k) {
    k -= n;
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; i++) {
      int t = Math.min(k, 25);
      k -= t;
      sb.append((char) ('a' + t));
    }
    return sb.reverse().toString();
  }
}
