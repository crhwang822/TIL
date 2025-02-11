class Solution {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        
        //연속합은 num * x + (0 + 1 + ... + (n-1)) 로 표현된다.
        //상수항은 등차수열의 합 공식을 사용해 구하기
        int c = (num * (num - 1)) / 2;
        int start = (total - c) / num;
        
        for(int i=0; i<num; i++)
            answer[i] = start + i;
        
        return answer;
    }
}