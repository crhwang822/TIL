class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 1;
        int temp = section[0];
        
        for(int i = 0; i < section.length; i++){
            if(section[i] >= temp + m){
                temp = section[i];
                answer++;
            }
        }
        
        return answer;
    }
}