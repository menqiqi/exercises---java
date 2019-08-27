/**
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */

public class Solution {
    public boolean Find(int target, int [][] array) {
        //从右上角开始比较，比该数小就向右移动，大就向下移动
        int len1 = array.length;
        int len2 = array[0].length;
        int i = 0, j = len2-1;
        while(i < len1 && j >= 0){
            int num = array[i][j];
            if(target == num){
                return true;
            }else if(target < num){
                //向右寻找
                j--;
            }else{
                //向下寻找
                i++;
            }
        }
        return false;
    }
}
