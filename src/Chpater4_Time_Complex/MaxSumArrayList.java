package Chpater4_Time_Complex;

import java.util.ArrayList;
import java.util.Scanner;

class Input{
    Scanner scanner = new Scanner(System.in);

    public Input(ArrayList<Integer> arrayList, int N){
        for(int i= 0; i < N; i++){
            int num = scanner.nextInt();
            arrayList.add(num);
        }
    }
}

class FindStartPoint {

}
public class MaxSumArrayList {
    protected ArrayList<Integer> arrayList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public MaxSumArrayList(){
        int N = scanner.nextInt();
        Input input = new Input(arrayList, N);
    }



}
