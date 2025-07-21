import java.io.*;


public class Main{
	public static int count = 0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		boolean[] cols = new boolean[n];
		boolean[] sum = new boolean[2*n + 1];
		boolean[] diff = new boolean[2*n + 1];
		
		for(int i = 0; i < n; i++) {
			dfs(n, 0, i, cols, sum, diff);
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(count+"");
		bw.close();
	}
		
	
	public static void dfs(int n, int r, int c, boolean[] cols, boolean[] sum, boolean[] diff) {
		//열 체크
		if(cols[c])
			return;
		
		//양의 방향 대각선 체크
		if(sum[r + c])
			return;
		
		//음의 방향 대각선 체크
		if(diff[r-c + n])
			return;
		
		if(r == n - 1) {
			count++;
		}
		
		cols[c] = true;
		sum[r+c] = true;
		diff[r-c+n] = true;
		
		for(int i = 0; i < n; i++) {
			if(!cols[i]) {
				dfs(n, r+1, i, cols, sum, diff);
			}
		}
		
		cols[c] = false;
		sum[r+c] = false;
		diff[r-c+n] = false;
		
	}
} 