package LinkedListRandomNode;

import java.util.Random;

/**
 * Created by xhaiben on 2017/2/11.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    private ListNode head;

    public Solution(ListNode head) {
        this.head = head;
    }

    public int getRandom() {
        int num = 1;
        Random random = new Random();
        ListNode node = head;
        int ret = node.val;
        while (node.next != null) {
            node = node.next;
            if (random.nextInt(num + 1) + 1 > num) {
                ret = node.val;
            }
            num++;
        }
        return ret;
    }

    public int getRandom2() {
        ListNode ret = null;
        ListNode node = this.head;
        Random random = new Random();
        for (int n = 1; node != null; n++) {
            //每次以1/n的概率保留
            if (random.nextInt(n) == 0) {
                ret = node;
            }
            node = node.next;
        }
        return ret.val;
    }
}

/**
 * 蓄水池等概率抽样算法。
 */
public class Main {
    public static void main(String[] args) {

    }
}
