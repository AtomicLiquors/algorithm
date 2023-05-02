package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2468 {
    static int minHeight = 100;
    static int maxHeight = 1;

    static int N;

    static int[] dR = {0, 0, -1, 1};
    static int[] dC = {-1, 1, 0, 0};

    static int [][] map;
    static boolean [][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (maxHeight < map[i][j]) maxHeight = map[i][j];
                if (minHeight > map[i][j]) minHeight = map[i][j];
            }
        }

        int maxArea = 0;
        for (int h = minHeight; h <= maxHeight; h++) {
            visited = new boolean[N][N];
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(!visited[i][j] && map[i][j] >= h){
                        cnt++;
                        dfs(i, j, h);
                    }
                }
            }
            maxArea = Math.max(cnt, maxArea);
        }

        System.out.println(maxArea);
    }

    static void dfs(int r, int c, int h){
        visited[r][c] = true;

        int nr, nc;
        for (int i = 0; i < 4; i++) {
            nr = r + dR[i];
            nc = c + dC[i];
            if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
            if(!visited[nr][nc] && map[nr][nc] >= h){
                dfs(nr, nc, h);
            }
        }
    }
}
