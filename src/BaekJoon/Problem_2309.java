package BaekJoon;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Problem_2309 {
    public Problem_2309() throws IOException {
        checkHeight(input(), new ArrayList<Integer>(), 0, 0);
    }

    private List<Integer> input() throws IOException {
        List<Integer> heights = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0 ; i < 9; i++){
            heights.add(Integer.parseInt(bufferedReader.readLine()));
        }
        return heights;
    }

    private void checkHeight(List<Integer> heights, List<Integer> sumList, int sum, int startIndex) throws IOException {
        if(sumList.size() == 7){
            if(sum == 100) {
                //출력 관련
                System.out.println("\n리스트 출력:");

                Collections.sort(sumList);

                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

                Iterator<Integer> iterator = sumList.iterator();

                while (iterator.hasNext()) {
                    bufferedWriter.write(String.valueOf(iterator.next()));
                    bufferedWriter.newLine();
                }

                bufferedWriter.flush();
                bufferedWriter.close();
                //출력 고나련 끝
            }
            return;
        }
        //재귀에서는 for 문을 사용해야 해. 왜 ???? 각 계층마다 for문을 돌아야 하기 때문이지
        for(int i = startIndex ; i < heights.size(); i++){
            int value = heights.get(i);

            sumList.add(value);
            checkHeight(heights, sumList, sum + value, i + 1);
            //그러니까  sum이라는 것을 미리 더하지 않고 더하면서 보내게 되면, 나중에 돌아올 때는 sum을 돌리지 않아도 됨
            sumList.removeLast();
        }

    }

}
