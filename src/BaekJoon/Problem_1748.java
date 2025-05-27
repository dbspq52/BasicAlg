package BaekJoon;

import java.io.*;

/**
 * 1부터 N까지의 수를 이어서 쓰면 다음과 같이 새로운 하나의 수를 얻을 수 있다.
 *
 * 1234567891011121314151617181920212223...
 * 이렇게 만들어진 새로운 수는 몇 자리 수일까? 이 수의 자릿수를 구하는 프로그램을 작성하시오.
 *
 * 입력
 * 첫째 줄에 N(1 ≤ N ≤ 100,000,000)이 주어진다.
 *
 * 출력
 * 첫째 줄에 새로운 수의 자릿수를 출력한다.
 * */
public class Problem_1748 {
    public Problem_1748() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int size = findScaleOfNum(N);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(String.valueOf(size));
        bw.flush();
        bw.close();
    }

    private int findScaleOfNum(int N){
        String num = String.valueOf(N);
        int length = num.length();
        int size = 0;
        int sizeOfTen;
        for(int i = 1; i < length; i++){
            sizeOfTen = 1;
            for(int j = 0; j < i-1; j++){
                sizeOfTen *= 10;
            }
            int sizeOfGap = 9 * sizeOfTen;
            size += i * sizeOfGap;
        }
        sizeOfTen = 1;
        for(int i = 0; i < length - 1; i++){
            sizeOfTen *= 10;
        }
        int gar = N - sizeOfTen + 1;
        size += gar * length;
        return size;
    }

}
