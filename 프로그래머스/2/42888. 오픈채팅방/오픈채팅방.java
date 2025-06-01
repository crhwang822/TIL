import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        List<String> list = new ArrayList<>();
        Map<String,String> map = new HashMap<>();
        
        for(String r : record) {
            String[] arr = r.split(" ");
            switch(arr[0]) {
                case "Enter":
                    map.put(arr[1], arr[2]);
                    list.add("Enter " + arr[1]);
                    break;
                case "Leave":
                    list.add("Leave " + arr[1]);
                    break;
                case "Change":
                    map.replace(arr[1], arr[2]);
                    break;
            }
        }
        
        String[] answer = new String[list.size()];
        for(int i = 0; i < answer.length; i++) {
            String command = list.get(i).split(" ")[0];
            String message = map.get(list.get(i).split(" ")[1]);
            if(command.equals("Enter"))
                message += "님이 들어왔습니다.";
            else
                message += "님이 나갔습니다.";
            answer[i] = message;
        }
        
        return answer;
    }
}