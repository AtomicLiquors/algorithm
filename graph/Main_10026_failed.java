package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_10026_failed {

    static int N;

    static int[] dR = {0,0,-1,1};
    static int[] dC = {-1,1,0,0};
    static int totalA, totalB = 0;

    static char[][] mapA, mapB;
    static boolean[][] visitedA, visitedB;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N  = Integer.parseInt(br.readLine());
        mapA = new char[N][N];
        mapB = new char[N][N];
        visitedA = new boolean[N][N];
        visitedB = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                mapA[i][j] = str.charAt(j);
                mapB[i][j] = mapA[i][j]=='G'?'R':mapA[i][j];
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!visitedA[i][j]){
                    totalA++;
                    dfsA(i, j, mapA[i][j]);
                }
                if(!visitedB[i][j]){
                    totalB++;
                    dfsB(i, j, mapB[i][j]);
                }
            }
        }

        System.out.println(totalA + " " + totalB);
    }

    static void dfsA(int r, int c, char color){
        visitedA[r][c] = true;
        int nr, nc;
        for (int i = 0; i < 4; i++) {
            nr = r + dR[i];
            nc = c + dC[i];

            if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
            else if(visitedA[nr][nc]) continue;

            if(mapA[nr][nc] == color){
                dfsA(nr, nc, color);
            } else {
                System.out.println("checking");
                System.out.println(nr);
                System.out.println(nc);
                System.out.println(mapA[nr][nc]);
                int anr, anc;
                boolean flag = true;
                for (int j = 0; j < 4; j++) {
                    anr = nr + dR[i];
                    anc = nc + dC[i];
                    if(anr < 0 || anc < 0 || anr >= N || anc >= N){
                        flag = false;
                        break;
                    }
                    System.out.println(mapA[anr][anc]);
                    if(mapA[anr][anc] != color){
                        System.out.println("rejected");
                        flag = false;
                        break;
                    }
                }
                if(flag) dfsA(nr, nc, color);
            }
        }
    }
    static void dfsB(int r, int c, char color){
        visitedB[r][c] = true;
        int nr, nc;
        for (int i = 0; i < 4; i++) {
            nr = r + dR[i];
            nc = c + dC[i];

            if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
            else if(visitedB[nr][nc]) continue;

            if(mapB[nr][nc] == color){
                dfsB(nr, nc, color);
            } else {
                int anr, anc;
                boolean flag = true;
                for (int j = 0; j < 4; j++) {
                    anr = nr + dR[i];
                    anc = nc + dC[i];
                    if(anr < 0 || anc < 0 || anr >= N || anc >= N){
                        flag = false;
                        break;
                    }
                    else if(mapB[anr][anc] != color){
                        flag = false;
                        break;
                    }
                }
                if(flag) dfsB(nr, nc, color);
            }
        }
    }
}
