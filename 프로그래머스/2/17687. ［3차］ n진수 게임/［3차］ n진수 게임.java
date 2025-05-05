class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        int round = 0;
        String answer = "";
        
        while(sb.length() < m * (t - 1) + p) {
            sb.append(Integer.toString(round++, n));
        }
        
        for(int i = 0; i < t; i++) {
            answer += sb.toString().charAt(i * m + p - 1);
        }
        
        return answer.toUpperCase();
    }
}