public class MergeSortNor {
    public void mergeSortNor(int[] arr){
        int size = arr.length;
        int[] tmp = new int[size];
        int gap = 1;  //以一个数据为一组，开始合并
        while (gap < size){
            for (int i = 0; i < size; i+=gap*2){
                int left = i;
                int mid = left+gap;
                int right = mid + gap;
                if (mid > size)
                    mid = size;
                if (right > size)
                    right = size;
                mergeData(arr,left,mid,right,tmp);

                for (int j = 0; j < (right-left); j++){
                    arr[j+left] = tmp[j];
                }
            }
            gap = gap*2;
        }
    }

    private void mergeData(int[] arr, int left, int mid, int right, int[] tmp){
        int begin1 = left;
        int end1 = mid;
        int begin2 = mid;
        int end2 = right;
        int index = 0;
        while (begin1 < end1 && begin2 < end2){
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
