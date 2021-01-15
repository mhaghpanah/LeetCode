class Solution {

  public int candy(int[] ratings) {
    int n = ratings.length;
    int[] left = new int[n];
    left[n - 1] = 1;
    for (int i = n - 2; i >= 0; i--) {
      if (ratings[i + 1] < ratings[i]) {
        left[i] = left[i + 1] + 1;
      } else {
        left[i] = 1;
      }
    }

    int ans = 0;
    int right = 1;
    for (int i = 0; i < n; i++) {
      if (i > 0) {
        if (ratings[i - 1] < ratings[i]) {
          right++;
        } else {
          right = 1;
        }
      }
      ans += Math.max(left[i], right);
    }
    return ans;
  }
}
