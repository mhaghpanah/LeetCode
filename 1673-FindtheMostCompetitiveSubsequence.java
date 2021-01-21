class Solution {

  public int[] mostCompetitive(int[] nums, int k) {
    Stack<Integer> stack = new Stack<>();
    int n = nums.length;
    for (int i = 0; i < n; i++) {
      while (!stack.isEmpty() && n - i + stack.size() > k && nums[stack.peek()] > nums[i]) {
        stack.pop();
      }
      stack.push(i);
    }
    int[] ans = new int[k];
    List<Integer> list = new ArrayList<>(stack);
    for (int i = 0; i < k; i++) {
      ans[i] = nums[list.get(i)];
    }
    return ans;
  }
}
