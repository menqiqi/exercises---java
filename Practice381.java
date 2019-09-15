import java.util.ArrayList;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */

public class Practice381 {
    public static void main(String[] args) {
        int[][] num = {{1,2},{3,4}};
        ArrayList<Integer> list = printMatrix(num);
        for (int t: list){
            System.out.print(t+" ");
        }
    }

    public static ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        if(matrix==null || matrix.length==0){
            return list;
        }
        int up = 0, down = matrix.length-1, left = 0, right = matrix[0].length-1;
        while(true){
            int tmp = left;
            //向右遍历
            while(tmp <= right){
                list.add(matrix[up][tmp]);
                tmp++;
            }
            up++;
            if(up > down){
                break;
            }
            //向下遍历
            tmp = up;
            while(tmp <= down){
                list.add(matrix[tmp][right]);
                tmp++;
            }
            right--;
            if(right < left){
                break;
            }
            //向左遍历
            tmp = right;
            while(tmp >= left){
                list.add(matrix[down][tmp]);
                tmp--;
            }
            down--;
            if(down < up){
                break;
            }
            //向上遍历
            tmp = down;
            while(tmp >= up){
                list.add(matrix[tmp][left]);
                tmp--;
            }
            left++;
            if(left > right){
                break;
            }
        }
        return list;
    }
}
