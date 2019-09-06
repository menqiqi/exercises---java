/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */

/*
import java.util.ArrayList;
public class Practice371 {
    public static void main(String[] args) {
        int[] data = new int[]{3,4,5,1,2};
        int res = minNumberInRotateArray(data);
        System.out.println(res);
    }
    public static int minNumberInRotateArray(int [] array) {
        int left = 0;
        int right = array.length-1;
        while(left < right){
            int mid = left + (right-left)/2;
            if(array[mid] > array[right]){
                left = mid+1;
            }else if(array[mid] < array[right]){
                right = mid;
            }else{
                right = right-1;
            }
        }
        return array[left];
    }
}*/
