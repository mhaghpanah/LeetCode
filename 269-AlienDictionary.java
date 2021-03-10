class Solution {

  public boolean dfs(char ch, Map<Character, Set<Character>> g, int[] color, List<Character> ans) {
    if (color[ch] == 1) {
      return false;
    }
    color[ch] = 1;
    for (char nei : g.getOrDefault(ch, new HashSet<>())) {
      if (color[nei] < 2 && !dfs(nei, g, color, ans)) {
        return false;
      }
    }
    ans.add(ch);
    color[ch] = 2;
    return true;
  }

  public String alienOrder(String[] words) {
    Map<Character, Set<Character>> g = new HashMap<>();
    for (String str : words) {
      for (char ch : str.toCharArray()) {
        g.putIfAbsent(ch, new HashSet<>());
      }
    }
    for (int i = 0; i < words.length - 1; i++) {
      String str0 = words[i];
      String str1 = words[i + 1];
      boolean flag = true;
      for (int j = 0; j < Math.min(str0.length(), str1.length()); j++) {
        char ch0 = str0.charAt(j);
        char ch1 = str1.charAt(j);
        if (ch0 != ch1) {
          g.computeIfAbsent(ch0, k -> new HashSet<>()).add(ch1);
          flag = false;
          break;
        }
      }

      if (flag && str0.length() > str1.length()) {
        return "";
      }
    }

    int[] color = new int[128];
    List<Character> ans = new ArrayList<>();
    for (char ch : g.keySet()) {
      if (color[ch] == 0 && !dfs(ch, g, color, ans)) {
        return "";
      }
    }

    StringBuilder sb = new StringBuilder();
    for (char ch : ans) {
      sb.append(ch);
    }
    return sb.reverse().toString();
  }
}
