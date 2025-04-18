package Chapter6_Recursion;

import java.util.ArrayList;
import java.util.List;

public class BoggleGame {
    static List<Character> words = new ArrayList<>();
    static char[][] kit = {{'U','R', 'L', 'P', 'M'},
            {'X','P','R','E','T'},
            {'G','I','A','E','T'},
            {'X', 'T', 'N','Z','Y'},
            {'X','O','Q','R','S'}};

    public static void playGame(int y, int x, char[] word) {
        // 5*5 범위 안에 있어야 함
        if (x >= 0 && x < 5 && y >= 0 && y < 5) {
            // 단어 추가
            words.add(kit[y][x]);
            // 현재 인덱스의 단어가 원하는 단어와 같은지 확인
            if (words.getLast() == word[words.size() - 1]) {
                System.out.println(words);

                // 단어가 완성되었는지 확인
                if (words.size() == word.length) {
                    System.out.println("find : word!! " + words);
                } else {
                    // 8방향으로 재귀 호출 -> 이걸 이제 for 문을 통해서 스타일리쉬 하게 만들 수 있다.
                    playGame(y + 1, x, word);
                    playGame(y - 1, x, word);
                    playGame(y, x + 1, word);
                    playGame(y, x - 1, word);
                    playGame(y + 1, x + 1, word);
                    playGame(y + 1, x - 1, word);
                    playGame(y - 1, x - 1, word);
                    playGame(y - 1, x + 1, word);
                }
            }
            // 백트래킹: 리스트에서 제거
            words.removeLast();
        }
    }
}
