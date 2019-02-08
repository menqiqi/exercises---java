import java.util.HashSet;
import java.util.Set;

/**
 * 爱丽丝和鲍勃有不同大小的糖果棒：A[i] 是爱丽丝拥有的第 i 块糖的大小，B[j] 是鲍勃拥有的第 j 块糖的大小。
 *
 * 因为他们是朋友，所以他们想交换一个糖果棒，这样交换后，他们都有相同的糖果总量。（一个人拥有的糖果总量是他们拥有的糖果棒大小的总和。）
 *
 * 返回一个整数数组 ans，其中 ans[0] 是爱丽丝必须交换的糖果棒的大小，ans[1] 是 Bob 必须交换的糖果棒的大小。
 *
 * 如果有多个答案，你可以返回其中任何一个。保证答案存在。
 *
 *
 *
 * 示例 ：
 *
 * 输入：A = [1,1], B = [2,2]
 * 输出：[1,2]
 */

/*class Solution {
    public int[] fairCandySwap(int[] A, int[] B) {
        int num = 0;
        for(int a:A)
            num = num + a;
        for(int b:B)
            num = num - b;
        //计算出两个数组的差，要把差平均分
        int tmp = num / 2;
        //找出两个数组中相差为tmp的元素，进行交换
        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < B.length; j++){
                if(A[i]-B[j]==tmp){
                    return new int[]{A[i],B[j]};
                }
            }
        }
        return null;
    }
}*/

//方程求解
//Sa - x + y = Sb - y + x
//方程式解为y = x + (Sb-Sa)/2
class Solution {
    public int[] fairCandySwap(int[] A, int[] B) {
        int count1 = 0;
        int count2 = 0;
        for(int a : A)
            count1 = count1 + a;
        for(int b : B)
            count2 = count2 + b;
        int tmp = (count2 - count1)/2;
        //将B集合的内容放入集合，方便查找
        Set<Integer> setB = new HashSet<>();
        for(int b : B)
            setB.add(b);
        //在B中查找是否有符合条件的数字
        for(int a : A){
            if(setB.contains(a+tmp)){
                return new int[]{a,a+tmp};
            }
        }
        return null;
    }
}


public class Practice108 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] res = solution.fairCandySwap(new int[]{1,2},new int[]{2,3});
        System.out.println(res[0]+"、"+res[1]);
    }
}
