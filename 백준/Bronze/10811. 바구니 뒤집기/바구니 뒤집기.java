import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] books = new int[n + 1];
		for(int i = 1; i < books.length; i++) {
			books[i] = i;
		}
		
		int a, b, mid;
		for(int ti = 0; ti < m; ti++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			mid = (b - a + 1)  / 2;
			
			for(int i = 0; i < mid; i++) {
				int temp = books[a + i];
				books[a + i] = books[b - i];
				books[b - i] = temp;
			}
			
		}
		
		for(int i = 1; i < books.length; i++) {
			bw.write(books[i] + " ");
		}
		
		bw.close();
		
		
	}

}
