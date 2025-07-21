import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		int[] pos = new int[N];
		int[] distance = new int[N-1];
		
		
		
		for(int i = 0; i < N; i++) {
			pos[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(pos);
		
		int s = 1;
		int e = pos[N-1] - pos[0];
		int answer = 0;
		
		while(s <= e) {
			int mid = (s+e)/2;
			int prev = 0;
			int r = C - 1; // 첫번째 집에는 무조건 설치
			for(int i = 1; i < N; i++) {
				prev += pos[i] - pos[i-1];
				if(prev >= mid) {
					r--;
					prev = 0;
				}
				if(r == 0)
					break;
			}
			if(r > 0)
				e = mid - 1;
			else {
				answer = mid;
				s = mid + 1;
			}
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(answer+"");
		bw.close();
	}
	
}
