package algorithm;

import java.util.Scanner;

public class Main_1676 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        if(N < 5) {
            System.out.println(0);
            return;
        }
        int cnt = 0;
        for (int i = 5, j = 1; i <= N; i = 5*j) {
            cnt++;
            int k = j;
            while(true){
                if(k>0 && k%5==0){
                    k/=5;
                    cnt++;
                }
                else break;
            }

            j++;
        }
        System.out.println(cnt);
    }
    //17736kb	208ms

    /*
    *
    	14208kb	128ms 답안 :
	public static int get_zeros(int number) {
		int cnt = 0;

		while(number >= 5) {
			cnt = cnt + number / 5;
			number = number / 5;
		}

		return cnt;
	}*/
}
