package Chapter6_Recursion;

import java.util.ArrayList;
import java.util.List;

public class ReplaceFor {
    //static이 힙메모리 이전에 사용 가능...
    protected List<Integer> picked = new ArrayList<Integer>();
    public void printJustFive(int n, int toPick) {
        if(toPick == 0){
            System.out.println(picked);
        }
        int smallest = picked.isEmpty() ? 0 : picked.getLast() + 1;
        for(int next = smallest ; next < n; next++){
            picked.add(next);
            printJustFive(n, toPick-1);
            picked.removeLast();
        }
    }
}
