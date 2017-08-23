package ImplementStrStr;

/**
 * Created by xhaiben on 2017/7/16.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(strStr("source", "ua"));
    }

    public static int strStr(String haystack, String needle) {
        if (needle == null && haystack == null) {
            return 0;
        }
        if (haystack == null) {
            return -1;
        }
        if (needle == null) {
            return 0;
        }
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            int j = 0;
            for (; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }
            if (j == needle.length()) {
                return i;
            }
        }
        return -1;
    }
}
