
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1043 {

    static int N, M;

    static List<Integer>[] parties;
    static int[] lengths;
    static boolean[] investigated, compromised;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int result = M;

        compromised = new boolean[M];
        investigated = new boolean[N+1];

        Queue<Integer> q =new ArrayDeque<>();

        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        int curr;
        for (int i = 0; i < T; i++) {
            curr = Integer.parseInt(st.nextToken());
            investigated[curr] = true;
            q.offer(curr);
        }

        parties = new List[M];
        lengths = new int[M];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            parties[i] = new ArrayList<>();
            st.nextToken();
            while(st.hasMoreTokens()){
                parties[i].add(Integer.parseInt(st.nextToken()));
                lengths[i]++;
            }
        }

        while (!q.isEmpty()){
            int person = q.poll();
            for (int i = 0; i < M; i++) {
                if(compromised[i]) continue;
                for (int j = 0; j < lengths[i]; j++) {

                    if(parties[i].get(j) == person){
                        compromised[i] = true;
                        result--;
                        for(int k = 0; k < lengths[i]; k++){
                            int guest = parties[i].get(k);
                            if(!investigated[guest]){
                                investigated[guest] = true;
                                q.offer(guest);
                            }
                        }
                    }
                }
            }
        }

        System.out.println(result);
    }
}
