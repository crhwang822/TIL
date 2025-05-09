import java.util.Stack;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        int num = 1;
        
        //보조 컨테이너 벨트
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i < order.length; i++) {
            //보조 컨테이너에서 상자를 꺼내는 경우
            if(!stack.isEmpty() && stack.peek() == order[i]) {
                stack.pop();
                answer++;
                continue;
            }
            
            while(order[i] > num) {
                stack.push(num++);
            }
            
            //기존 컨테이너에서 상자를 꺼내는 경우
            if(order[i] == num) {
                num++;
                answer++;
                continue;
            } 
            //어떤 컨테이너에서도 상자를 꺼낼 수 없는 경우
            else 
                break;
        }
        
        return answer;
    }
}