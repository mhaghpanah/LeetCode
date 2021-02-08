class Solution {

  public int trap(int[] height) {
    if (height == null || height.length == 0) {
      return 0;
    }
    int n = height.length;
    int ans = 0;
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < n; i++) {
      while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
        int top = stack.pop();
        if (stack.isEmpty()) {
          break;
        }
        ans += (Math.min(height[stack.peek()], height[i]) - height[top]) * (i - stack.peek() - 1);
      }
      stack.push(i);
    }
    return ans;
  }
}
