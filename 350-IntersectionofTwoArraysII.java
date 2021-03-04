class Solution {

  public int[] intersect(int[] nums1, int[] nums2) {
    Map<Integer, Integer> count = new HashMap<>();
    for (int a : nums1) {
      count.put(a, count.getOrDefault(a, 0) + 1);
    }
    
    Map<Integer, Integer> ans = new HashMap<>();
    int t = 0;
    for (int a : nums2) {
      if (count.containsKey(a)) {
        ans.put(a, ans.getOrDefault(a, 0) + 1);
        t++;
        if (count.get(a) == 1) {
          count.remove(a);
        } else {
          count.put(a, count.get(a) - 1);
        }
      }
    }
    
    int[] arr = new int[t];
    for (int key : ans.keySet()) {
      for (int i = 0; i < ans.get(key); i++) {
        arr[--t] = key;
      }
    }

    return arr;
  }
}
