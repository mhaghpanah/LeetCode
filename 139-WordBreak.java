class Solution {

  public void add(Trie root, String str) {
    int n = str.length();
    for (int i = n - 1; i >= 0; i--) {
      char ch = str.charAt(i);
      root = root.children.computeIfAbsent(ch, k -> new Trie());
    }
    root.isWord = true;
  }

  public boolean search(String s, int index, Trie root, boolean[] dp) {
    while (index >= 0) {
      char ch = s.charAt(index);
      if (!root.children.containsKey(ch)) {
        return false;
      }
      root = root.children.get(ch);
      if (root.isWord && dp[index]) {
        return true;
      }
      index--;
    }

    return false;
  }

  public boolean wordBreak(String s, List<String> wordDict) {
    Trie root = new Trie();
    for (String str : wordDict) {
      add(root, str);
    }
    int n = s.length();
    boolean[] dp = new boolean[n + 1];
    dp[0] = true;
    for (int i = 0; i < n; i++) {
      dp[i + 1] = search(s, i, root, dp);
    }
    return dp[n];
  }

  class Trie {

    Map<Character, Trie> children;
    boolean isWord;

    public Trie() {
      children = new HashMap<>();
    }
  }
}
