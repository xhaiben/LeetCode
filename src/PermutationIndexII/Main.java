package PermutationIndexII;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

    }

    public static long permutationIndexII(int[] A) {
        if (A == null || A.length == 0) {
            return 0L;
        }
        Map<Integer, Integer> map = new HashMap<>();
        long index = 1, fact = 1, multiFact = 1;
        for (int i = A.length - 1; i >= 0; i--) {
            if (map.containsKey(A[i])) {
                map.put(A[i], map.get(A[i]) + 1);
                multiFact *= map.get(A[i]);
            } else {
                map.put(A[i], 1);
            }
            int rank = 0;
            for (int j = i + 1; j < A.length; j++) {
                if (A[i] > A[j]) rank++;
            }
            index += rank * fact / multiFact;
            fact *= (A.length - i);
        }
        return index;
    }
}
