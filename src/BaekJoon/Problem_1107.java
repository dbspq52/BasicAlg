/**문제
 수빈이는 TV를 보고 있다. 수빈이는 채널을 돌리려고 했지만, 버튼을 너무 세게 누르는 바람에, 일부 숫자 버튼이 고장났다.

 리모컨에는 버튼이 0부터 9까지 숫자, +와 -가 있다. +를 누르면 현재 보고있는 채널에서 +1된 채널로 이동하고,
 -를 누르면 -1된 채널로 이동한다.
 채널 0에서 -를 누른 경우에는 채널이 변하지 않고, 채널은 무한대 만큼 있다.

 수빈이가 지금 이동하려고 하는 채널은 N이다.
 어떤 버튼이 고장났는지 주어졌을 때,
 채널 N으로 이동하기 위해서 버튼을 최소 몇 번 눌러야하는지 구하는 프로그램을 작성하시오.

 수빈이가 지금 보고 있는 채널은 100번이다.

 입력
 첫째 줄에 수빈이가 이동하려고 하는 채널 N (0 ≤ N ≤ 500,000)이 주어진다.
 둘째 줄에는 고장난 버튼의 개수 M (0 ≤ M ≤ 10)이 주어진다.
 고장난 버튼이 있는 경우에는 셋째 줄에는 고장난 버튼이 주어지며, 같은 버튼이 여러 번 주어지는 경우는 없다.

 출력
 첫째 줄에 채널 N으로 이동하기 위해 버튼을 최소 몇 번 눌러야 하는지를 출력한다
 * */
package BaekJoon;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem_1107 {
    int TargetChannel;
    int min = Integer.MAX_VALUE;
    public Problem_1107() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Integer> errorButtons = new ArrayList<>();
        int[] Buttons = {0,1,2,3,4,5,6,7,8,9};
        int currentChannel = 100;
        
        //input
        TargetChannel = Integer.parseInt(br.readLine());
        int numOfErrorButton = Integer.parseInt(br.readLine());
        if(numOfErrorButton != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()){
                errorButtons.add(Integer.parseInt(st.nextToken()));
            }
            for(int i = 0; i < numOfErrorButton; i++){
                Buttons[errorButtons.get(i)] = -1;
            }
        }
        //end of input

        if(currentChannel == TargetChannel){
            bw.write(String.valueOf(0));
        }
        else{
            for(int len = 1; len <= 6; len++){
                recursionForOptimize(Buttons, new ArrayList<>(), len);
            }
            int ITsRESULT = Math.min(Math.abs(TargetChannel - 100), min);
            bw.write(String.valueOf(ITsRESULT));
        }
        bw.flush();
        bw.close();

    }

    private void recursionForOptimize(int[] Buttons, List<Integer> bowl, int length){
        if(bowl.size() == length){
            int channelValue = changeListToInt(bowl);
            int gap = Math.abs(channelValue - TargetChannel) + bowl.size();
            if(min >= gap){
                min = gap;
            }
            return;
        }
        for (int button : Buttons) {
            if (button != -1) {
                bowl.add(button);
                recursionForOptimize(Buttons, bowl, length);
                bowl.remove(bowl.size() - 1);
            }
        }
    }

    private int changeListToInt(List<Integer> list){
        int len = list.size();
        int result = 0;
        for(int i = 0; i < len; i++){
            int digit = 1;
            for(int j = i; j < len - 1; j++){
                digit *= 10;
            }
            result += digit*list.get(i);
        }
        return result;
    }
}
