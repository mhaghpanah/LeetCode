class MinStack {

  Stack<Integer> stack;
  Stack<Integer> min;

  /**
   * initialize your data structure here.
   */
  public MinStack() {
    stack = new Stack<>();
    min = new Stack<>();
  }

  public void push(int x) {
    stack.push(x);
    if (min.isEmpty()) {
      min.push(x);
    } else {
      min.push(Math.min(x, min.peek()));
    }
  }

  public void pop() {
    stack.pop();
    min.pop();
  }

  public int top() {
    return stack.peek();
  }

  public int getMin() {
    return min.peek();
  }
}


/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
