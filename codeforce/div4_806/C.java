package codeforce.div4_806;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class C {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int[] password;
        for (int i = 0; i < T; i++) {
            int digits = Integer.parseInt(br.readLine());
            password = new int[digits];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < digits; j++) {
                password[j] = Integer.parseInt(st.nextToken());
                StringTokenizer cmdLine = new StringTokenizer(br.readLine());
                int num = Integer.parseInt(cmdLine.nextToken());
                String cmd = cmdLine.nextToken();

                for (int k = 0; k < num; k++) {
                    if(cmd.charAt(k) == 'D'){
                        password[j] = (password[j] + 1) % 10;
                    }else if(cmd.charAt(k) == 'U'){
                        password[j]--;
                        if (password[j] < 0) password[j] = 9;
                    }
                }
                System.out.print(password[j] + " ");
            }
            System.out.println();
        }
    }
}
