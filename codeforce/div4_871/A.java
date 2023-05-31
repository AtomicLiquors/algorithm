package codeforce.div4_871;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[] codeforces = {'c','o', 'd','e','f','o','r','c','e','s'};
        for (int i = 0; i < N; i++) {
            int cnt = 0;
            String str = br.readLine();

            for (int j = 0; j < 10; j++) {
                if(str.charAt(j) != codeforces[j]) cnt++;
            }
            System.out.println(cnt);
        }

    }
}