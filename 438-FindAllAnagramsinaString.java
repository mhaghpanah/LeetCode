class Solution {

  public List<Integer> findAnagrams(String s, String p) {
    List<Integer> ans = new ArrayList<>();
    int[] count = new int[26];
    int t = 0;
    for (char ch : p.toCharArray()) {
      count[ch - 'a']++;
      if (count[ch - 'a'] == 1) {
        t++;
      }
    }

    int lo = 0;
    int n = s.length();
    for (int hi = 0; hi < n; hi++) {
      char ch = s.charAt(hi);
      count[ch - 'a']--;
      if (count[ch - 'a'] == 0) {
        t--;
      } else if (count[ch - 'a'] == -1) {
        t++;
      }

      while (count[ch - 'a'] < 0) {
        char c = s.charAt(lo++);
        count[c - 'a']++;
        if (count[c - 'a'] == 1) {
          t++;
        } else if (count[c - 'a'] == 0) {
          t--;
        }
      }

      if (t == 0) {
        ans.add(hi - p.length() + 1);
      }

    }

    return ans;

  }
}
