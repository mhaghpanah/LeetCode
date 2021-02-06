class Solution {

  public List<String> generateParenthesis(int n) {
    List<String> ans = new ArrayList<>();
    dfs(0, 0, n, new char[2 * n], ans);
    return ans;
  }

  public void dfs(int index, int open, int n, char[] ca, List<String> ans) {
    if (index == 2 * n) {
      ans.add(String.valueOf(ca));
      return;
    }

    if (open > 0) {
      ca[index] = ')';
      dfs(index + 1, open - 1, n, ca, ans);
    }

    if (2 * n > open + index) {
      ca[index] = '(';
      dfs(index + 1, open + 1, n, ca, ans);
    }

  }

}
