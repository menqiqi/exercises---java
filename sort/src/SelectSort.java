public class SelectSort {
    public void selectSort(int[] arr){
        //选择排序，每次排最大的和最小的
        int minSpace = 0;
        int maxSpace = arr.length-1;
        while(minSpace < maxSpace){
            //最大值和最小值的下标
            int minPos = minSpace;
            int maxPos = minSpace;
            for (int i = minSpace+1; i < maxSpace; i++){
                if(arr[i] < arr[minPos])
                    minPos = i;
                if (arr[i] > arr[maxPos])
                    maxPos = i;
            }
            //将找到的最大值和最小值与maxSpace和minSpace交换
            int tmp1 = arr[minPos];
            arr[minPos] = arr[minSpace];
            arr[minSpace] = tmp1;
            //最大值在第一个数为特殊情况,最小值交换时将最大的数移动了位置
            if (minSpace == maxPos)
                maxPos = minPos;
            int tmp2 = arr[maxPos];
            arr[maxPos] = arr[maxSpace];
            arr[maxSpace] = tmp2;
            minSpace++;
            maxSpace--;
        }
    }
}
