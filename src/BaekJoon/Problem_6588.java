/**1742년, 독일의 아마추어 수학가 크리스티안 골드바흐는 레온하르트 오일러에게 다음과 같은 추측을 제안하는 편지를 보냈다.

 4보다 큰 모든 짝수는 두 홀수 소수의 합으로 나타낼 수 있다.  모든 짝수 == 두 홀수의 합
 예를 들어 8은 3 + 5로 나타낼 수 있고, 3과 5는 모두 홀수인 소수이다.
 또,
 20 = 3 + 17 = 7 + 13,
 42 = 5 + 37 = 11 + 31 = 13 + 29 = 19 + 23 이다.

 이 추측은 아직도 해결되지 않은 문제이다.

 백만 이하의 모든 짝수에 대해서, 이 추측을 검증하는 프로그램을 작성하시오.

 입력
 입력은 하나 또는 그 이상의 테스트 케이스로 이루어져 있다.
 테스트 케이스의 개수는 100,000개를 넘지 않는다.

 각 테스트 케이스는 짝수 정수 n 하나로 이루어져 있다. (6 ≤ n ≤ 1000000)

 입력의 마지막 줄에는 0이 하나 주어진다.

 출력
 각 테스트 케이스에 대해서, n = a + b 형태로 출력한다.
 이때, a와 b는 홀수 소수이다.
 숫자와 연산자는 공백 하나로 구분되어져 있다.
 만약, n을 만들 수 있는 방법이 여러 가지라면, b-a가 가장 큰 것을 출력한다.
 또, 두 홀수 소수의 합으로 n을 나타낼 수 없는 경우에는 "Goldbach's conjecture is wrong."을 출력한다.
 * */
package BaekJoon;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem_6588 {
    public Problem_6588() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < 100000; i++){
            int N = Integer.parseInt(br.readLine());
            if(N == 0){
                break;
            }
            list.add(N);
        }
        for(int N : list){
            checkGoldbach(N);
        }
    }

    private void checkGoldbach(int N) throws IOException {
        //홀수 소수란??
        //3 5 7 11 13 모든 소수가 홀수임 왜?? (1,2,빼고)
        //그럼 해당 숫자 아래의 모든 소수를 찾고
        //그 소수끼리 합을 구해서 맞으면 출력??
        //근데 두가지라면 해당 방법 중 더 큰 쪽을 골라??
        int []arr = findPrimes(N).stream()
                .mapToInt(Integer::intValue)
                .toArray();
        fitWithN(arr, N);
    }
    private List<Integer> findPrimes(int N){
        List<Integer> primes = new ArrayList<>();
        for(int i = 3; i <= N; i++){
            if(checkPrime(i)){
                primes.add(i);
            }
        }
        return primes;
    }
    private void fitWithN(int[] arr, int N) throws  IOException{
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr.length; j++){
                if(i != j && arr[i] + arr[j] == N){
                    bw.write(String.valueOf(N) + " = " + String.valueOf(arr[i])+ " + "+ String.valueOf(arr[j]));
                    bw.newLine();
                    bw.flush();
                    bw.close();
                    return;
                }
            }
        }
        bw.write( "Goldbach's conjecture is wrong.");
        bw.newLine();
        bw.flush();
        bw.close();
    }
    private boolean checkPrime(int N){
        for(int i = 2; i <= Math.sqrt(N); i++){
            if(N % i == 0){
                return false;
            }
        }
        return true;
    }
}
