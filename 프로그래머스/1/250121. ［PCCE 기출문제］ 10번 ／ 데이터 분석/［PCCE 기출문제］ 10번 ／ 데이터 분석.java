import java.util.*;


class Solution {
    
    int sortBy = -1;
    
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        List<Integer> list = new ArrayList<>();
        
        int std = -1;
        
        switch(ext) {
            case "code":
                std = 0;
                break;
            case "date":
                std = 1;
                break;
            case "maximum":
                std = 2;
                break;
            default: std = 3;
        }
        switch(sort_by) {
            case "code":
                sortBy = 0;
                break;
            case "date":
                sortBy = 1;
                break;
            case "maximum":
                sortBy = 2;
                break;
            default: sortBy = 3;
        }

        
        for(int i = 0; i < data.length; i++) {
            if(data[i][std] < val_ext) {
                list.add(i);
            }
        }
        
        int[][] answer = new int[list.size()][4];   
        
        for(int i = 0; i < answer.length; i++) {
            answer[i] = data[list.get(i)];
        }
        
        Arrays.sort(answer, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b) {
                return a[sortBy] - b[sortBy];
            }
        });
        
        return answer;
    }
}