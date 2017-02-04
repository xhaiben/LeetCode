package BattleshipInABoard;

/**
 * Created by xhaiben on 2017/2/4.
 */
public class BattleshipsInABoard {
    public static void main(String[] args) {
        char[][] board = {
                {'X', '.', '.', 'X'},
                {'.', '.', '.', 'X'},
                {'.', '.', '.', 'X'}
        };
        System.out.println(countBattleships2(board));
    }

    /**
     * 数船头
     * 判断是船头的条件
     * 船头定义为
     * 若其为船头，则其左边为 . 上边为 .
     *
     * @param board
     * @return
     */
    public static int countBattleships(char[][] board) {
        int m = board.length;
        if (m == 0) {
            return 0;
        }
        int count = 0;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'X') {
                    if (i == 0 && j == 0) {
                        count++;
                    } else if (i == 0 && j > 0) {
                        if (board[i][j - 1] == '.') {
                            count++;
                        }
                    } else if (i > 0 && j == 0) {
                        if (board[i - 1][j] == '.') {
                            count++;
                        }
                    } else {
                        if (board[i - 1][j] == '.' && board[i][j - 1] == '.') {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }

    /**
     * 同样数船头
     * 判断不是船头的条件
     * @param board
     * @return
     */
    public static int countBattleships2(char[][] board) {
        int m = board.length;
        if (m == 0) {
            return 0;
        }
        int n = board[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.') continue;
                if (i > 0 && board[i - 1][j] == 'X') continue;
                if (j > 0 && board[i][j - 1] == 'X') continue;
                count++;
            }
        }
        return count;
    }
}
