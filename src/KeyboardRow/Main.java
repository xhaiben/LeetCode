package KeyboardRow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by xhaiben on 2017/2/8.
 */
public class Main {
    public static void main(String[] args) {
        String[] words = {"Hello", "Alaska", "Dad", "Peace"};
        findWords2(words);
    }

    public static String[] findWords(String[] words) {
        List<String> strs = new ArrayList<>();
        for (String str : words) {
            if (str.toLowerCase().matches("[qwertyuiop]*|[asdfghjkl]*|[zxcvbnm]*")) {
                strs.add(str);
            }
        }
        System.out.println(strs);
        return strs.toArray(new String[strs.size()]);
    }

    public static String[] findWords2(String[] words) {
        System.out.println(Arrays.stream(words).filter(s -> s.toLowerCase().matches("[qwertyuiop]*|[asdfghjkl]*|[zxcvbnm]*")).getClass());

        return Stream.of(words).filter(s -> s.toLowerCase().matches("[qwertyuiop]*|[asdfghjkl]*|[zxcvbnm]*")).toArray(String[]::new);
    }
}
