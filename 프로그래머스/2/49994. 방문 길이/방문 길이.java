class Solution {
    public int solution(String dirs) {
        int answer = 0;
        
        int[] current = new int[]{5,5};
        boolean[][] hVisited = new boolean[11][10];
        boolean[][] vVisited = new boolean[10][11];
        
        for(char dir : dirs.toCharArray()){
            switch(dir) {
                case 'U' :
                    if(current[1] < 10) {
                        answer += checkVisited(hVisited, current[0], current[1]);
                        current[1] += 1;
                    }
                    break;
                case 'D':
                    if(current[1] > 0) {
                        current[1] -= 1;
                        answer += checkVisited(hVisited, current[0], current[1]);
                    }
                    break;
                case 'R':
                    if(current[0] < 10) {
                        answer += checkVisited(vVisited, current[0], current[1]);
                        current[0] += 1;
                    }
                    break;
                case 'L':
                    if(current[0] > 0) {
                        current[0] -= 1;
                        answer += checkVisited(vVisited, current[0], current[1]);   
                    }
                    break;
            }
        }
        
        return answer;
    }
    
    public int checkVisited(boolean[][] visited, int x, int y) {
        if(!visited[x][y]) {
            visited[x][y] = true;
            return 1;
        }
        return 0;
    }
}