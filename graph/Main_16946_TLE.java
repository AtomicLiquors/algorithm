package graph;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16946_TLE {
    static int[] dR = {0,0,-1,1};
    static int[] dC = {-1,1,0,0};
    static int[][] map;
    static boolean[][] visited;
    static int tR, tC , N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        map = new int[N][M];

        Queue<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j)-'0';
                if(map[i][j]==1){
                    q.offer(new int[]{i,j});
                }
            }
        }

        while(!q.isEmpty()){
            int[] curr = q.poll();
            tR = curr[0];
            tC = curr[1];
            visited = new boolean[N][M];
            dfs(tR, tC);
        }

        StringBuilder sb;
        for (int i = 0; i < N; i++) {
            sb = new StringBuilder();
            for (int j = 0; j < M; j++) {
                sb.append(map[i][j]);
            }
            bw.write(sb.toString());
            bw.flush();
            bw.newLine();
        }
        br.close();
        bw.close();
    }

    static void dfs(int r, int c){
        visited[r][c] = true;
        int nr, nc;
        for (int i = 0; i < 4; i++) {
            nr = r + dR[i];
            nc = c + dC[i];
            if(nr<0 || nc<0||nr>=N || nc>=M) continue;
            if(!visited[nr][nc] && map[nr][nc] == 0){
                map[tR][tC]++;
                dfs(nr,nc);
            }
        }
    }
}

