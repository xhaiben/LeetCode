package NextPermutation;

public class Main2 {
    public static void main(String[] args) {
        int[] nums = {2,2,1,1};
        long index = permutationIndex(nums);
        System.out.println(index);
    }

    public static long permutationIndex(int[] A) {
        if (A == null || A.length == 0) {
            return 0L;
        }
        long index = 1, fact = 1;
        for (int i = A.length - 1; i >= 0; i--) {
            int rank = 0;
            for (int j = i + 1; j < A.length; j++) {
                if (A[j] < A[i]) {
                    rank++;
                }
            }
            index += rank * fact;
            fact *= (A.length - i);
        }
        return index;
    }

}
