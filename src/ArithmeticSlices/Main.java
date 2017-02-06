package ArithmeticSlices;

/**
 * Created by xhaiben on 2017/2/5.
 */
public class Main {
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4};
        System.out.println(numberOfArithmeticSlices2(A));
    }

    /**
     * 直觉代码 不精炼
     * @param A
     * @return
     */
    public static int numberOfArithmeticSlices(int[] A) {
        int n = A.length - 3 + 1;
        if (n < 1) {
            return 0;
        }
        int[] judge = new int[n];
        for (int i = 0; i < n; i++) {
            if (judgeArithmetic(A, i)) {
                judge[i] = 1;
            } else {
                judge[i] = 0;
            }
        }
        int count = 0;
        for (int i = 0; i < judge.length; i++) {
            if (judge[i] == 1) {
                int j = i;
                while (j < judge.length && judge[j] == 1) {
                    count++;
                    j++;
                }
            }
        }
        return count;
    }

    public static boolean judgeArithmetic(int[] A, int i) {
        if (A[i + 2] - A[i + 1] == A[i + 1] - A[i]) return true;
        else return false;
    }

    /**
     * 精炼后的DP
     * @param A
     * @return
     */
    public static int numberOfArithmeticSlices2(int[] A) {
        if (A.length < 3) {
            return 0;
        }
        int[] judge = new int[A.length - 3 + 1];
        int count = 0;
        for (int i = 0; i < judge.length; i++) {
            if (A[i + 2] - A[i + 1] == A[i + 1] - A[i]) {
                judge[i] = i > 0 ? judge[i - 1] + 1 : 1;
            }
            count += judge[i];
        }
        return count;
    }
}
