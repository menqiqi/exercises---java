/**
 * 一个数如果恰好等于它的各因子（该数本身除外）子和，如：6=3+2+1，则称其为“完数”；
 * 若因子之和大于该数，则称其为“盈数”。求出2 到60 之间所有“完数”和“盈数”，
 * 并以如下形式输出： E: e1 e2 e3 ......(ei 为完数) G: g1 g2 g3 ......(gi 为盈数)
 */

public class Practice283 {
    public static void main(String[] args) {
        int sum=0;
        StringBuffer wanshu=new StringBuffer("E: ");
        StringBuffer yingshu=new StringBuffer("G: 2 ");
        for(int i=2;i<=60;i++) {
            sum=0;
            for(int j=1;j<i;j++) {
                if(i % j==0) {
                    sum+=j;
                }
            }
            if(sum==i) {
                wanshu.append(i+" ");
            }else if(sum>i) {
                yingshu.append(i+" ");
            }
        }
        System.out.println(wanshu.toString()+yingshu.toString());
    }
}

