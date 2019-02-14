/**
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 */

//暴力破解法
/*class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        for(int i = 0; i < height.length-1; i++){
            for(int j = i+1; j < height.length; j++){
                int x = height[j] > height[i] ? height[i] : height[j];
                int y = j - i;
                int sum = x * y;
                if(sum > max)
                    max = sum;
            }
        }
        return max;
    }
}*/

/**
 * 双指针法
 * 一个指向最后一个元素，一个指向第一个元素，面积的大小收到元素的长度和两元素之间的距离的影响
 * 比较指向的两元素大小，如果是小的，就前进或者后退一步
 * 只需要遍历一次
 */
class Solution {
    public int maxArea(int[] height) {
        int len = height.length;
        int i = 0, j = len - 1;
        int max = 0;
        for(int k = 0; k < len; k++){
            int x = height[i] > height[j] ? height[j] : height[i];
            int y = j - i;
            int area = x * y;
            if(area > max)
                max = area;
            if(x == height[i]){
                i++;
            }else{
                j--;
            }
        }
        return max;
    }
}


public class Practice117 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}
