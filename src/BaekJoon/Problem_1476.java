/**문제
 준규가 사는 나라는 우리가 사용하는 연도와 다른 방식을 이용한다.
 준규가 사는 나라에서는 수 3개를 이용해서 연도를 나타낸다.
 각각의 수는 지구, 태양, 그리고 달을 나타낸다. 수를 M 이라고 했을 때,

 지구를 나타내는 수를 E, 태양을 나타내는 수를 S, 달을 나타내는 M
 ESM
 이 세 수는 서로 다른 범위를 가진다. (1 ≤ E ≤ 15, 1 ≤ S ≤ 28, 1 ≤ M ≤ 19)

 우리가 알고있는 1년은 준규가 살고있는 나라에서는 1 1 1로 나타낼 수 있다.
 1년이 지날 때마다, 세 수는 모두 1씩 증가한다. 만약, 어떤 수가 범위를 넘어가는 경우에는 1이 된다.

 예를 들어, 15년은 15 15 15로 나타낼 수 있다.
 하지만, 1년이 지나서 16년이 되면 16 16 16이 아니라 1 16 16이 된다. 이유는 1 ≤ E ≤ 15 라서 범위를 넘어가기 때문이다.

 E, S, M이 주어졌고, 1년이 준규가 사는 나라에서 1 1 1일때,
 준규가 사는 나라에서 E S M이 우리가 알고 있는 연도로 몇 년인지 구하는 프로그램을 작성하시오.

 입력
 첫째 줄에 세 수 E, S, M이 주어진다. 문제에 나와있는 범위를 지키는 입력만 주어진다.

            E S M
 (1 ≤ E ≤ 15, 1 ≤ S ≤ 28, 1 ≤ M ≤ 19)
 E = (i)mod15
 S = (i)mod28
 M = (i)mod19



 *
 */
package BaekJoon;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem_1476 {
    public Problem_1476() throws IOException {
        int E = 1;
        int S = 1;
        int M = 1;
        int year = 1;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<Integer> lists = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            lists.add(Integer.parseInt(st.nextToken()));
        }

        int[] arrays = lists.stream().mapToInt(Integer::intValue).toArray();

        while(true){
            if(arrays[0] == E && arrays[1] == S && arrays[2] == M){
                bw.write(String.valueOf(year));
                bw.flush();
                bw.close();
                return;
            }
            year += 1;
            if(year % 15 == 0){
                E =  15;
            }else{
                E = year % 15;
            }
            if(year % 28 == 0){
                S = 28;
            }else{
                S = year % 28;
            }
            if(year % 19 == 0){
                M = 19;
            }else{
                M = year % 19;
            }

        }
    }

}
