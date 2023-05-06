package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        int[] D = new int[N+1];

        D[1] = arr[1] = Integer.parseInt(br.readLine());

        if(N>1) {
            arr[2] = Integer.parseInt(br.readLine());
            D[2] = arr[2] + D[1];
        }
        for (int i = 3; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());

            D[i] = Math.max(D[i-2] + arr[i], D[i-3]+arr[i-1]+arr[i]);
        }
        System.out.println(D[N]);
    }
}
