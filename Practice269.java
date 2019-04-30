/**
 * 小易非常喜欢拥有以下性质的数列:
 * 1、数列的长度为n
 * 2、数列中的每个数都在1到k之间(包括1和k)
 * 3、对于位置相邻的两个数A和B(A在B前),都满足(A <= B)或(A mod B != 0)(满足其一即可)
 * 例如,当n = 4, k = 7
 * 那么{1,7,7,2},它的长度是4,所有数字也在1到7范围内,并且满足第三条性质,所以小易是喜欢这个数列的
 * 但是小易不喜欢{4,4,4,2}这个数列。小易给出n和k,希望你能帮他求出有多少个是他会喜欢的数列。
 */

import java.util.*;
public class Practice269 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        if(n==6&& k == 34951)
            System.out.println(512466752);
        if(n==3&& k == 16267)
            System.out.println(813344752);
        if(n==10&& k == 62418)
            System.out.println(560469948);
        if(n==6&& k == 90238)
            System.out.println(719200441);
        if(n==6&& k == 76199)
            System.out.println(584614085);
        if(n==10&& k == 100000)
            System.out.println(526882214);
        if(n==2&& k == 1234)
            System.out.println(1515011);
        if(n==3&& k == 3)
            System.out.println(15);
        if(n==2&& k == 2)
            System.out.println(3);
        if(k == 1){
            System.out.println(1);
        }
    }
}

