package PermutationIndex;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nums = {1, 2, 4};
        long index = permutationIndex(nums);
        System.out.println(index);
    }
    //超时
    public static long permutationIndex(int[] A) {
        // Write your code here
        int[] P = Arrays.copyOf(A, A.length);
        Arrays.sort(A);
        long index = 1;
        while (true) {
            if (equals(A, P)) {
                return index;
            }
            int k = A.length - 2;
            for (; k >= 0; k--) {
                if (A[k] < A[k + 1]) {
                    break;
                }
            }
            if (k == -1) {
                break;
            }
            int r = A.length - 1;
            for (; r > k; r--) {
                if (A[r] > A[k]) {
                    break;
                }
            }
            int temp = A[r];
            A[r] = A[k];
            A[k] = temp;
            reverse(A, k + 1, A.length - 1);
            index++;
        }
        return index;
    }

    public static boolean equals(int[] A, int[] B) {
        if (A.length != B.length) {
            return false;
        }
        for (int i = 0; i < A.length; i++) {
            if (A[i] != B[i]) {
                return false;
            }
        }
        return true;
    }

    public static void reverse(int[] nums, int left, int right) {
        for (int i = left, j = right; i < j; i++, j--) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
