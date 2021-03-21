class Solution {

  public int divide(int p, int q) {
    if (p == Integer.MIN_VALUE && q == -1) {
      return Integer.MAX_VALUE;
    }

    int neg = 2;

    if (p > 0) {
      p = -p;
      neg--;
    }

    if (q > 0) {
      q = -q;
      neg--;
    }

    int ans = 0;

    int d = q;
    int pow = -1;
    int HALF_INT_MIN = -1073741824;

    while (d >= HALF_INT_MIN && p <= d + d) {
      d += d;
      pow += pow;
    }

    while (p <= q) {
      if (p <= d) {
        ans += pow;
        p -= d;
      }
      pow >>= 1;
      d >>= 1;
    }

    if (neg != 1) {
      ans = -ans;
    }
    return ans;

  }
}
