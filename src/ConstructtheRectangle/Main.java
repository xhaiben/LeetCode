package ConstructtheRectangle;

/**
 * Created by xhaiben on 2017/2/7.
 */
public class Main {
    public static void main(String[] args) {
        constructRectangle(5);
    }

    public static int[] constructRectangle(int area) {
        int a = (int) Math.sqrt(area);
        int[] res = new int[2];
        for (int i = a; i > 0; i--) {
            if (area % i == 0) {
                res[0] = area / i;
                res[1] = i;
                break;
            }
        }
        System.out.print(res[0] + " ");
        System.out.println(res[1]);
        return res;
    }
}
