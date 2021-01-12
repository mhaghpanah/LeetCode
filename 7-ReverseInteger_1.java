class Solution {

  public int reverse(int x) {
    int ans = 0;
    while (x != 0) {
      int d = x % 10;
      x /= 10;
      if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE && d > 7)) {
        return 0;
      }
      if (ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE && d < -8)) {
        return 0;
      }
      ans = ans * 10 + d;
    }

    return ans;
  }
}
