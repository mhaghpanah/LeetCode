class Solution {

  public int[] intersection(int[] nums1, int[] nums2) {
    Set<Integer> set = new HashSet<>();
    Set<Integer> ans = new HashSet<>();
    for (int a : nums1) {
      set.add(a);
    }
    for (int a : nums2) {
      if (set.contains(a)) {
        ans.add(a);
      }
    }
    int[] arr = new int[ans.size()];
    int index = 0;
    for (int a : ans) {
      arr[index++] = a;
    }
    return arr;
  }
}
