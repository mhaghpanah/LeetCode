class Solution {

  public String getHint(String secret, String guess) {
    int[] count = new int[10];
    int a = 0;
    int b = 0;
    int n = secret.length();
    for (int i = 0; i < n; i++) {
      int s = secret.charAt(i) - '0';
      int g = guess.charAt(i) - '0';
      if (s == g) {
        a++;
      } else {
        if (count[s] < 0) {
          b++;
        }
        if (count[g] > 0) {
          b++;
        }
        count[s]++;
        count[g]--;
      }
    }
    return String.format("%dA%dB", a, b);
  }
}
