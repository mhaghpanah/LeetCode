class Solution {

  public int concatenatedBinary(int n) {
    long ans = 0;
    long MOD = 1_000_000_000 + 7;
    int len = 0;
    for (int i = 1; i <= n; i++) {
      if ((i & (i - 1)) == 0) {
        len++;
      }
      ans = ((ans << len) | i) % MOD;
    }
    return (int) ans;
  }
}
