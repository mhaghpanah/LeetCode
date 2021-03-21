class Solution {

  public int divide(int dividend, int divisor) {
    if (dividend == Integer.MIN_VALUE && divisor == -1) {
      return Integer.MAX_VALUE;
    }
    int neg = 2;

    if (dividend > 0) {
      dividend = -dividend;
      neg--;
    }

    if (divisor > 0) {
      divisor = -divisor;
      neg--;
    }

    int HALF_MIN_INT = -(1 << 30);
    int pow = -1;
    int q = divisor;

    while (q + q >= dividend && q >= HALF_MIN_INT) {
      pow += pow;
      q += q;
    }

    int ans = 0;
    while (dividend <= divisor) {

      if (dividend <= q) {
        ans += pow;
        dividend -= q;
      }
      pow >>= 1;
      q >>= 1;
    }

    if (neg != 1) {
      ans = -ans;
    }
    return ans;
  }
}
