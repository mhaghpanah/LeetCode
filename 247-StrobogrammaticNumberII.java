class Solution {

  char[] chs = new char[]{'0', '1', '6', '8', '9'};
  char[] chsInv = new char[]{'0', '1', '9', '8', '6'};
  char[] r = new char[]{'0', '1', '8'};

  public void backtrack(int index, char[] ca, List<String> ans) {
    int n = ca.length;
    if (2 * index >= n) {
      ans.add(String.valueOf(ca));
    } else if (2 * index + 1 == n) {
      for (char ch : r) {
        ca[index] = ch;
        backtrack(index + 1, ca, ans);
      }
    } else {
      for (int i = 0; i < chs.length; i++) {
        if (index == 0 && i == 0) {
          continue;
        }
        ca[index] = chs[i];
        ca[n - 1 - index] = chsInv[i];
        backtrack(index + 1, ca, ans);
      }
    }
  }

  public List<String> findStrobogrammatic(int n) {
    List<String> ans = new ArrayList<>();
    backtrack(0, new char[n], ans);
    return ans;
  }
}
