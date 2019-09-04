/**
 * 整个公司的人员结构可以看作是一棵标准的多叉树。树的头节点是公司唯一的老板，除老板外，每个员工都有唯一的直接上级，叶节点是没有任何下属的基层员工，除基层员工外，每个员工都有一个或多个直接下级，另外每个员工都有一个快乐值。
 * 这个公司现在要办 party，你可以决定哪些员工来，哪些员工不来。但是要遵循如下的原则：
 * 1.如果某个员工来了，那么这个员工的所有直接下级都不能来。
 * 2.派对的整体快乐值是所有到场员工快乐值的累加。
 * 3.你的目标是让派对的整体快乐值尽量大。
 * 给定一棵多叉树，请输出派对的最大快乐值。
 */

import java.util.*;

public class Practice370 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int root = scanner.nextInt();
        int [] happy = new int[N];
        int [] parents = new int[N];
        for(int i = 0;i<N;i++) {
            happy[i] = scanner.nextInt();
        }
        Arrays.fill(parents, -1);
        ArrayList<Integer> [] childs = new ArrayList[N];
        for(int i = 0;i<N;i++) {
            childs[i] = new ArrayList<>();
        }
        for(int i = 0;i<N-1;i++) {
            int parent = scanner.nextInt();
            int child = scanner.nextInt();
            parents[child-1] = parent-1;
            childs[parent-1].add(child-1);
        }
        scanner.close();



        System.out.println(new Practice370().getMaxHappy(happy, parents,root-1, childs));
    }
    int getMaxHappy(int [] happy, int [] relations, int root,ArrayList<Integer>[] childs) {
        int [] dp2 = new int[happy.length];
        int [] dp1 = new int[happy.length];
        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);
        getMaxHappy(happy, relations, root,dp1,dp2,childs);
        return maxHappy;
    }
    int maxHappy = 0;

    int[] getMaxHappy(int[] happy, int[] relations, int index, int[] dp1, int[] dp2, ArrayList<Integer>[] childs) {
        if (dp2[index] != -1 && dp1[index] != -1) {
            return new int[] { dp1[index], dp2[index] };
        }
        int sum1 = 0;// 不加
        int sum2 = happy[index];// 加
        for (int i = 0; i < childs[index].size(); i++) {
            int child = childs[index].get(i);
            int[] temp = getMaxHappy(happy, relations, child, dp1, dp2, childs);
            sum1 += Math.max(temp[0], temp[1]);
            sum2 += temp[0];
        }

        maxHappy = Math.max(maxHappy, Math.max(sum1, sum2));
        dp1[index] = sum1;
        dp2[index] = sum2;
        return new int[] { dp1[index], dp2[index] };
    }
}