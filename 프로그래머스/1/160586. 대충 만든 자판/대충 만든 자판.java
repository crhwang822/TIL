import java.lang.Math;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        
        int minClick = 0;
        int tmp = 200;
        
        for(int i = 0; i < targets.length; i++){
            for(int j = 0; j < targets[i].length(); j++){
                tmp = 200;
                for(int k = 0; k < keymap.length; k++){
                    int click = keymap[k].indexOf(targets[i].charAt(j));
                    if(click == 0){
                        tmp = 1;
                        break;
                    }else if(click != -1){
                        tmp = Math.min(keymap[k].indexOf(targets[i].charAt(j)) + 1, tmp);
                    }

                }
                if(tmp == 200){
                    minClick = -1;
                    break;
                } else {
                    minClick += tmp;
                }
            }
            answer[i] = minClick;
            minClick = 0;
        }
        
        return answer;
    }
}