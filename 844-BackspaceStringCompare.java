class Solution {

  public String canonical(String str) {
    Stack<Character> stack = new Stack<>();
    for (char ch : str.toCharArray()) {
      if (ch == '#') {
        if (!stack.isEmpty()) {
          stack.pop();
        }
      } else {
        stack.push(ch);
      }
    }
    return String.valueOf(stack);
  }

  public boolean backspaceCompare(String S, String T) {
    return canonical(S).equals(canonical(T));
  }
}
