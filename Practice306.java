/**
 * 对于一个矩阵，请设计一个算法从左上角(mat[0][0])开始，顺时针打印矩阵元素。
 *
 * 给定int矩阵mat,以及它的维数nxm，请返回一个数组，数组中的元素为矩阵元素的顺时针输出。
 */

public class Practice306 {
    public int[] clockwisePrint(int[][] mat, int n, int m) {
        int startX=0;
        int endX=m-1;
        int startY=0;
        int endY=n-1;
        int k=0;
        int[] a=new int[n*m];
        while(startX<=endX&&startY<=endY){
            if(startX<=endX){ //左往右
                for(int i=startX;i<=endX;i++)
                    a[k++]=mat[startY][i];
            }
            if(startY<endY){  //上往下
                for(int i=startY+1;i<=endY;i++){
                    a[k++]=mat[i][endX];
                }
            }
            if(startX<endX&&startY<endY){ //右往左
                for(int i=endX-1;i>=startX;i--){
                    a[k++]=mat[endY][i];
                }
            }
            if(startY<endY&&endX>startX){  //下往上
                for(int i=endY-1;i>=startY+1;i--){
                    a[k++]=mat[i][startX];
                }
            }
            startX++;
            endX--;
            startY++;
            endY--;
        }
        return a;


    }
}}
