class MyQueue {
    Stack<Integer> mainStack, helpStack;
    
    /** Initialize your data structure here. */
    public MyQueue() {
        mainStack = new Stack<>();
        helpStack = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        mainStack.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (!helpStack.isEmpty()) {
            return helpStack.pop();
        } 
        
        while (!mainStack.isEmpty()) {
            helpStack.push(mainStack.pop());
        }
        
        return helpStack.isEmpty() ? Integer.MAX_VALUE : helpStack.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if (!helpStack.isEmpty()) {
            return helpStack.peek();
        }
        
        while (!mainStack.isEmpty()) {
            helpStack.push(mainStack.pop());
        }
        
        return helpStack.isEmpty() ? Integer.MAX_VALUE : helpStack.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return mainStack.isEmpty() && helpStack.isEmpty();
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