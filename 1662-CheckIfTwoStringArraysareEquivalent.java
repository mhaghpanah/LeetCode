class Solution {

  public String helper(String[] strs) {
    StringBuilder sb = new StringBuilder();
    for (String str : strs) {
      sb.append(str);
    }
    return sb.toString();
  }

  public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
    return helper(word1).equals(helper(word2));
  }
}
