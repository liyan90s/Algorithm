public class Solution {
    /*
     * @param s: an expression includes numbers, letters and brackets
     * @return: a string
     */
    public String expressionExpand(String s) {
        // write your code here
        if (s == null || s.length() == 0) {
            return "";
        }
        
        Stack<Object> stack = new Stack<>();
        int num = 0;
        
        for (Character c : s.toCharArray()) {
            if (c == '[') {
                stack.push(Integer.valueOf(num));
                num = 0;
            } else if (c == ']') {
                String expandedString = popStack(stack);
                Integer count = (Integer) stack.pop();
                String substr = "";
                for (int i = 0; i < count; i++) {
                    substr += expandedString;
                }
                
                stack.push(substr);
            } else if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } else {
                stack.push(String.valueOf(c));
            }
        }
        
        String result = popStack(stack);
        return result;
    }
    
    public String popStack(Stack<Object> stack) {
        Stack<String> helper = new Stack<String>();
        
        StringBuffer sb = new StringBuffer();
        while (!stack.isEmpty() && stack.peek() instanceof String) {
            helper.push((String) stack.pop());
        }
        
        while (!helper.isEmpty()) {
            sb.append(helper.pop());
        }
        
        return sb.toString();
    }
}