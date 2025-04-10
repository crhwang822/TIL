class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right - left) + 1];
        int start = (int)(left / n);
        int end = (int)(right / n);
        int num = (int)(left % n);
        int index = 0;
        
        for(int i = start; i <= end; i++) {
            for(int j = num; j != n && index < answer.length; j++) {
                answer[index++] = Math.max(i + 1, j + 1);
            }
            num = 0;
        }
        
        return answer;
    }
}