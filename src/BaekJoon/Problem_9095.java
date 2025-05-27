package BaekJoon;

import java.io.*;

/**
 * 정수 4를 1, 2, 3의 합으로 나타내는 방법은 총 7가지가 있다. 합을 나타낼 때는 수를 1개 이상 사용해야 한다.
 1+1+1+1
 1+1+2
 1+2+1
 2+1+1
 2+2
 1+3
 3+1
 정수 n이 주어졌을 때, n을 1, 2, 3의 합으로 나타내는 방법의 수를 구하는 프로그램을 작성하시오.

 입력
 첫째 줄에 테스트 케이스의 개수 T가 주어진다. 각 테스트 케이스는 한 줄로 이루어져 있고, 정수 n이 주어진다. n은 양수이며 11보다 작다.

 출력
 각 테스트 케이스마다, n을 1, 2, 3의 합으로 나타내는 방법의 수를 출력한다.
 * */
public class Problem_9095 {
    private int sum = 0;

    public Problem_9095() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String testCase = br.readLine();
        int testCaseToInt = Integer.parseInt(testCase);
        for(int i = 0; i < testCaseToInt; i++){
            int n = Integer.parseInt(br.readLine());
            findNumOfOneTwoThree(n, 0);
            bw.write(String.valueOf(sum));
            bw.newLine();
            sum = 0;
        }
        bw.flush();
        bw.close();
    }

    private void findNumOfOneTwoThree(int n, int makeN){
        if(makeN >= n){
            if(makeN == n) {
                sum += 1;
                return;
            }else{
                return;
            }
        }
        for(int i = 1; i <= 3; i++){
            findNumOfOneTwoThree(n, makeN + i);
        }

    }
}
