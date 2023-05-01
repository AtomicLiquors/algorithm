package graph;

import com.sun.org.apache.xerces.internal.parsers.CachingParserPool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main_2667 {
    static int N;
    static int map[][];
    static int[] dR = {0,0,-1,1};
    static int[] dC = {-1,1,0,0};

    static int apartments = 0;
    static int houses;
    static boolean visited[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N  = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j]==1 && !visited[i][j]){

                    apartments++;
                    houses = 0;
                    dfs(i, j);
                    pq.offer(houses);

                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(apartments).append("\n");
        while(!pq.isEmpty()){
            sb.append(pq.poll()).append("\n");
        }



        System.out.println(sb);
    }

    static void dfs(int r, int c){
        visited[r][c] = true;
        houses++;
        int nr, nc;
        for (int i = 0; i < 4; i++) {
            nr = r + dR[i];
            nc = c + dC[i];

            if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
            if(map[nr][nc]==1 && !visited[nr][nc]){
                dfs(nr, nc);
            }
        }
    }
}
