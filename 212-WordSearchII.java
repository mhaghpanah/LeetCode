class Solution {

  int[] delta = new int[]{0, 1, 0, -1, 0};

  public void insert(TreeNode root, String str) {
    for (char ch : str.toCharArray()) {
      root = root.children.computeIfAbsent(ch, k -> new TreeNode());
    }
    root.isEnd = true;
    root.str = str;
  }

  public void dfs(int i, int j, char[][] board, TreeNode root, List<String> ans) {
    if (!root.children.containsKey(board[i][j])) {
      return;
    }
    int n = board.length;
    int m = board[0].length;
    root = root.children.get(board[i][j]);
    if (root.isEnd == true) {
      ans.add(root.str);
      root.isEnd = false;
    }

    char t = board[i][j];
    board[i][j] = 0;
    for (int k = 0; k < 4; k++) {
      int ii = i + delta[k];
      int jj = j + delta[k + 1];
      if (ii < 0 || jj < 0 || ii >= n || jj >= m || board[ii][jj] == 0) {
        continue;
      }
      dfs(ii, jj, board, root, ans);
    }
    board[i][j] = t;
  }

  public List<String> findWords(char[][] board, String[] words) {
    TreeNode root = new TreeNode();
    for (String str : words) {
      insert(root, str);
    }

    List<String> ans = new ArrayList<>();

    int n = board.length;
    int m = board[0].length;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        dfs(i, j, board, root, ans);
      }
    }

    return ans;
  }

  class TreeNode {

    boolean isEnd;
    String str;
    Map<Character, TreeNode> children;

    public TreeNode() {
      isEnd = false;
      children = new HashMap<>();
    }
  }
}
