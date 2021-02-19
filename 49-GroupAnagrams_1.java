class Solution {

  public String f(String str) {
    int[] count = new int[26];
    for (char ch : str.toCharArray()) {
      count[ch - 'a']++;
    }
    StringBuilder sb = new StringBuilder();
    for (int a : count) {
      sb.append("$");
      sb.append(a);
    }
    return sb.toString();
  }

  public List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> map = new HashMap<>();
    for (String str : strs) {
      String s = f(str);
      map.computeIfAbsent(s, k -> new ArrayList<>()).add(str);
    }
    List<List<String>> ans = new ArrayList<>();
    for (List<String> list : map.values()) {
      ans.add(list);
    }
    return ans;
  }
}
