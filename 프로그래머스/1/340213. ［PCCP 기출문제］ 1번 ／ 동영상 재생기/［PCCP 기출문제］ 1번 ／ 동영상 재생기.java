class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int len = toSeconds(video_len);
        int p = toSeconds(pos);
        int s = toSeconds(op_start);
        int e = toSeconds(op_end);
        
        if(p >= s && p <= e) {
            p = e;
        }
        
        for(String command : commands) {
            
            switch(command) {
                case "prev" :
                    p = Math.max(p - 10, 0);
                    break;
                case "next" :
                    p = Math.min(p + 10, len);
                    break;
            }
            
            if(p >= s && p <= e) {
                p = e;
            }
            
        }
        
        String answer = String.format("%02d",p / 60) + ":" + String.format("%02d", p % 60);
        
        return answer;
    }
    
    private int toSeconds(String time) {
        return Integer.parseInt(time.split(":")[0]) * 60 + Integer.parseInt(time.split(":")[1]);
    }
}