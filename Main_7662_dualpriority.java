import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_7662_dualpriority {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int end = -1;
            int K = Integer.parseInt(br.readLine());
            int[] dpq = new int[K];
            // 0이 값에 포함되기 때문에 배열 + Array.sort가 아니라 리스트를 써야 한다. 정렬은?
            StringTokenizer st;
            for (int k = 0; k < K; k++) {
                st = new StringTokenizer(br.readLine());
                switch (st.nextToken()){
                    case "I":

                        break;
                    case "D":
                        break;
                }
            }
        }

    }
}
