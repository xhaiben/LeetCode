package QueueReconstructionByHeight;

import java.util.*;

/**
 * Created by xhaiben on 2017/2/5.
 */
public class Main {
    public static void main(String[] args) {
        int[][] people = new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        reconstructQueue3(people);
    }

    /**
     * 按照 h,k 排好序之后再按照 k 循环交换。 超时
     *
     * @param people
     */
    public static void reconstructQueue(int[][] people) {
        Arrays.sort(people, ((o1, o2) -> {
            //身高大的在前面
            if (o1[0] > o2[0]) {
                return -1;
            }
            //身高一样的 k 小的在前面
            if (o1[0] == o2[0]) {
                if (o1[1] < o2[1]) {
                    return -1;
                }
            }
            if (o1[0] == o2[0] && o1[1] == o2[1]) {
                return 0;
            }
            return 1;
        }));
        for (int i = 1; i < people.length; i++) {
            int count = 0;
            for (int j = 0; j < i; j++) {
                if (people[j][0] >= people[i][0]) {
                    count++;
                }
            }
            while (count > people[i][1]) {
                if (people[i - 1][0] >= people[i][0]) {
                    count--;
                }
                int[] temp = people[i];
                people[i] = people[i - 1];
                people[i - 1] = temp;
                i--;
            }
        }
        for (int[] p : people) {
            System.out.print(p[0]);
            System.out.println(" " + p[1]);
        }
//        return people;

    }

    /**
     * 按照 h,k 排好序之后
     * 此时 相对位置已确定，只需按照 K 值插入到响应位置即可
     *
     * @param people
     */
    public static void reconstructQueue2(int[][] people) {
        Arrays.sort(people, ((o1, o2) -> {
            //身高大的在前面
            if (o1[0] > o2[0]) {
                return -1;
            }
            //身高一样的 k 小的在前面
            if (o1[0] == o2[0]) {
                if (o1[1] < o2[1]) {
                    return -1;
                }
            }
            if (o1[0] == o2[0] && o1[1] == o2[1]) {
                return 0;
            }
            return 1;
        }));
        List<int[]> list = new ArrayList<>();
        for (int[] p : people) {
            //按 k 值插入
            list.add(p[1], p);
        }
        people = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            people[i] = list.get(i);
        }
        for (int[] p : people) {
            System.out.print(p[0]);
            System.out.println(" " + p[1]);
        }
    }

    /**
     * 简化代码结构
     *
     * @param people
     */
    public static void reconstructQueue3(int[][] people) {
        //优美的排序
        Arrays.sort(people, ((o1, o2) ->
                o1[0] != o2[0] ? o2[0] - o1[0] : o1[1] - o2[1]
        ));
        //插入用链表
        List<int[]> list = new LinkedList<>();
        for (int[] p : people) {
            list.add(p[1], p);
        }
        int[][] res = list.toArray(new int[people.length][]);
        for (int[] p : people) {
            System.out.print(p[0]);
            System.out.println(" " + p[1]);
        }
    }
}
