class Solution {

  public boolean isPalindrome(String s) {
    int lo = 0;
    int hi = s.length() - 1;
    while (lo < hi) {
      if (s.charAt(lo) != s.charAt(hi)) {
        return false;
      }
      lo++;
      hi--;
    }
    return true;
  }

  public boolean validPalindrome(String s) {
    int lo = 0;
    int hi = s.length() - 1;
    while (lo < hi) {
      if (s.charAt(lo) == s.charAt(hi)) {
        lo++;
        hi--;
      } else {
        return isPalindrome(s.substring(lo + 1, hi + 1)) || isPalindrome(s.substring(lo, hi));
      }
    }
    return true;
  }
}
