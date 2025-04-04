class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        
        //꺼내려는 상자가 있는 층 (0층부터 시작)
        int floor = (num - 1) / w;
        //꼭대기 층
        int top = (n - 1) / w;
        
        //꺼내려는 상자가 있는 열
        int column = Math.abs(w * (floor + (floor % 2)) - (num - 1) - (floor %2));
        //꼭대기 층의 같은 열에 있는 상자 번호
        int topItem;
        if(top % 2 == 0) topItem = w * top + column;
        else topItem = w * (top + 1) - column - 1;
        
        answer += top - floor;
        
        if(topItem <= (n -1)) answer++;
                
        return answer;
    }
}
