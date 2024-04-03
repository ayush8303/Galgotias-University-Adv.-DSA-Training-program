class Solution {
    public static int checkRedundancy(String s) {
        Stack<Character> stack=new Stack<>();
        
        for(char ch:s.toCharArray()){
            if(ch!=')'){
                stack.push(ch);
            }
            else {
                // ch==')'
                boolean operatorFound=false;
                while( stack.peek()!='('){
                    char top=stack.pop();
                    if(top=='+' || top=='-' || top=='*' || top=='/'){
                        operatorFound=true;
                    }
                }
                stack.pop();
                if(operatorFound==false){
                    return 1;
                }
            }
        }
        return 0;
    }
}