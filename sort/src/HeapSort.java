public class HeapSort {
    public void heapSort(int[] arr){
        //1.建堆  升序建大堆  降序建小堆
        //找到最后一个非叶子节点，开始往上建堆
        int size = arr.length;
        int root = (size-2)/2;
        for(; root >= 0; root--){
            HeapAdjust(arr,size,root);
        }
        //2.堆排序
        //堆顶元素是最大的，将堆顶元素和后面的元素交换，然后继续调整堆
        int end = size - 1;
        while (end > 0){
            int tmp = arr[0];
            arr[0] = arr[end];
            arr[end] = tmp;
            HeapAdjust(arr,end,0);
            end--;
        }
    }

    private void HeapAdjust(int[] arr, int size, int parent){
        int child = (parent*2)+1;
        while (child < size){
            //如果该叶子节点的右节点存在，并且大于左节点
            if ((child+1) < size && arr[child+1] > arr[child]){
                child += 1;
            }

            //判断孩子节点和双亲节点的大小关系
            if (arr[child] > arr[parent]){
                int tmp = arr[child];
                arr[child] = arr[parent];
                arr[parent] = tmp;
            }

            //继续向下调整
            parent = child;
            child = (parent*2)+1;
        }
    }
}
