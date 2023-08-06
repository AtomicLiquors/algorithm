package codeforce.div3_888;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken()); //steps
            int k = Integer.parseInt(st.nextToken()); //difference
            int H = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int[] h = new int[n];
            int count = 0;
            int diff;
            for (int j = 0; j < n; j++) {
                h[j] = Integer.parseInt(st.nextToken());
                diff = Math.abs(H - h[j]);
                if(diff != 0 && diff % k == 0 && diff / k < m)
                    count++;
            }
            System.out.println(count);
        }

    }
}
