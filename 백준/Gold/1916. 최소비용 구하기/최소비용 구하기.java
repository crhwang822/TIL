import java.io.*;
import java.util.*;

public class Main {
	
	public static class Node {
		int num;
		int weight;
		Node(int num, int weight) {
			this.num = num;
			this.weight = weight;
		}
	}

	public static void main(String[] args) throws IOException{
		//-------여기에 해결 코드를 작성하세요.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		ArrayList<Node>[] graph = new ArrayList[n + 1];
		for(int i = 1; i < graph.length; i++)
			graph[i] = new ArrayList<>();
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int sn = Integer.parseInt(st.nextToken());
			int en = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			graph[sn].add(new Node(en, w));
		}
		
		st = new StringTokenizer(br.readLine());
		int sc = Integer.parseInt(st.nextToken());
		int ec = Integer.parseInt(st.nextToken());
		
		int[] dist = new int[n + 1];
		Arrays.fill(dist,  Integer.MAX_VALUE);
		dist[sc] = 0;
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
		pq.add(new int[] {sc, 0});
		
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			if(dist[cur[0]] < cur[1]) {
				continue;
			}
			
			for(Node node : graph[cur[0]]) {
				if(dist[cur[0]] + node.weight < dist[node.num]) {
					dist[node.num] = dist[cur[0]] + node.weight;
					pq.add(new int[] {node.num, dist[node.num]});
				}
			}
		}
		
		bw.write(dist[ec] + " ");
		bw.close();

	}

}
