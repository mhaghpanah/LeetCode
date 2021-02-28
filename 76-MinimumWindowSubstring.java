class Solution {

  public String minWindow(String s, String t) {
    int[] count = new int[128];
    int k = 0;
    for (char ch : t.toCharArray()) {
      count[ch]++;
      if (count[ch] == 1) {
        k++;
      }
    }

    int lo = 0;
    int hi = 0;
    int n = s.length();
    int[] ans = new int[]{-1, 0, 0};

    while (hi < n) {
      char ch = s.charAt(hi++);
      count[ch]--;
      if (count[ch] == 0) {
        k--;
      }
      while (k == 0) {
        if (ans[0] == -1 || hi - lo < ans[0]) {
          ans = new int[]{hi - lo, lo, hi};
        }
        ch = s.charAt(lo++);
        count[ch]++;
        if (count[ch] == 1) {
          k++;
        }
      }
    }

    return ans[0] == -1 ? "" : s.substring(ans[1], ans[2]);
  }
}
