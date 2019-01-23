public class InsertSort {
    //从后往前排序
    public void insertSort1(int[] arr){
        int len = arr.length;
        for(int i = 1; i < len; i++){
            //第一个数字默认有序，从后面开始排序
            int key = arr[i];
            //从要比较的那个数字的前一个开始比较，慢慢往前比较
            int j = i-1;
            for(j = i-1; j >=0; j--){
                if(key < arr[j]){
                    //如果要比较的数小于arr[j]，就需要调换位置，只要后移一位即可
                    arr[j+1] = arr[j];
                }else{
                    break;
                }
            }
            arr[j+1] = key;
        }
    }

    //二分查找
    public void insertSort2(int[] arr){
        int len = arr.length;
        for(int i = 0; i < len; i++){
            int left = 0,right = i-1;
            int mid = 0;
            int key = arr[i];
            //二分查找的过程就是在查找key应该插入的位置
            while(left <= right){
                mid = left+(right-left)/2;
                if(key < arr[mid]){
                    right = mid-1;
                }else {
                    left = mid+1;
                }
            }
            //找到应该插入的位置后，要插入的后面的元素全部后移
            for(int j = i; j > left; j--){
                arr[j] = arr[j-1];
            }
            //插入（left就是要插入的位置）
            arr[left] = key;
        }
    }
}
