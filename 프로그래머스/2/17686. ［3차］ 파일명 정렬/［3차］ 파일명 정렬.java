import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        Map<String, int[]> map = new HashMap<>();
        for(int i = 0; i < files.length; i++) {
            String file = files[i];
            map.put(file, new int[3]);
            int s = 0, e = file.length();
            for(int j = 0; j < file.length(); j++) {
                if(Character.isDigit(file.charAt(j))) {
                    s = j;
                    break;
                }
            }
            for(int j = s; j < file.length(); j++) {
                if(!Character.isDigit(file.charAt(j))) {
                    e = j;
                    break;
                }
            }
            map.get(file)[0] = s;
            map.get(file)[1] = e;
            map.get(file)[2] = i;
        }
        Arrays.sort(files, new Comparator<String>(){
            @Override
            public int compare(String a, String b) {
                int[] arr1 = map.get(a);
                int[] arr2 = map.get(b);
                String h1 = a.substring(0, arr1[0]).toUpperCase();
                String h2 = b.substring(0, arr2[0]).toUpperCase();
                if(!h1.equals(h2))
                    return h1.compareTo(h2);
                int n1 = Integer.parseInt(a.substring(arr1[0], arr1[1]));
                int n2 = Integer.parseInt(b.substring(arr2[0], arr2[1]));
                if(n1 != n2)
                    return n1 - n2;
                return arr1[2] - arr2[2];
            }
        });
        return files;
    }
}