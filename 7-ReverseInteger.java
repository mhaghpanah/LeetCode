class Solution {

  public int reverse(int x) {
    boolean neg = x < 0;
    if (x < 0) {
      x = -x;
    }
    long r = 0;
    while (x > 0) {
      r = r * 10 + x % 10;
      x /= 10;
    }
    if (r < Integer.MIN_VALUE || r > Integer.MAX_VALUE) {
      return 0;
    }
    return (int) (neg ? -r : r);
  }
}
