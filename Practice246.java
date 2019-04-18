/**
 * 有一个二维数组(n*n),写程序实现从右上角到左下角沿主对角线方向打印。
 *
 * 给定一个二位数组arr及题目中的参数n，请返回结果数组。
 */


class Printer {
    public int[] arrayPrint(int[][] arr, int n) {
        // write code here
        int[] res = new int[n*n];
        int index = 0;
        //右边的三角
        for(int j = n-1; j >= 0; j--){
            int i = 0;
            res[index++] = arr[i][j];
            int tmp = j;
            while(i < n-1 && tmp < n-1){
                i++;
                tmp++;
                res[index++] = arr[i][tmp];
            }
        }
        //左边的三角
        for (int i = 1; i < n; i++){
            int j = 0;
            res[index++] = arr[i][j];
            int tmp = i;
            while (tmp < n-1 && j < n-1){
                tmp++;
                j++;
                res[index++] = arr[tmp][j];
            }
        }
        return res;
    }
}

public class Practice246 {
    public static void main(String[] args) {
        Printer printer = new Printer();
        int[][] arr = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int[] res = printer.arrayPrint(arr,arr.length);
        for (int i : res){
            System.out.print(i+",");
        }
    }
}
