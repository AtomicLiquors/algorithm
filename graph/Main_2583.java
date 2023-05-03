

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_2583 {

    static int N;
    static int M;
    static int[][] map;
    static boolean[][] visited;
    static int measure;
    
    static int[] dR = {0,0,-1,1};
    static int[] dC = {-1,1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        map = new int[N][M];
        visited = new boolean[N][M];
        
        int sn, sm, en, em;
        for (int i = 0; i < K; i++) {
        	st = new StringTokenizer(br.readLine());
        	sn = Integer.parseInt(st.nextToken());
        	sm = Integer.parseInt(st.nextToken());
        	en = Integer.parseInt(st.nextToken());
        	em = Integer.parseInt(st.nextToken());    
        	fill(sn,sm,en,em);
		}
        int cnt = 0;
        
        PriorityQueue <Integer> q = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j]==0 && !visited[i][j]) {
                	cnt++;
                	measure = 0;
                	dfs(i, j);
                	q.offer(measure);
                }
            }
        }
        
        System.out.println(cnt);
        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()) {        	
        	sb.append(q.poll()).append(" ");
        }
        System.out.print(sb);
	     
    }
    
    static void fill(int sn, int sm, int en, int em) {
    	for (int i = sn; i < en; i++) {
			for (int j = sm; j < em; j++) {
				map[i][j] = 1;
			}
		}
    }

    static void dfs(int r, int c){
    	visited[r][c] = true;
    	measure++;
    	
    	int nr, nc;
    	for (int i = 0; i < 4; i++) {
			nr = r + dR[i];
			nc = c + dC[i];
			if(nr >= 0 && nc >= 0 && nr < N && nc < M && map[nr][nc]==0 && !visited[nr][nc]) {
				dfs(nr, nc);
			}
				
		}
    }
}