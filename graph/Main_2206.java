package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Node{
    int r;
    int c;
    int cnt;
    int chance;

    public Node(int r, int c, int cnt, int chance){
        this.r = r;
        this.c = c;
        this.cnt = cnt;
        this.chance = chance;
    }
}

public class Main_2206 {

    public static void main(String[] args) throws IOException {

        int[] dR = {0, 0, -1, 1};
        int[] dC = {-1, 1, 0, 0};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int map[][] = new int[N][M];
        boolean visited[][][] = new boolean[N][M][2];
        int endR = N-1;
        int endC = M-1;

        int result = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j)-'0';
            }
        }

        Queue<Node> q = new ArrayDeque<>();

        q.offer(new Node(0,0, 1, 1));
        visited[0][0][1] = true;

        int nr, nc;
        while(!q.isEmpty()){
            Node curr = q.poll();
            if (curr.r == endR && curr.c == endC){
                result = curr.cnt;
                break;
            }

            for (int i = 0; i < 4; i++) {
                nr = curr.r + dR[i];
                nc = curr.c + dC[i];
                if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;

                if(!visited[nr][nc][curr.chance]){
                    if(map[nr][nc] == 0){
                        visited[nr][nc][curr.chance] = true;
                        q.offer(new Node(nr, nc, curr.cnt+1,curr.chance));
                    }else if(curr.chance > 0){
                        visited[nr][nc][1] = true;
                        q.offer(new Node(nr, nc, curr.cnt+1,0));
                    }
                }
            }

        }
        System.out.println(result==Integer.MAX_VALUE?-1:result);
    }
}
