import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] arr = new int[9][9];
        int sum = 0;
        List<int[]> list = new ArrayList<>();
        for(int i = 0; i < 9; i++){
            String[] a = br.readLine().split(" ");
            for(int j = 0; j < 9; j++){
                arr[i][j] = Integer.parseInt(a[j]);
                sum += arr[i][j];
                if(arr[i][j] == 0) {
                    list.add(new int[]{i,j});
                }
            }
        }

        dfs(arr, 0, 0);

    }

    public static void dfs(int[][] arr, int r, int c) throws IOException{
        if(c == 9)
            dfs(arr, r+1, 0);

        else if(r == 9) {
            print(arr);
            System.exit(0);
        }

        else if(arr[r][c] == 0) {
            for(int i = 1; i <= 9; i++) {
                if(checkNum(arr, r, c, i)) {
                    arr[r][c] = i;
                    dfs(arr, r, c + 1);
                    arr[r][c] = 0;
                }
            }
        } else
            dfs(arr, r, c + 1);
    }

    public static boolean checkNum(int[][] arr, int r, int c, int num) {
        //행, 열 검사
        for(int i = 0; i < 9; i++) {
            if(arr[i][c] == num|| arr[r][i] == num)
                return false;
        }

        //칸 탐색
        int x = (r / 3) * 3;
        int y = (c / 3) * 3;
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(arr[x + i][y + j] == num)
                    return false;
            }
        }
        return true;
    }


    public static void print(int[][] arr) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                bw.write(arr[i][j] + " ");
            }
            bw.newLine();
        }
        bw.close();
    }


}