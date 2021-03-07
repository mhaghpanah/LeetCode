class Solution {

  public boolean compare(String str0, String str1, Map<Character, Integer> map) {
    for (int i = 0; i < Math.min(str0.length(), str1.length()); i++) {
      int v0 = map.get(str0.charAt(i));
      int v1 = map.get(str1.charAt(i));
      if (v0 == v1) {
        continue;
      }
      return v0 < v1;
    }
    return str0.length() <= str1.length();
  }

  public boolean isAlienSorted(String[] words, String order) {
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < 26; i++) {
      map.put(order.charAt(i), i);
    }

    for (int i = 0; i < words.length - 1; i++) {
      if (!compare(words[i], words[i + 1], map)) {
        return false;
      }
    }

    return true;
  }
}
