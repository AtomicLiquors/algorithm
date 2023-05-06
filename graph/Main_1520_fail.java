package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1520_fail {
//일반 그래프가 아닌 DP문제
    static int N, M;
    static int endR, endC;
    static int H = 0;
    static int[][] map;
    static int[][] success;

    static int[] dR = {0, 0, -1, 1};
    static int[] dC = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
         M = Integer.parseInt(st.nextToken());
         N = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        success = new int[M][N];
        endR = M-1; endC = N-1;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        H = 0;
       dfs(0, 0);
        /*Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0});

        int nr, nc, curr[];
        while(!q.isEmpty()){
            curr = q.poll();
            if(curr[0] ==endR && curr[1] == endC){
                H++;
                continue;
            }

            for (int i = 0; i < 4; i++) {
                nr = curr[0] + dR[i];
                nc = curr[1] + dC[i];
                if(nr < 0 || nc < 0 || nr >= M || nc >= N) continue;
                if(map[nr][nc] < map[curr[0]][curr[1]])
                    q.offer(new int[]{nr, nc});
            }
        }*/

        System.out.println(success[endR][endC]);
    }


    static void dfs(int r, int c){
        success[r][c]++;
        if(r == endR && c == endC) {
            return;
        }

        int nr, nc;
        for (int i = 0; i < 4; i++) {
            nr = r + dR[i];
            nc = c + dC[i];
            if(nr < 0 || nc < 0 || nr >= M || nc >= N) continue;
            if(map[nr][nc] < map[r][c])
                dfs(nr,nc);
        }
    }
}
