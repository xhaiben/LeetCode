package NextPermutation;

public class Main {
    public static void main(String[] args) {
        int[] nums = {1,5,1};
        nextPermutation(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    public static void nextPermutation(int[] nums) {
        int k = nums.length - 2;
        for (; k >= 0; k--) {
            if (nums[k] < nums[k + 1]) {
                break;
            }
        }
        if (k == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }

        int r = nums.length - 1;
        while (k < r && nums[r] <= nums[k]) {
            r--;
        }

        int temp = nums[k];
        nums[k] = nums[r];
        nums[r] = temp;

        reverse(nums, k + 1, nums.length - 1);
    }

    public static void reverse(int[] nums, int left, int right) {
        for (int i = left, j = right; i < j; i++, j--) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
