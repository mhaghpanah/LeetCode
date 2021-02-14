/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf4);
 */

public class Solution extends Reader4 {
  /**
   * @param buf Destination buffer
   * @param n   Number of characters to read
   * @return    The number of actual characters read
   */
  char[] ca = new char[4];
  public int read(char[] buf, int n) {
    int m = 0;
    int index = 0;
    while (index < n && (m = read4(ca)) > 0) {
      for (int i = 0; index < n && i < m; i++) {
        buf[index++] = ca[i];
      }
    }
    return index;
  }
}
