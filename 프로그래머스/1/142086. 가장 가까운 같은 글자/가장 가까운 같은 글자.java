class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        
        int[] idx = new int[26];
        for(int i = 0; i < idx.length; i++)
            idx[i] = -1;
        
        for(int i = 0; i < answer.length; i++){
            int val = idx[(int)(s.charAt(i) - 'a')];
            answer[i] = val == -1? -1 : i - val ;
            idx[(int)(s.charAt(i) - 'a')] = i;
        }
        
        return answer;
    }
}