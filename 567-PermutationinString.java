class Solution {

  public boolean checkInclusion(String s1, String s2) {
    int[] count = new int[26];
    int t = 0;
    for (char ch : s1.toCharArray()) {
      if (count[ch - 'a']++ == 0) {
        t++;
      }
    }

    int n = s2.length();
    int lo = 0;
    for (int hi = 0; hi < n; hi++) {
      char ch = s2.charAt(hi);
      if (--count[ch - 'a'] == 0) {
        t--;
      }
      if (t == 0) {
        return true;
      }
      while (count[ch - 'a'] < 0) {
        char c = s2.charAt(lo++);
        if (count[c - 'a']++ == 0) {
          t++;
        }
      }
    }
    return false;
  }
}
