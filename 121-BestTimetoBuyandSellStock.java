class Solution {

  public int maxProfit(int[] prices) {
    if (prices == null || prices.length == 0) {
      return 0;
    }
    int ans = 0;
    int min = prices[0];
    for (int p : prices) {
      ans = Math.max(ans, p - min);
      min = Math.min(min, p);

    }
    return ans;
  }
}
