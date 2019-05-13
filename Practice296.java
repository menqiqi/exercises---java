/**
 * 一只袋鼠要从河这边跳到河对岸，河很宽，但是河中间打了很多桩子，每隔一米就有一个，
 * 每个桩子上都有一个弹簧，袋鼠跳到弹簧上就可以跳的更远。每个弹簧力量不同，用一个数字代表它的力量，
 * 如果弹簧力量为5，就代表袋鼠下一跳最多能够跳5米，如果为0，就会陷进去无法继续跳跃。河流一共N米宽，袋鼠初始位置就在第一个弹簧上面，要跳到最后一个弹簧之后就算过河了，给定每个弹簧的力量，
 * 求袋鼠最少需要多少跳能够到达对岸。如果无法到达输出-1
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Practice296 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] stubs = new int[n];
        int pos = 0;
        for (String tmp: br.readLine().trim().split(" "))
            stubs[pos++] = Integer.parseInt(tmp);
        System.out.println(jump(stubs));
    }

    public static int jump(int[] stubs) {
        int l = 0, r = 0;
        int times = 0;
        while (r < stubs.length) {
            int nextL = l;
            int nextR = r;
            for (int i = l; i <= Math.min(r, stubs.length - 1); i++) {
                if (nextR < stubs[i] + i) {
                    nextL = i;
                    nextR = i + stubs[i];
                }
            }
            if (nextR == r) return -1;
            l = nextL;
            r = nextR;
            times++;
        }
        return times;
    }
}

