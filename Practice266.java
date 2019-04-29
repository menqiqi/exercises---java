/**
 * 该题的目的是要你统计图的连通分支数。
 *
 * 输入描述:
 * 每个输入文件包含若干行，每行两个整数i,j，表示节点i和j之间存在一条边。
 * 输出描述:
 * 输出每个图的联通分支数。
 */

import java.util.*;

public class Practice266 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean[] visited = new boolean[1000001];
        int[] roots = new int[1000001];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
            roots[i] = -1;
        }
        int max = Integer.MIN_VALUE;
        while (sc.hasNext()) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            visited[x] = true;
            visited[y] = true;
            max = max < (x < y ? y : x) ? (x < y ? y : x) : max;
            union(x, y, roots);
        }
        int res = 0;
        for (int i = 0; i <= max; i++) {
            if (roots[i] == -1 && visited[i]) {
                res++;
            }
        }
        System.out.println(res);
        sc.close();
    }

    public static void union(int x, int y, int[] roots) {
        int rootX = findRoot(x, roots);
        int rootY = findRoot(y, roots);
        if (rootX != rootY) {
            roots[rootY] = rootX;
        }
    }

    public static int findRoot(int x, int[] roots) {
        if (roots[x] == -1) {
            return x;
        }
        roots[x] = findRoot(roots[x], roots);
        return roots[x];
    }
}

