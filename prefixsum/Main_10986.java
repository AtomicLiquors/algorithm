package prefixsum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_10986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] prefix = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            prefix[i] = prefix[i-1] + Integer.parseInt(st.nextToken());
        }


        int ptR;
        int cnt = 0;
        for (int ptL = 0; ptL < N; ptL++) {
            ptR = ptL + 1;
            int target;
            while(ptR <= N){
                target = prefix[ptR] - prefix[ptL];
                if(target % M == 0){
                    cnt++;
                }
                ptR++;
            }
        }
        System.out.println(cnt);
        //!= 0 && %-
    }
}
