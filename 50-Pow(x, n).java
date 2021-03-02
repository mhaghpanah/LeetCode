class Solution {

  public double myPow(double x, int n) {
    if (x == 0) {
      return 0;
    }
    if (n == 0) {
      return 1;
    }
    double ans = 1.0;
    double p = myPow(x, n / 2);
    return p * p * (n % 2 == 0 ? 1.0 : (n > 0 ? x : 1.0 / x));
  }
}
