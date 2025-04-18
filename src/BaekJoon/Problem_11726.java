package BaekJoon;

import java.io.*;

/*문제
2×n 크기의 직사각형을 1×2, 2×1 타일로 채우는 방법의 수를 구하는 프로그램을 작성하시오.
-----
-----
한 행에 대해서 2개를 점령 or 한 열에 대해서 2개 점령 배열..?
arr[1][nm]
arr[nm][1]
입력
첫째 줄에 n이 주어진다. (1 ≤ n ≤ 1,000)

출력
첫째 줄에 2×n 크기의 직사각형을 채우는 방법의 수를 10,007로 나눈 나머지를 출력한다.
재귀 함수????
어떻게 해야할 까.......
문제가 무엇을 원하는지 생각을 해보자
그러니까 칸 두개가 어떻게 직사각형을 채우냐 이거잖아
컴퓨터는 어쨋든, 순서대로 해야 해.
컴퓨터는 어쨌든 순서대로 해야 해
왼쫙에서 부터 오른쪽으로 
두칸 짜리라는 것은 위 아래가 정해져있다.
위아래가 정해져있다
재귀를 사용하자!
n = 1일 떄
=> 1
n = 2일 때
=> 2개
n = 3일 때
=> 3개
n = 4일 때 
=> 5개
 => f(n) = f(n - 1) + f(n - 2)
* */
public class Problem_11726 {
    private int n;
    public Problem_11726() throws IOException {
        int []arr;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        this.n = Integer.parseInt(bufferedReader.readLine());
        arr = new int[n + 1];
        arr[0] = 0;
        arr[1] = 1;
        for(int i = 2; i <= n; i++){
            arr[i] = (arr[i - 1] + arr[i - 2]) % 10007;
        }
        bufferedWriter.write(String.valueOf(arr[n]));
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
