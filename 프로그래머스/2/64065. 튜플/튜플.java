import java.util.*;

class Solution {
    public int[] solution(String s) {
        String[] arr = s.replace("},", " ").replaceAll("[{}]", "").split(" ");
        Arrays.sort(arr, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        
        List<String> list = new ArrayList<>();
        for(int i = 0; i < arr.length; i++) {
            for(String j : arr[i].split(",")) {
                if(!list.contains(j))
                    list.add(j);
            }
        }
        
        int[] answer = new int[list.size()];
        for(int i = 0; i < answer.length; i++)
            answer[i] = Integer.parseInt(list.get(i));
        
        return answer;
    }
}