class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = health;
        int successive = 0;
        int idx = 0;
        
        for(int i = 0; i <= attacks[attacks.length - 1][0]; i++) {
            if(attacks[idx][0] == i) {
                successive = 0;
                answer -= attacks[idx][1];
                if(answer <= 0) return -1;
                idx++;
                continue;
            }
            
            successive++;
            
            answer = heal(answer, bandage[1], health);
            
            if(successive == bandage[0]) {
                successive = 0;
                answer = heal(answer, bandage[2], health);
            }
            
        }
        
        return answer;
    }
    
    private int heal(int health, int amount, int max) {
        if(health < max) 
            return Math.min(max, health + amount);
        return health;
    }
}