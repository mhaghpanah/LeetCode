class Solution {

  public boolean isPalindrome(String s) {
    int left = 0;
    int right = s.length() - 1;
    while (left < right) {
      while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
        left++;
      }
      while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
        right--;
      }
      char c0 = Character.toLowerCase(s.charAt(left++));
      char c1 = Character.toLowerCase(s.charAt(right--));
      if (c0 != c1) {
        return false;
      }
    }
    return true;
  }
}
