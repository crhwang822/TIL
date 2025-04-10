import java.util.*;

class Solution {
    public int solution(int k, int[][] dungeons) {
        Arrays.sort(dungeons, new Comparator<>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0]; //최소 필요 피로도 기준 오름차순 정렬
            }
        });
        
        //dungeon 배열의 인덱스를 저장
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < dungeons.length; i++)
            list.add(i);
        
        int answer = count(list, dungeons, k);
        return answer;
    }
    
    private int count(List<Integer> list, int[][] dungeons, int k) {
        int max = 0;
        for(int i = 0; i < list.size(); i++) {
            int idx = list.get(i);
            List<Integer> temp = new ArrayList<>(list);
            if(dungeons[idx][0] > k)
                break;
            temp.remove(i);
            max = Math.max(max, count(temp, dungeons, k - dungeons[idx][1]) + 1);
        }
        return max;
    }
}