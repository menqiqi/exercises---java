public class MergeSort {
    public void mergeSort(int[] arr){
        int size = arr.length;
        int[] tmp = new int[size];
        _MergeSort(arr,0,size,tmp);
    }


    private void _MergeSort(int[] arr, int left, int right, int[] tmp){
        if (right - left > 1){
            /**
             * 划分
             */
            int mid = left + (right - left)/2;
            _MergeSort(arr,left,mid, tmp);
            _MergeSort(arr,mid,right, tmp);

            //合并
            mergeData(arr,left,mid,right,tmp);
            for (int i = 0; i < (right-left); i++){
                //tmp每次都更新，要排序的数永远从第一个开始
                //arr不更新，要接着从下开始
                arr[i+left] = tmp[i];
            }
        }
    }

    /**
     * 合并
     */
    private void mergeData(int[] arr, int left, int mid, int right, int[] tmp) {
        //区间1   左闭右开
        int begin1 = left;
        int end1 = mid;
        //区间2
        int begin2 = mid;
        int end2 = right;

        int index = 0;
        while (begin1 < end1 && begin2 < end2) {
            //实际上就是合并有序数组
            if (arr[begin1] < arr[begin2])
                tmp[index++] = arr[begin1++];
            else
                tmp[index++] = arr[begin2++];
        }
        while (begin1 < end1)
            tmp[index++] = arr[begin1++];
        while (begin2 < end2)
            tmp[index++] = arr[begin2++];
    }
}
