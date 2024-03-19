import java.util.*;
import java.io.*;

public class BoardCover {

    static int testCase;
    static int H, W;
    static boolean board[][];
    static int whiteBoardCount;
    static int count;

    //┌, ┐,ㄴ, ┘  (dy,dx)
    static int[][][] coverType = {
            {{0, 0}, {1, 0}, {0, 1}},
            {{0, 0}, {0, 1}, {1, 1}},
            {{0, 0}, {1, 0}, {1, 1}},
            {{0, 0}, {1, 0}, {1, -1}}
    };

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        testCase = Integer.parseInt(br.readLine());
        for (int cycle = 0; cycle < testCase; cycle++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            board = new boolean[H][W];
            count = 0;
            whiteBoardCount = 0;

            for (int i = 0; i < H; i++) {
                String oneLine = br.readLine();
                for (int j = 0; j < W; j++) {
                    board[i][j] = oneLine.charAt(j) == '#';
                    if (!board[i][j]) whiteBoardCount++;
                }
            }
            sol();
        }
    }

    public static void sol() {
        // 기저 조건 1: 흰색 보드가 3의 배수가 아닌 경우
        if (whiteBoardCount % 3 != 0) {
            System.out.println("answer : " + count);
        } else {
            dfs(whiteBoardCount);
            System.out.println("answer : " + count);
        }
    }

    public static void dfs(int whiteBoardCount) {
        try {
            if (whiteBoardCount == 0) {
                count++;
            } else {
                for (int i = 0; i < H; i++) {
                    for (int j = 0; j < W; j++) {
                        if (!board[i][j]) {
                            for (int k = 0; k < 4; k++) {
                                if (checkRange(k, i, j)) {
                                    set(k, i, j, true);
                                    dfs(whiteBoardCount - 3);
                                    set(k, i, j, false);
                                }
                            }
                            return;
                        }
                    }
                }
            }
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    private static void set(int k, int c, int r, boolean v) {
        for (int i = 0; i < 3; i++) {
            int nc = c + coverType[k][i][0];
            int nr = r + coverType[k][i][1];
            board[nc][nr] = v;
        }
    }

    public static boolean checkRange(int k, int c, int r) {
        for (int i = 0; i < 3; i++) {
            int nc = c + coverType[k][i][0];
            int nr = r + coverType[k][i][1];
            if (!isRange(nc, nr) || board[nc][nr]) return false;
        }
        return true;
    }

    public static boolean isRange(int y, int x) {
        return (x >= 0 && x < W) && (y >= 0 && y < H);
    }

    public static void main(String[] args) throws IOException {
        input();
    }
}
