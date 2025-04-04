class Solution {
    public int[] solution(String s) {
        int deleted = 0;
        int count = 0;
        
        do {
            count++;
            int len = s.length();
            s = s.replace("0", "");
            deleted += len - s.length();
            
            s = Integer.toBinaryString(s.length());
            
        } while(!s.equals("1"));
        
        int[] answer = {count, deleted};
        
        return answer;
    }
}