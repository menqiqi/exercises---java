package www.bit.java;

/**
 * 给定一个二进制矩阵 A，我们想先水平翻转图像，然后反转图像并返回结果。
 *
 * 水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如,水平翻转[1,1,0]的结果是 [0,1,1]。
 *
 * 反转图片的意思是图片中的0全部被1替换,1全部被0替换。例如，反转 [0,1,1]的结果是 [1,0,0]。
 */

class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        //翻转图像
        for(int i = 0; i < A.length; i++){
            //每一行元素的个数
            int len = A[i].length;
            int left = 0;
            int right = len-1;
            while(right > left){
                int tmp = A[i][left];
                A[i][left] = A[i][right];
                A[i][right] = tmp;
                left++;
                right--;
            }
        }
        //反转图像
        for(int m = 0; m < A.length; m++){
            for(int n = 0; n < A[m].length; n++){
                if(A[m][n] == 1){
                    A[m][n] = 0;
                }else if(A[m][n] == 0){
                    A[m][n] = 1;
                }
            }
        }
        return A;
    }
}

public class practice13 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] A = {{1,1,0},{1,0,1},{0,0,0}};
        int[][] B = solution.flipAndInvertImage(A);
        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < A[i].length; j++){
                System.out.print(B[i][j]+",");
            }
            System.out.print("  ");
        }
    }
}
