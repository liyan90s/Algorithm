class MyQueue {
    Stack<Integer> mainStack, helperStack;
    
    /** Initialize your data structure here. */
    public MyQueue() {
        mainStack = new Stack<>();
        helperStack = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        mainStack.push(x);
    }

    public void transferStack() {
        while (!mainStack.isEmpty()) {
            helperStack.push(mainStack.pop());
        }
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (helperStack.isEmpty()) {
            transferStack();
        }
        return helperStack.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if (helperStack.isEmpty()) {
            transferStack();
        }
        return helperStack.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return mainStack.isEmpty() && helperStack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */