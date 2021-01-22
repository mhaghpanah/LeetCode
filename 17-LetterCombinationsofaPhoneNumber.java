class Solution {

  String[] strs = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
  List<String> ans = new ArrayList<>();

  public void dfs(String digits, int index, StringBuilder sb) {
    if (index == digits.length()) {
      ans.add(sb.toString());
      return;
    }

    int t = digits.charAt(index) - '0';
    for (char ch : strs[t].toCharArray()) {
      sb.append(ch);
      dfs(digits, index + 1, sb);
      sb.deleteCharAt(sb.length() - 1);
    }
  }

  public List<String> letterCombinations(String digits) {
    ans = new ArrayList<>();
    if (digits == null || digits.length() == 0) {
      return ans;
    }
    dfs(digits, 0, new StringBuilder());
    return ans;
  }
}
