class Solution {
    public int solution(int n) {
        int answer = n + 1;
        int count = Integer.toString(n, 2).length() - Integer.toString(n, 2).replace("1", "").length();
        
        while(true) {
            int temp = Integer.toString(answer, 2).length() - 
                Integer.toString(answer, 2).replace("1", "").length();
            if(count == temp) 
                break;
            answer++;
        }
        
        return answer;
    }
}