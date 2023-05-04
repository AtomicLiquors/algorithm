import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2644 {
    static int N;
    static int start, end;
    static int[][] map;
    static int result = Integer.MAX_VALUE;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];
        visited = new boolean[N+1][N+1];
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        int E = Integer.parseInt(br.readLine());

        int from, to;
        for (int i = 0; i < E; i++) {
            st =new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            map[from][to] = map[to][from] = 1;
        }

        for (int j = 1; j <= N; j++) {
            if(map[start][j] > 0 )
                dfs(j, 1);
        }

        System.out.println(result == Integer.MAX_VALUE?-1:result);
    }

    static void dfs(int i, int cnt){
        if(i==end){
            result = Math.min(result, cnt);
        }


        for (int j = 1; j <= N; j++) {
            if(map[i][j] > 0 && !visited[i][j]) {
                visited[i][j] = true;
                visited[j][i] = true;
                dfs(j, cnt+1);
            }
        }
    }
}

