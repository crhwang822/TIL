class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int zeroCnt = 0;
        int cnt = 0;
        int[] rank = {6,6,5,4,3,2,1};
        
        
        for(int i = 0; i < lottos.length; i++){
            if(lottos[i] == 0){
                zeroCnt++;                
            }
            for(int j = 0; j < win_nums.length; j++){
                if(lottos[i] == win_nums[j])
                    cnt++;
            }
        }
        
        int[] answer = new int[]{rank[cnt+zeroCnt], rank[cnt]};
        
        return answer;
    }
}