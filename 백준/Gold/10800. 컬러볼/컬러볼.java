import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int c, s;
        int[][] arr = new int[N][3];
        int[] result = new int[N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            c = Integer.parseInt(st.nextToken());
            s = Integer.parseInt(st.nextToken());
            arr[i] = new int[]{i, c, s};
        }

        Map<Integer, Integer> colorMap = new HashMap<>();

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });


        int sum = 0;
        int temp = 0;
        List<int[]> tempList = new ArrayList<>();
        for(int i = 0; i < arr.length; i++) {

            if((i > 0 && arr[i][2] != arr[i - 1][2])) {
                // temp 반영
                sum += temp;
                temp = 0;

                // tempList 반영
                for(int j = 0; j < tempList.size(); j++) {
                    colorMap.put(tempList.get(j)[1], colorMap.getOrDefault(tempList.get(j)[1], 0) + tempList.get(j)[2]);
                }
                tempList.clear();
            }

            // 크기가 같은 공들이 연속적으로 나온다면
            if((i > 0 && arr[i][2] == arr[i - 1][2]) || (i < arr.length - 1 && arr[i][2] == arr[i + 1][2])) {
                temp += arr[i][2];
                tempList.add(arr[i]);
                result[arr[i][0]] = sum - colorMap.getOrDefault(arr[i][1], 0);
            } else {
                result[arr[i][0]] = sum - colorMap.getOrDefault(arr[i][1], 0);
                sum += arr[i][2];
                colorMap.put(arr[i][1], colorMap.getOrDefault(arr[i][1], 0) + arr[i][2]);
            }
        }

        for(int i = 0; i < result.length; i++) {
            sb.append(result[i]);
            sb.append("\n");
        }

        System.out.println(sb.toString());

    }
}