class Solution {


  public int oddEvenJumps(int[] A) {

    TreeMap<Integer, Integer> map = new TreeMap<>();
    int n = A.length;
    map.put(A[n - 1], n - 1);
    boolean[] odd = new boolean[n];
    boolean[] even = new boolean[n];
    odd[n - 1] = even[n - 1] = true;
    int ans = 1;
    for (int i = n - 2; i >= 0; i--) {
      int v = A[i];
      Integer floor = map.floorKey(v);
      Integer ceiling = map.ceilingKey(v);
      if (floor != null) {
        even[i] = odd[map.get(floor)];
      }
      if (ceiling != null) {
        odd[i] = even[map.get(ceiling)];
      }
      if (odd[i]) {
        ans++;
      }
      map.put(A[i], i);
    }
    return ans;

  }
}
