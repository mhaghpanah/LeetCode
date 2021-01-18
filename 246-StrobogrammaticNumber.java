class Solution {
  
  public boolean isStrobogrammatic(String num) {
    Map<Character, Character> map = new HashMap<>();
    map.put('0', '0');
    map.put('1', '1');
    map.put('6', '9');
    map.put('8', '8');
    map.put('9', '6');

    int lo = 0;
    int hi = num.length() - 1;
    while (lo <= hi) {
      char c0 = num.charAt(lo++);
      char c1 = num.charAt(hi--);
      if (map.getOrDefault(c0, ' ') != c1) {
        return false;
      }
    }
    return true;
  }
}
