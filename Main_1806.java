import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] prefix = new int[N+1];
        int[][] map = new int[N+1][N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
           map[1][i] = prefix[i] = prefix[i-1] + Integer.parseInt(st.nextToken());
        }

        for (int i = 2; i <= N; i++) {
            for (int j = i; j <= N; j++) {
                map[i][j] = prefix[j] - prefix[j-i+1];
            }
        }

        System.out.println(Arrays.deepToString(map));

        for (int i = N; i > 0 ; i--) {
            for (int j = N; j >= i; j--) {
                if(map[i][j] > S) System.out.println(N-i+1);
                System.out.println(i);
                System.out.println(j);
                return;
            }
        }
        System.out.println(0);

    }
}

