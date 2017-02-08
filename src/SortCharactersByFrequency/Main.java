package SortCharactersByFrequency;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by xhaiben on 2017/2/8.
 */
public class Main {
    public static void main(String[] args) {
        frequencySort("Aabb");
    }

    public static String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        StringBuffer stringBuffer = new StringBuffer();
        map.keySet().stream().sorted(((o1, o2) -> map.get(o2) - map.get(o1))).forEach(character -> {
            int count = map.get(character);
            while (count > 0) {
                stringBuffer.append(character);
                count--;
            }
        });
        return stringBuffer.toString();
    }
}
