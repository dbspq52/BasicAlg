/**
 * 정사각형 4개를 이어 붙인 폴리오미노는 테트로미노라고 하며, 다음과 같은 5가지가 있다.
 * 아름이는 크기가 N×M인 종이 위에 테트로미노 하나를 놓으려고 한다. 종이는 1×1 크기의 칸으로 나누어져 있으며, 각각의 칸에는 정수가 하나 쓰여 있다.
 * 테트로미노 하나를 적절히 놓아서 테트로미노가 놓인 칸에 쓰여 있는 수들의 합을 최대로 하는 프로그램을 작성하시오.
 * 테트로미노는 반드시 한 정사각형이 정확히 하나의 칸을 포함하도록 놓아야 하며, 회전이나 대칭을 시켜도 된다.
 * 입력
 * 첫째 줄에 종이의 세로 크기 N과 가로 크기 M이 주어진다. (4 ≤ N, M ≤ 500)
 * 둘째 줄부터 N개의 줄에 종이에 쓰여 있는 수가 주어진다.
 * i번째 줄의 j번째 수는 위에서부터 i번째 칸, 왼쪽에서부터 j번째 칸에 쓰여 있는 수이다.
 * 입력으로 주어지는 수는 1,000을 넘지 않는 자연수이다.
 * 출력
 * 첫째 줄에 테트로미노가 놓인 칸에 쓰인 수들의 합의 최댓값을 출력한다.*/
package BaekJoon;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

/**일단 음.....Matrix 입력 만들자 배열???-> 배열
 *그냥 이 5개가 모든 표현의 수야. 이 5개로 모든게 다 가능해
 * 그렇다면, 이제 이어지는 것으로 표현해야 해
 * */
public class Problem_14500 {
    int[][] MATRIX;
    int MAX = 0;
    int[] arr;
    int[] movement;
    public Problem_14500() throws IOException {
        initMatrix();
        for(int i = 0; i < arr[0]; i++){
            for(int j = 0; j < arr[1]; j++){
                deepResearchWithRecursion(j, i, new HashMap<>());
            }
        }
        System.out.println(MAX);
    }
    private void deepResearchWithRecursion(int x, int y, Map<Point, Integer> bowl){
        if(bowl.size() == 4){
            int totalSum = bowl.values().stream().mapToInt(Integer::intValue).sum();
            if(MAX <= totalSum && checkSize(bowl)){
                MAX = totalSum;
            }
            return;
        }
        Point point = new Point(x, y);
        if((x >=0 && x < arr[1]) && (y >=0 && y < arr[0]) && !bowl.containsKey(point)){
            bowl.put(point, MATRIX[y][x]);
            deepResearchWithRecursion(x + 1, y, bowl);
            deepResearchWithRecursion(x - 1, y, bowl);
            deepResearchWithRecursion(x, y + 1, bowl);
            deepResearchWithRecursion(x, y - 1, bowl);
            deepResearchWithRecursion(x + 1, y + 1, bowl);
            deepResearchWithRecursion(x - 1, y - 1, bowl);
            deepResearchWithRecursion(x - 1, y + 1, bowl);
            deepResearchWithRecursion(x + 1, y - 1, bowl);

            bowl.remove(point);
        }
    }
    private boolean checkSize(Map<Point, Integer> bowl){
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;

        for(Point point : bowl.keySet()){
            maxX = Math.max(maxX, point.x);
            maxY =Math.max(maxY, point.y);
            minX =Math.min(minX, point.x);
            minY =Math.min(minY, point.y);
       }
        int gapX = Math.abs(maxX - minX);
        int gapY = Math.abs(minY - maxY);
        return (gapX <= 2 && gapY <= 1) || (gapX <= 3 && gapY <= 0) || (gapX <= 0 && gapY <= 3) || (gapX <= 1 && gapY <= 2);
    }

    //Test 검증 완료
    private void initMatrix() throws IOException {
        List<Integer> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        arr = list.stream().mapToInt(Integer::intValue).toArray();

        MATRIX = new int[arr[0]][arr[1]];

        for (int i = 0; i < arr[0]; i++) {
            st = new StringTokenizer(br.readLine());
            int index = 0;
            while(st.hasMoreTokens()){
                MATRIX[i][index] = Integer.parseInt(st.nextToken());
                index++;
            }
        }

    }

}
