class Solution {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        answer[0] = x;
        
        //누적 덧셈 사용 -> long + int 이므로 (주어진 범위에서) 오버플로우 방지
        for(int i = 1; i < n; i++){
            answer[i] = answer[i-1] + x;
        }
        return answer;
    }
}