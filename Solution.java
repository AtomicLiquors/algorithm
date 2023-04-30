import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    //프로세서 문제
    //https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV4suNtaXFEDFAUf

    static int N;
    static int result, listSize;
    static boolean visited[][];
    static int[] dR = {0, 0, -1, 1};
    static int[] dC = {-1, 1, 0, 0};
    static List<int[]> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            visited = new boolean[N][N];
            result = Integer.MAX_VALUE;

            list = new ArrayList<>();
            StringTokenizer st;
            listSize = 0;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    if(Integer.parseInt(st.nextToken())==1){
                        visited[i][j]=true;
                        list.add(new int[]{i, j});
                        listSize++;
                    }
                }
            }

            dfs(0, 0, visited);

            System.out.printf("#%d %d\n", tc, result);
        }


    }

    static void dfs(int total, int idx, boolean[][] status){
        if(total > result) return;
        int r = list.get(idx)[0];
        int c = list.get(idx)[1];

        int nextR, nextC;
        int measure;
        for (int i = 0; i < 4; i++) {
            boolean[][] current = copy(status);
            nextR = r + dR[i];
            nextC = c + dC[i];
            measure = 0;

            //탐색
            boolean cancel = false;
            while(nextR >= 0 && nextC >= 0 && nextR < N && nextC < N){
                if(status[nextR][nextC]){
                    cancel = true;
                    break;
                }

                current[nextR][nextC] = true;
                nextR += dR[i];
                nextC += dC[i];
                measure++;
            }
            if(cancel) continue;
            if(idx+1 < listSize){
                dfs(total + measure, idx+1, current);
            }else{
                result = Math.min(result, total);
            }
        }
    }

    static boolean[][] copy(boolean[][] status){
        boolean[][] current = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                current[i][j] = status[i][j];
            }
        }
        return current;
    }
}
