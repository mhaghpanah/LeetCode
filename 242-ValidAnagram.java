class Solution {

  public int[] toArray(String s) {
    int[] arr = new int[26];
    for (char ch : s.toCharArray()) {
      arr[ch - 'a']++;
    }
    return arr;
  }

  public boolean isAnagram(String s, String t) {
    return Arrays.equals(toArray(s), toArray(t));
  }
}
