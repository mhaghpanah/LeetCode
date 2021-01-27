class Solution {

  public long mult(long a, long b, long MOD) {
    return (a * b) % MOD;
  }

  public long pow(long a, long b, long MOD) {
    if (b == 0) {
      return 1;
    }
    if (b == 1) {
      return a % MOD;
    }
    long v = pow(a, b / 2, MOD);
    return mult(mult(v, v, MOD), b % 2 == 1 ? a : 1, MOD);
  }

  public long add(long a, long b, long MOD) {
    return (a + b) % MOD;
  }

  public int concatenatedBinary(int n) {
    long ans = 1;
    long MOD = 1_000_000_000 + 7;
    for (int i = 2; i <= n; i++) {
      int len = Integer.toBinaryString(i).length();
      long p = pow(2, len, MOD);
      ans = mult(ans, p, MOD);
      ans = add(ans, i, MOD);
    }
    return (int) ans;
  }
}
