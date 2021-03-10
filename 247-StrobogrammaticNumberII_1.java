class Solution {

  char[] r = new char[]{'0', '1', '6', '8', '9'};
  char[] rInv = new char[]{'0', '1', '9', '8', '6'};
  char[] s = new char[]{'0', '1', '8'};

  public void solve(int i, int n, char[] tmp, List<String> ans) {
    if (i > n / 2 || (i == n / 2 && n % 2 == 0)) {
      ans.add(String.valueOf(tmp));
      return;
    }

    if (i < n / 2) {
      for (int j = 0; j < r.length; j++) {
        if (i == 0 && j == 0) {
          continue;
        }
        tmp[i] = r[j];
        tmp[n - 1 - i] = rInv[j];
        solve(i + 1, n, tmp, ans);
      }
    } else {
      for (int j = 0; j < s.length; j++) {
        tmp[i] = s[j];
        solve(i + 1, n, tmp, ans);
      }
    }
  }

  public List<String> findStrobogrammatic(int n) {
    List<String> ans = new ArrayList<>();
    solve(0, n, new char[n], ans);
    return ans;
  }
}
