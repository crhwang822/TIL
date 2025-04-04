import java.util.Stack;

class Solution
{
    public int solution(String s)
    {
        int answer = 0;
        Stack<String> stack = new Stack<>();
        String[] arr = s.split("");
        
        for(String str : arr) {
            if(stack.isEmpty()) {
                stack.push(str);
                continue;
            }
            
            if(str.equals(stack.peek()))
                stack.pop();
            else 
                stack.push(str);
        }
        
        if(stack.isEmpty())
            answer = 1;
        
        return answer;
    }
}