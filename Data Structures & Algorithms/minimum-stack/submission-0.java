class MinStack {

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> mins = new Stack<>();


    public MinStack() {
        
    }
    
    public void push(int val) {
        if (mins.isEmpty()) {
            mins.push(val);
        } else {
            mins.push(Math.min(val, mins.peek()));
        }
        stack.push(val);
    }
    
    public void pop() {
        mins.pop();
        stack.pop();
      
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return mins.peek();
    }
}
