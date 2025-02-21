import java.util.HashMap;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < name.length; i++){
            map.put(name[i], yearning[i]);
        }
        
        for(int i = 0; i < photo.length; i++){
            int temp = 0;
            for(String n : photo[i]){
                if(map.containsKey(n))
                    temp += map.get(n);
            }
            answer[i] = temp;
        }
        
        return answer;
    }
}