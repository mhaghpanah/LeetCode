class Solution {

  int[] nums;
  int n;
  Random random;

  public void swap(int i, int j) {
    int t = nums[i];
    nums[i] = nums[j];
    nums[j] = t;
  }

  public int partition(int lo, int hi) {
    int randIndex = lo + random.nextInt(hi - lo + 1);
    swap(randIndex, hi);
    int pivotIndex = lo;
    for (int i = lo; i < hi; i++) {
      if (nums[i] < nums[hi]) {
        swap(i, pivotIndex++);
      }
    }
    swap(pivotIndex, hi);
    return pivotIndex;
  }

  public int quickselect(int lo, int hi, int k) {
    if (lo == hi) {
      return nums[lo];
    }

    int pivotIndex = partition(lo, hi);
    if (pivotIndex == k) {
      return nums[pivotIndex];
    } else if (k < pivotIndex) {
      return quickselect(lo, pivotIndex - 1, k);
    }
    return quickselect(pivotIndex + 1, hi, k);
  }

  public int findKthLargest(int[] nums, int k) {
    this.nums = nums;
    n = nums.length;
    random = new Random();
    return quickselect(0, n - 1, n - k);
  }
}
