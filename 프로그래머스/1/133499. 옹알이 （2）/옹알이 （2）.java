class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        
        for(String word : babbling){
            word = word.replace("aya", "A");
            word = word.replace("ye", "B");
            word = word.replace("woo", "C");
            word = word.replace("ma", "D");
            
            if(word.contains("AA") || word.contains("BB") || 
               word.contains("CC") || word.contains("DD")) continue;
            
            word = word.replace("A", "");
            word = word.replace("B", "");
            word = word.replace("C", "");
            word = word.replace("D", "");
            if(word.isEmpty()) answer++;
        }
        
        return answer;
    }
}