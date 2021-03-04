class WordDictionary {

  TrieNode root;

  /**
   * Initialize your data structure here.
   */
  public WordDictionary() {
    root = new TrieNode();
  }

  /**
   * Adds a word into the data structure.
   */
  public void addWord(String word) {
    TrieNode h = root;
    for (char ch : word.toCharArray()) {
      h = h.children.computeIfAbsent(ch, k -> new TrieNode());
    }
    h.isWord = true;
  }

  /**
   * Returns if the word is in the data structure. A word could contain the dot character '.' to
   * represent any one letter.
   */
  public boolean search(String word) {
    return search(root, word, 0);
  }

  public boolean search(TrieNode h, String word, int i) {
    int n = word.length();
    for (; i < n; i++) {
      char ch = word.charAt(i);
      if (ch == '.') {
        for (TrieNode node : h.children.values()) {
          if (search(node, word, i + 1)) {
            return true;
          }
        }
        return false;
      } else {
        if (!h.children.containsKey(ch)) {
          return false;
        }
        h = h.children.get(ch);
      }

    }
    return h.isWord;
  }

  class TrieNode {

    boolean isWord;
    Map<Character, TrieNode> children;

    public TrieNode() {
      children = new HashMap<>();
    }
  }
}


/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
