/**
 * 农场有n只鸡鸭排为一个队伍，鸡用“C”表示，鸭用“D”表示。当鸡鸭挨着时会产生矛盾。需要对所排的队伍进行调整，使鸡鸭各在一边。每次调整只能让相邻的鸡和鸭交换位置，现在需要尽快完成队伍调整，你需要计算出最少需要调整多少次可以让上述情况最少。例如：CCDCC->CCCDC->CCCCD这样就能使之前的两处鸡鸭相邻变为一处鸡鸭相邻，需要调整队形两次。
 */

import java.util.*;
public class Practice349 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int n = str.length();
        int resC = 0,resD = 0,countC = 0,countD = 0;
        for(int i = 0; i < n; i++){
            if(str.charAt(i)=='C'){
                resC += i - countC;
                countC++;
            }else{
                resD += i - countD;
                countD++;
            }
        }
        System.out.println(Math.min(resC,resD));
    }
}