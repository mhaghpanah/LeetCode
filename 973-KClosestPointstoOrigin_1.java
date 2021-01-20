class Solution {

  Random random;

  public int dist(int[] a) {
    return a[0] * a[0] + a[1] * a[1];
  }

  public void swap(int[][] points, int a, int b) {
    int[] t = points[a];
    points[a] = points[b];
    points[b] = t;
  }

  public int partition(int[][] points, int lo, int hi) {
    int randIndex = lo + random.nextInt(hi - lo + 1);
    swap(points, randIndex, hi);
    int index = lo;
    for (int i = lo; i < hi; i++) {
      if (dist(points[i]) <= dist(points[hi])) {
        swap(points, i, index);
        index++;
      }
    }
    swap(points, index, hi);
    return index;
  }

  public void quickselect(int[][] points, int K, int lo, int hi) {
    if (lo == hi) {
      return;
    }
    int index = partition(points, lo, hi);
    if (index == K) {
      return;
    } else if (K < index) {
      quickselect(points, K, lo, index - 1);
    } else {
      quickselect(points, K, index + 1, hi);
    }
  }

  public int[][] kClosest(int[][] points, int K) {
    random = new Random();
    quickselect(points, K - 1, 0, points.length - 1);
    int[][] ans = new int[K][2];
    for (int i = 0; i < K; i++) {
      ans[i] = points[i];
    }
    return ans;
  }
}
