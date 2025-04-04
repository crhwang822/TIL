class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int total = brown + yellow;
        
        int bw = 0;
        int bh = 0;
        int yw = 0;
        int yh = 0;
        
        for(int i = 1; i <= Math.sqrt(yellow); i++) {
            if(yellow % i == 0 && total % (i + 2) == 0) {
                answer[0] = total / (i + 2);
                answer[1] = i + 2;
                
                if(answer[0] == yellow / i + 2) break;
            }
        }
        
        return answer;
    }
}