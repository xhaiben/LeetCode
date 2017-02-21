package DetectCapital;

/**
 * Created by xhaiben on 2017/2/21.
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.detectCapitalUse("FlaggG"));
    }

    public boolean detectCapitalUse(String word) {
        char[] chars = word.toCharArray();
        if (chars.length == 1) {
            return true;
        }
        //小写0 大写1
        int flag = 0;
        if (Character.isUpperCase(chars[0])) {
            flag = 1;
        }
        if (flag == 1) {
            if (Character.isUpperCase(chars[1])) {
                for (int i = 2; i < chars.length; i++) {
                    if (!Character.isUpperCase(chars[i])) {
                        return false;
                    }
                }
            } else {
                for (int i = 2; i < chars.length; i++) {
                    if (Character.isUpperCase(chars[i])) {
                        return false;
                    }
                }
            }
        } else {
            for (int i = 1; i < chars.length; i++) {
                if (Character.isUpperCase(chars[i])) {
                    return false;
                }
            }
        }
        return true;
    }
}
