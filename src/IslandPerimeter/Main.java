package IslandPerimeter;

import java.util.Arrays;

/**
 * Created by xhaiben on 2017/2/4.
 */
public class Main {
    public static void main(String[] args) {
        int[] ns = {1, 2, 3};
        int[] ns2 = Arrays.copyOf(ns, 4);
        islandPerimeter2(new int[][]{{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}});
    }

    public static int islandPerimeter(int[][] grid) {
        int m = grid.length;
        if (m == 0) {
            return 0;
        }
        int n = grid[0].length;
        int[][] m_grid = new int[m + 2][n + 2];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                m_grid[i][j] = grid[i - 1][j - 1];
            }
        }
        int count = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (m_grid[i][j] == 1) {
                    if (m_grid[i - 1][j] == 0) {
                        count += 1;
                    }
                    if (m_grid[i + 1][j] == 0) {
                        count += 1;
                    }
                    if (m_grid[i][j - 1] == 0) {
                        count += 1;
                    }
                    if (m_grid[i][j + 1] == 0) {
                        count += 1;
                    }
                }
            }
        }
        return count;
    }

    public static int islandPerimeter2(int[][] grid) {
        int m = grid.length;
        if (m == 0) {
            return 0;
        }
        int n = grid[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) continue;
                if (i == 0 || grid[i - 1][j] == 0) count++;
                if (i == m - 1 || grid[i + 1][j] == 0) count++;
                if (j == 0 || grid[i][j - 1] == 0) count++;
                if (j == n - 1 || grid[i][j + 1] == 0) count++;
            }
        }
        System.out.println(count);
        return count;
    }
}
