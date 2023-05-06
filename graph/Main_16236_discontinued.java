package algorithm;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_16236_discontinued {
	
	static int[][] map;
	static List<Integer>[] targets;
	
	static int[] dR = {0,0,-1,1};
	static int[] dC = {-1,1,0,0};

	public static void main(String[] args) throws IOException {
		//제한시간 2초.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int elapsed = 0;
		
		targets = new List[N];
		for (int i = 0; i < N; i++) {
			targets[i] = new ArrayList<>();
		}
		
		int targetCnt = 0;
		
		int sr, sc;
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if(map[i][j] == 9) {
					sr = i; sc = j;
					map[i][j] = 0;
				}else if(map[i][j] > 0) {
					targets[i].add(j);
					targetCnt++;
				}
			}
		}
		
		int currentTarget; //find 값을 대입
		
		//1. 공간에 표적이 더 이상 없다.
		if(targetCnt == 0);
		
		//2. 더 이상 움직일 수가 없다.
		
		//2. 동일 거리 -- 최상단 -- 좌극단
		//도착할 때마다 표적 수만큼 배열 돌리기? -> 20*20 = 400
		//"현재 위치에서 거리를 늘려가며 맨 위쪽 행부터 좌 -> 우로 탐색"
		//일일이 탐색하긴 좀 그러니까 
		//좌표가 있는 놈만 배열에 저장 
		 
		//표적 정하기
		
		//크기 2
		
	}
	
	static void find(int r, int c) {
		
	}
	
	static void move() {
		
	}

}
