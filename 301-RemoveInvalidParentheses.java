class Solution {

  int n;
  int sz;
  Set<String> ans;

  public void solve(int index, char[] ca, int len, char[] tmp, int open) {
    if (index == n) {
      if (open == 0) {
        if (len > sz) {
          sz = len;
          ans.clear();
        }
        if (len == sz) {
          ans.add(String.valueOf(Arrays.copyOf(tmp, len)));
        }
      }
      return;
    }
    char ch = ca[index];
    solve(index + 1, ca, len, tmp, open);
    tmp[len] = ch;
    if (ch == '(') {
      solve(index + 1, ca, len + 1, tmp, open + 1);
    } else if (ch == ')') {
      if (open > 0) {
        solve(index + 1, ca, len + 1, tmp, open - 1);
      }
    } else {
      solve(index + 1, ca, len + 1, tmp, open);
    }
    tmp[len] = 0;
  }

  public List<String> removeInvalidParentheses(String s) {
    n = s.length();
    sz = 0;
    ans = new HashSet<>();

    solve(0, s.toCharArray(), 0, new char[n], 0);
    return new ArrayList<>(ans);
  }
}
