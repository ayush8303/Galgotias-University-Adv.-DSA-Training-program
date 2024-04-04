class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();
        
        for(char ch:s.toCharArray()){
            switch(ch){
                case '(':
                case '{':
                case '[':
                    stack.push(ch);
                    break;
                case ')':
                    if(!stack.isEmpty() && stack.peek()=='(')
                        stack.pop();
                    else 
                        return false;
                    break;
                case '}':
                    if(!stack.isEmpty() && stack.peek()=='{')
                        stack.pop();
                    else 
                        return false;
                    break;
                case ']':
                     if(!stack.isEmpty() && stack.peek()=='[')
                        stack.pop();
                    else 
                        return false;
                    break;
            }
        }
        return stack.isEmpty();
    }
}