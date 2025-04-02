class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2]; // {세로좌표, 가로좌표}
        int[] limit = new int[]{park.length, park[0].length()};
        
        //시작 지점 설정
        answer = initialize(park);
        
        //명령 수행
        for(String op : routes) {
            int direction = -1;
            int distance = Integer.parseInt(op.split(" ")[1]);
    
            
            if(op.split(" ")[0].equals("N") || op.split(" ")[0].equals("S"))
                direction = 0;
            else 
                direction = 1;
            
            if(op.split(" ")[0].equals("N") || op.split(" ")[0].equals("W"))
                distance *= -1;
            
            //공원을 벗어나는지 확인
            int result = answer[direction] + distance;
            if(result < 0 || result >= limit[direction]) 
                continue;
            
            //장애물이 있는지 확인
            if(!isAvailable(park, answer.clone(), direction, distance)) 
                continue;
            
            answer[direction] = result;
        }
        
        return answer;
    }
    
    private boolean isAvailable(String[] park, int[] arr, int dir, int dis) {
        for(int i = 1; i < Math.abs(dis) + 1; i++) {
            arr[dir] += dis / Math.abs(dis);
            if(park[arr[0]].charAt(arr[1]) == 'X') 
                return false;
        }
        return true;
    }
    
    private int[] initialize(String[] park) {
        for(int i = 0; i < park.length; i++) {
            for(int j = 0; j < park[0].length(); j++) {
                if(park[i].charAt(j) == 'S') {
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{0,0};
    }
}