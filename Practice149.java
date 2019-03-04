
class Finder {
    public int findKth(int[] a, int n, int K) {
        // write code here
        //快速排序（找基准值）
        int left = 0;
        int right = n;
        quickSort(a,left,right);
        return a[K-1];
    }

    public void quickSort(int[] a, int left, int right){
        if(left < right){
            int div = partion(a, left, right);
            quickSort(a, left, div);
            quickSort(a, div+1, right);
        }
    }

    //返回基准值，使基准值的左边都是比它小的数，右边都是比它大的数
    public int partion(int[] a, int left, int right){
        int begin = left;
        int end = right - 1;
        int key = a[right-1];
        while(begin < end){
            while(a[begin] <= key && begin < end)
                begin++;
            while(a[end] > key && begin < end)
                end--;

            int tmp = a[begin];
            a[begin] = a[end];
            a[end] = tmp;
        }

        if(begin != (right-1)){
            int tmp = a[begin];
            a[begin] = a[right-1];
            a[right-1] = tmp;
        }
        return begin;
    }

}

public class Practice149{
    public static void main(String[] args) {
        Finder f = new Finder();
        int[] a = {1,3,5,2,2,6,8};
        System.out.println(f.findKth(a,7,3));
    }
}
