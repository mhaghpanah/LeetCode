class Solution {

  public int dist(int[] a) {
    return a[0] * a[0] + a[1] * a[1];
  }

  public int[][] kClosest(int[][] points, int K) {
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> dist(b) - dist(a));
    for (int[] a : points) {
      pq.add(a);
      if (pq.size() > K) {
        pq.remove();
      }
    }
    int[][] ans = new int[K][2];
    for (int i = 0; i < K; i++) {
      ans[K - 1 - i] = pq.remove();
    }
    return ans;
  }
}
