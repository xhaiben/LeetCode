package FindtheDifference;

/**
 * Created by xhaiben on 2017/2/7.
 */
public class Main {
    public static void main(String[] args) {
        findTheDifference2("abcd", "abcde");
    }

    public static char findTheDifference(String s, String t) {
        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();
        int n1 = 0;
        for (char c : chars1) {
            n1 = (n1 ^ c);
        }
        int n2 = 0;
        for (char c : chars2) {
            n2 = (n2 ^ c);
        }
        System.out.println((char) (n1 ^ n2));
        return (char) (n1 ^ n2);
    }

    static char findTheDifference2(String s, String t) {
        char n = 0;
        for (char c : (s + t).toCharArray()) n ^= c;
        System.out.println(n);
        return n;
    }
}
