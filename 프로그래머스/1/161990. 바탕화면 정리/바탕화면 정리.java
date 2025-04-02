import java.lang.Math;

class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = {50,50,0,0};
        int height = wallpaper.length;
        int width = wallpaper[0].length();
        
        for(int i = 0; i < height; i++) { //꼭대기 층부터 탐색
            for(int j = 0; j < width; j++) {
                if(wallpaper[i].charAt(j) == '#') {
                    answer[0] = Math.min(answer[0], i);
                    answer[1] = Math.min(answer[1], j);
                    answer[2] = Math.max(answer[2], i);
                    answer[3] = Math.max(answer[3], j);
                }
            }
        }
        
        answer[2]++; answer[3]++;
        
        return answer;
    }
}