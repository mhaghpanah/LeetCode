class Solution {

  String[] LESS_THAN_TWEENTY = new String[]{"Zero", "One", "Two", "Three", "Four", "Five", "Six",
      "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen",
      "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
  String[] TENS = new String[]{"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy",
      "Eighty", "Ninety"};
  String[] THOUSANDS = new String[]{"", "Thousand", "Million", "Billion"};

  public String numberToWords(int num) {
    if (num == 0) {
      return LESS_THAN_TWEENTY[0];
    }
    StringBuilder sb = new StringBuilder();
    int index = 0;
    while (num > 0) {
      if (num % 1000 != 0) {
        StringBuilder sb1 = new StringBuilder();
        solve(sb1, num % 1000);
        sb1.append(THOUSANDS[index]).append(" ");
        sb.insert(0, sb1);
      }
      num /= 1000;
      index++;
    }
    return sb.toString().trim();
  }

  public void solve(StringBuilder sb, int num) {
    if (num == 0) {
      return;
    } else if (num < 20) {
      sb.append(LESS_THAN_TWEENTY[num]).append(" ");
    } else if (num < 100) {
      sb.append(TENS[num / 10]).append(" ");
      solve(sb, num % 10);
    } else {
      sb.append(LESS_THAN_TWEENTY[num / 100]).append(" Hundred ");
      solve(sb, num % 100);
    }
  }

}
