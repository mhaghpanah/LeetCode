class Solution {

  public String getHint(String secret, String guess) {
    int[] count = new int[10];
    for (char ch : secret.toCharArray()) {
      count[ch - '0']++;
    }
    int a = 0;
    int b = 0;
    int n = secret.length();
    for (int i = 0; i < n; i++) {
      if (secret.charAt(i) == guess.charAt(i)) {
        a++;
      }
      if (count[guess.charAt(i) - '0'] > 0) {
        count[guess.charAt(i) - '0']--;
        b++;
      }
    }
    return String.format("%dA%dB", a, b - a);
  }
}
