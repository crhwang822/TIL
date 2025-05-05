import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        
        Stack<Integer> st = new Stack<>();
        st.push(0);
        
        //스택에 들어온다 ==> 스택에 존재하는 값들의 뒷큰수가 아니다
        for(int i = 1; i < numbers.length; i++) {
            while(!st.isEmpty() && numbers[st.peek()] < numbers[i]) {
                answer[st.pop()] = numbers[i];
            }
            st.push(i);
        }
        
        while(!st.isEmpty()) {
            answer[st.pop()] = -1;
        }
        
        return answer;
    }
}