class Solution {

  public double myPow(double x, int n) {
    if (x == 0) {
      return 0.0;
    }
    long N = n;
    if (N < 0) {
      N = -N;
      x = 1 / x;
    }

    double p = x;
    double ans = 1.0;
    for (long i = N; i != 0; i >>= 1) {
      if ((i & 1) != 0) {
        ans *= p;
      }
      p *= p;
    }
    return ans;
  }
}
