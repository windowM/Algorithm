import java.util.HashMap;

/**
 * 5x5 격자판에 알파벳을 가지고 하는 게임이다.
 * 1.중복 선택을 허용한다
 * 2.상하/좌우/대각선으로 인접한 단어들로만 연결할 수 있다.
 * 3.
 */
public class BoggleGame {

    static char[][] board = {
            {'u', 'r', 'l', 'p', 'm'},
            {'x', 'p', 'r', 'e', 't'},
            {'g', 'i', 'a', 'e', 't'},
            {'x', 't', 'n', 'z', 'y'},
            {'x', 'o', 'q', 'r', 's'}
    };
    // 12시~ 시계방향
    static int[] dr = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dc = {1, 1, 0, -1, -1, -1, 0, 1};
    static String[] words = {"pretty", "girl", "repeat"};
    static HashMap<String,Boolean> hm = new HashMap<>();

    public static boolean sol(int col, int row, String word) {
        if (!inRage(col, row)) return false;
        if (board[col][row] != word.charAt(0)) return false;
        if(word.length()==1) return true;
        for (int direction = 0; direction < 8; direction++) {
            int nextX = row + dr[direction];
            int nextY = col + dc[direction];
            if (sol(nextY, nextX, word.substring(1))) {
                return true;
            }
        }
        return false;
    }

    private static boolean inRage(int col, int row) {
        return (col>=0&&col<5)&&(row>=0&&row<5);
    }

    public static void output() {
        for(String str : words){
            System.out.println(str+":"+hm.get(str));
        }
    }
    public static void main(String[] args) {
        for (String word : words) {
            for(int i=0;i<5;i++) {
                for(int j=0;j<5;j++) {
                    if (sol(i, j, word)) {
                        hm.put(word,true);
                    }
                }
            }
        }
        output();
    }
}
