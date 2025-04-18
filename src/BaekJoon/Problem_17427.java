/**두 자연수 A와 B가 있을 때, A = BC를 만족하는 자연수 C를 A의 약수라고 한다.
 * 예를 들어, 2의 약수는 1, 2가 있고, 24의 약수는 1, 2, 3, 4, 6, 8, 12, 24가 있다.
 * 자연수 A의 약수의 합은 A의 모든 약수를 더한 값이고, f(A)로 표현한다.
 * x보다 작거나 같은 모든 자연수 y의 f(y)값을 더한 값은 g(x)로 표현한다.

 자연수 N이 주어졌을 때, g(N)을 구해보자.

 입력
 첫째 줄에 자연수 N(1 ≤ N ≤ 1,000,000)이 주어진다.

 출력
 첫째 줄에 g(N)를 출력한다.
 1. N을 입력 받는다.
 1.1 N이하의 모든 자연수
 2. i의 약수를 구한다. && 합을 구한다.
 3. 해당 값들을 누적 합 시킨다.
 * */
package BaekJoon;

import java.io.*;
import java.util.Scanner;

public class Problem_17427 {
    public Problem_17427() throws IOException {
        int N;
        long res = 0; // 1000000까지 입력할 것을 고려

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        for(int i = 1; i <= N; i++) {
            res += (long) i * (N/i);
        }
        System.out.println(res);
    }

    //여기가 최적화를 해야할 시점이다!!!!
    //약수를 구할때 for 문을 1에서부터 쭉 하는게 문제인거야
    //약수의 개념 = 1 12, 2 6 3 4
    //24라고하면 4까지만 해도됨
    //10000이라고 하면;
    //100 100-> 100 100 5

}
