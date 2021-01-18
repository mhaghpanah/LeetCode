class Solution {

  int index;

  public String solve(String s) {
    StringBuilder sb = new StringBuilder();
    int r = 0;
    while (index < s.length()) {
      char ch = s.charAt(index++);
      if (ch == ']') {
        break;
      } else if (ch == '[') {
        String str = solve(s);
        for (int i = 0; i < r; i++) {
          sb.append(str);
        }
        r = 0;
      } else if (ch >= '0' && ch <= '9') {
        r = r * 10 + ch - '0';
      } else {
        sb.append(ch);
      }
    }
    return sb.toString();
  }

  public String decodeString(String s) {
    index = 0;
    return solve(s);
  }
}
