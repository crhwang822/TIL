class Solution {
    public int solution(int[][] dots) {
        int answer = 0;
        
        int[] c1 = dots[0];
        int[] c2 = dots[1];
        int[] c3 = dots[2];
        int[] c4 = dots[3];
        
        if(line(c1, c2) == line(c3,c4) && line(c1, c2) != 0){
            return 1;
        }
                
        if(line(c1, c3) == line(c2,c4) && line(c1, c3) != 0){
            return 1;
        }
                
        if(line(c1, c4) == line(c2,c3) && line(c1, c4) != 0){
            return 1;
        }
        
        
        return answer;
    }
    
    
    public double line(int[] dotA, int[] dotB){
        if(dotA[0] == dotB[0] || dotA[1] == dotB[1])
            return 0;
        return (dotA[1] - dotB[1]) / (dotA[0] - dotB[0]);
    }
}
