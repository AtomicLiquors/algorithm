package codeforce.div4_871;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int M = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int max = 0;
            int curr = 0;
            for (int j = 0; j < M; j++) {

                if(Integer.parseInt(st.nextToken())==0) curr++;
                else{
                    max = Math.max(max, curr);
                    curr = 0;
                }
            }
            max = Math.max(max, curr);
            System.out.println(max);
        }
    }
}
