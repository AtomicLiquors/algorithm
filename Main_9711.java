import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_9711 {

    static long[] D;
    static long Q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int P;
        D = new long[10001];

        for (int tc = 1; tc <= T; tc++) {

           st = new StringTokenizer(br.readLine());
           P = Integer.parseInt(st.nextToken());
            Q = Long.parseLong(st.nextToken());

            if(P<=2){
                System.out.println("Case #" + tc + ": " + 1%Q);
                continue;
            }
            D[1] = 1;
            D[2] = 1;
            for (int i = 3; i <= P; i++) {
                D[i] = 0;
            }

           System.out.println("Case #" + tc + ": " + fibo(P));
        }

    }

    static long fibo(int idx){
        if(D[idx] > 0) return D[idx];
        else return D[idx] = ( fibo(idx-1) + fibo(idx-2) )%Q;
    }
}

