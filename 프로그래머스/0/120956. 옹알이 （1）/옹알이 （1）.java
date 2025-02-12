class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        
        for(String s : babbling){
            s = s.replaceFirst("aya", "1").replaceFirst("ye", "1")
                .replaceFirst("woo", "1").replaceFirst("ma","1");
            s = s.replace("1", "");
            if(s.isEmpty()) answer++;
        }
        
        return answer;
    }
}