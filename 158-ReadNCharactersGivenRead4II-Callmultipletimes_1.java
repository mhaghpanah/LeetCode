/**
 * The read4 API is defined in the parent class Reader4. int read4(char[] buf4);
 */

public class Solution extends Reader4 {

  /**
   * @param buf Destination buffer
   * @param n   Number of characters to read
   * @return The number of actual characters read
   */
  char[] ca = new char[4];
  int i = 0;
  int sz = 0;

  public int read(char[] buf, int n) {
    int j = 0;
    while (j < n) {
      if (i < sz) {
        buf[j++] = ca[i++];
      } else {
        sz = read4(ca);
        i = 0;
        if (sz == 0) {
          break;
        }
      }
    }
    return j;
  }
}
