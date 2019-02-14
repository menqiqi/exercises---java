/**
 * 思想：
 *  1.确定基准值
 *  2.通过一定的算法，让基准值的左边全是小于它的数，右边全是大于它的数
 *  3.采用分治的思想
 */

public class QuickSort {
    public void quickSort(int[] arr, int left, int right){
        if (left < right){
            //按照基准值将left和right标记区间划分为两部分
            //int div = partion1(arr,left,right);
            //int div = partion2(arr,left,right);
            int div = partion3(arr,left,right);
            //排列左半部分
            quickSort(arr, left, div);
            //排列右半部分
            quickSort(arr, div+1, right);  //div不需要排序，不然一直在死循环
        }
    }

    private int GetMindleIndex(int[] arr, int left, int right){
        int mid = left+(right-left)/2;
        if (arr[left] < arr[right-1]){
            if (arr[mid] < arr[left])
                return left;
            else if (arr[mid] > arr[right-1])
                return right-1;
            else
                return mid;
        }else {
            if (arr[mid] > arr[left])
                return left;
            else if (arr[mid] < arr[right-1])
                return right-1;
            else
                return mid;
        }
    }


    /**
     * hoare版本
     * @param arr
     * @param left
     * @param right
     * @return
     */
    private int partion1(int[] arr, int left, int right){
        int begin = left;
        int end = right - 1;

        //找尽量值为中间的数
        int mid = GetMindleIndex(arr,left,right);
        if (arr[right-1] != arr[mid]){
            int tmp = arr[right-1];
            arr[right-1] = arr[mid];
            arr[mid] = tmp;
        }

        int key = arr[right-1];

        while (begin < end){
            while (arr[begin] <= key && begin < end)
                begin++;
            while (arr[end] >= key && begin < end)
                end--;

            int tmp = arr[begin];
            arr[begin] = arr[end];
            arr[end] = tmp;
        }

        /**
         * arr[right-1]就是key的值，将key放在它该放的位置上去
         * 不能用key直接和arr[begin]交换，不然就仅仅是改变了key值
         */

        if (begin != right-1){
            int tmp = arr[begin];
            arr[begin] = arr[right-1];
            arr[right-1] = tmp;
        }
        return begin;
    }

    /**
     * 挖坑法
     * @param arr
     * @param left
     * @param right
     * @return
     */
    private int partion2(int[] arr, int left, int right){
        int begin = left;
        int end = right - 1;

        //找尽量值为中间的数
        int mid = GetMindleIndex(arr,left,right);
        if (arr[right-1] != arr[mid]){
            int tmp = arr[right-1];
            arr[right-1] = arr[mid];
            arr[mid] = tmp;
        }

        int key = arr[right-1];
        while (begin < end){
            while (begin < end && arr[begin] < key)
                begin++;
            //如果找到大于基准值的数，把它填到之前的坑中，它是一个新的坑
            if (begin < end){
                arr[end] = arr[begin];
                end--;
            }

            while (begin < end && arr[end] > key)
                end--;
            if (begin < end){
                arr[begin] = arr[end];
                begin++;
            }
        }
        arr[begin] = key;
        return begin;

    }


    /**
     * 前后指针法
     * @param arr
     * @param left
     * @param right
     * @return
     */
    private int partion3(int[] arr, int left, int right){
        int prev = left-1;
        int cur = left;

        //找尽量值为中间的数
        int mid = GetMindleIndex(arr,left,right);
        if (arr[right-1] != arr[mid]){
            int tmp = arr[right-1];
            arr[right-1] = arr[mid];
            arr[mid] = tmp;
        }

        int key = arr[right-1];
        while (cur < right) {
            //cur去找小于基准值的数，prev指向大于基准值的数
            if (arr[cur] < key && ++prev != cur) {
                int tmp = arr[cur];
                arr[cur] = arr[prev];
                arr[prev] = tmp;
            }

            ++cur;

        }
        //prev+1就是基准值应该在的位置
            if (++prev != right-1){
                int tmp = arr[prev];
                arr[prev] = arr[right-1];
                arr[right-1] = tmp;
            }
            return prev;
    }

}
