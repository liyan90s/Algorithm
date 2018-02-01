class MinStack {
    Stack<Integer> stack, minStack;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }
    
    public void pop() {
        if (!stack.isEmpty()) {
            int val = stack.pop();
            if (val == minStack.peek()) {
                minStack.pop();
            }
        }
    }
    
    public int top() {
        if (!stack.isEmpty()) {
            return stack.peek();
        } else {
            return 0;
        }
    }
    
    public int getMin() {
        if (!minStack.isEmpty()) {
            return minStack.peek();
        } else {
            return Integer.MAX_VALUE;
        }
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