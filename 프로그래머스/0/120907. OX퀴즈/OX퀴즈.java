import java.lang.Integer;

class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        for(int i=0; i<quiz.length; i++){
            String[] q = quiz[i].replace("= ","").split(" ");
            String operator = q[1];
            if(operator.equals("+")){
                if(Integer.parseInt(q[0]) + Integer.parseInt(q[2]) == Integer.parseInt(q[3]))
                    answer[i] = "O";
                else answer[i] = "X";
            }
            else{
                if(Integer.parseInt(q[0]) - Integer.parseInt(q[2]) == Integer.parseInt(q[3]))
                    answer[i] = "O";
                else answer[i] = "X";
            }
        }
        return answer;
    }
}