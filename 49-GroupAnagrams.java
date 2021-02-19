class Solution {

  public String f(String str) {
    char[] ca = str.toCharArray();
    Arrays.sort(ca);
    return String.valueOf(ca);
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
