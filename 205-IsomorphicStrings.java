class Solution {

  public boolean isIsomorphic(String s, String t) {
    Map<Character, Character> map = new HashMap<>();
    Map<Character, Character> mapInv = new HashMap<>();
    int n = s.length();
    for (int i = 0; i < n; i++) {
      char ch0 = s.charAt(i);
      char ch1 = t.charAt(i);
      if (map.getOrDefault(ch0, ch1) != ch1) {
        return false;
      }
      if (mapInv.getOrDefault(ch1, ch0) != ch0) {
        return false;
      }
      map.put(ch0, ch1);
      mapInv.put(ch1, ch0);
    }
    return true;
  }
}
