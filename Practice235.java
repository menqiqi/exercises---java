/**
 * 编写程序，读入一个整数N。若N为非负数，则计算N 到2N 之间的整数和；
 * 若N为一个负数，则求2N 到N 之间的整数和。
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Practice235 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        List<Integer> numList = new ArrayList<Integer>();
        for(int i = 0;i < m;i++){
            int n = sc.nextInt();
            numList.add(n);
        }
        for(int i = 0;i < numList.size();i++){
            int number = numList.get(i);
            int outNum = 0;
            if(number < 0){
                for(int j = number * 2;j <= number;j++){
                    outNum = outNum + j;
                }
                System.out.println(outNum);
            }else{
                for(int j = number;j <= number * 2;j++){
                    outNum = outNum + j;
                }
                System.out.println(outNum);
            }
        }
    }
}
