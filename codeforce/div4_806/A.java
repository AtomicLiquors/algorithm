package codeforce.div4_806;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String str = br.readLine().toUpperCase();
            if(str.equals("YES")) System.out.println("YES");
                    else System.out.println("NO");
        }
    }
}
