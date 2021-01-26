class Solution {

  public List<Integer> countSmaller(int[] nums) {
    List<Integer> ans = new ArrayList<>();
    int n = nums.length;
    int m = 20_020;
    SegmentTree st = new SegmentTree(m);
    for (int i = n - 1; i >= 0; i--) {
      nums[i] += 10_010;
      ans.add(st.getSum(0, nums[i] - 1));
      st.update(nums[i], 1);
    }
    Collections.reverse(ans);
    return ans;
  }

  public class SegmentTree {

    int n;
    int[] t;

    public SegmentTree(int n) {
      this.n = n;
      t = new int[4 * n];
    }

    public void update(int index, int value) {
      update(1, 0, n - 1, index, value);
    }

    public void update(int v, int tl, int tr, int index, int add) {
      if (tl == tr) {
        t[v] += add;
      } else {
        int tm = (tl + tr) / 2;
        if (index <= tm) {
          update(2 * v, tl, tm, index, add);
        } else {
          update(2 * v + 1, tm + 1, tr, index, add);
        }
        t[v] = t[2 * v] + t[2 * v + 1];
      }
    }

    public int getSum(int l, int r) {
      return getSum(1, 0, n - 1, l, r);
    }

    public int getSum(int v, int tl, int tr, int l, int r) {
      if (r < l) {
        return 0;
      }
      if (tl == l && tr == r) {
        return t[v];
      }
      int tm = (tl + tr) / 2;
      return getSum(2 * v, tl, tm, l, Math.min(r, tm))
          + getSum(2 * v + 1, tm + 1, tr, Math.max(l, tm + 1), r);
    }
  }
}
