import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> totalPlays = new HashMap<>();
        Map<String, List<int[]>> songs = new HashMap<>();
        
        for(int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            if(!totalPlays.containsKey(genre)) {
                songs.put(genre, new ArrayList<>());
            }
            songs.get(genre).add(new int[]{i, plays[i]});
            totalPlays.put(genre, totalPlays.getOrDefault(genre, 0) + plays[i]);
        }
        
        List<String> keys = new ArrayList<>(totalPlays.keySet());
        Collections.sort(keys, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return totalPlays.get(s2) - totalPlays.get(s1);
            }
        });
        
        for(String key : keys) {
            Collections.sort(songs.get(key), new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if(o1[1] == o2[1])
                        return o1[0] - o2[0];
                    return o2[1] - o1[1];
                }
            });
        }
        
        List<Integer> result = new ArrayList<>();
        for(String key : keys) {
            List<int[]> li = songs.get(key);
            result.add(li.get(0)[0]);
            if(li.size() > 1)
                result.add(li.get(1)[0]);
        }
        
        int[] answer = new int[result.size()];
        for(int i = 0; i < result.size(); i++)
            answer[i] = result.get(i);
        
        return answer;
    }
}