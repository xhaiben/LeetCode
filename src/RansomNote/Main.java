package RansomNote;

/**
 * Created by xhaiben on 2017/2/11.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(canConstruct("aa", "aab"));
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] ints = new int[123];
        int[] ints1 = new int[123];
        for (char c : ransomNote.toCharArray()) {
            ints[c] += 1;
        }
        for (char c : magazine.toCharArray()) {
            ints1[c] += 1;
        }
        for (int i = 65; i <= 122; i++) {
            if (ints1[i] < ints[i]) {
                return false;
            }
        }
        return true;
    }
}
