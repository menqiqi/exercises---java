public class Practice374 {
    public static void main(String[] args) {
        int[] num = new int[]{9,4,2,8,6,4,7};
        //bubbleSort(num,num.length);
        //insertSort(num,num.length);
        //shellSort(num,num.length);
        //selectSort(num,num.length);
        //heapSort(num,num.length);
        //quickSort(num,0,num.length);
        mergeSort(num,num.length);
        for (int t : num)
            System.out.print(t+" ");
    }

    /**
     * 冒泡排序
     * 时间复杂度：O(N^2)  空间复杂度：O(1)  稳定
     * @param num
     * @param n
     */
    public static void bubbleSort(int[] num, int n){
        boolean flag = true;
        for (int i = 0; i < n-1; i++){
            for (int j = 0; j < n-1-i; j++){
                if (num[j] > num[j+1]){
                    int tmp = num[j];
                    num[j] = num[j+1];
                    num[j+1] = tmp;
                    flag = false;
                }
            }
            if (flag)
                break;
        }
    }

    /**
     * 插入排序：假设第一个元素有序，从第二个开始插入
     * 时间复杂度：O(N^2)  空间复杂度：O(1)  稳定
     * @param num
     * @param n
     */
    public static void insertSort(int[] num, int n){
        for (int i = 1; i < n; i++){
            int key = num[i];  //将要排序的元素
            int end = i-1;
            while (end >= 0 && num[end] > key){
                num[end+1] = num[end];
                end--;
            }
            num[end+1] = key;
        }
    }

    /**
     * 希尔排序：将分组和插排结合
     * 时间复杂度：O(N^1.3)  空间复杂度：O(1)  不稳定
     * @param num
     * @param n
     */
    public static void shellSort(int[] num, int n){
        int grap = n;
        while (grap > 1){
            grap = grap/3+1;
            for (int i = grap; i < n; i++){
                int key = num[i];
                int end = i-grap;
                while (end >= 0 && num[end] > key){
                    num[end+grap] = num[end];
                    end -= grap;
                }
                num[end+grap] = key;
            }
        }
    }

    /**
     * 选择排序：分别找最大值和最小者放在左右两边
     * 时间复杂度：O(N^2)  空间复杂度：O(1)  不稳定
     * @param num
     * @param n
     */
    public static void selectSort(int[] num, int n){
        int left = 0, right = n-1;
        while (left < right){
            int min = left;
            int max = left;
            for (int i = left+1; i <= right; i++){
                if (num[i] < num[min])
                    min = i;
                if (num[i] > num[max])
                    max = i;
            }
            //max和right交换，min和left交换
            int tmp1 = num[max];
            num[max] = num[right];
            num[right] = tmp1;

            int tmp2 = num[min];
            num[min] = num[left];
            num[left] = tmp2;
            left++;
            right--;
        }
    }

    /**
     * 堆排序：循环建堆，排序
     * 时间复杂度：O(N*lgN)  空间复杂度：O(1)  不稳定
     * @param num
     * @param n
     */
    public static void heapSort(int[] num, int n){
        //1.建堆
        int root = (n-2)/2;  //最后一个非叶子节点
        for (; root >= 0; root--){
             //向下建堆
            buildHeap(num, n, root);
        }
        //2.排序：将堆顶元素放在最有一个位置上
        int end = n-1;
        for (; end >= 0; end--){
            int tmp = num[0];
            num[0] = num[end];
            num[end] = tmp;
            buildHeap(num,end,0);
        }
    }

    public static void buildHeap(int[] num, int n, int parent){
        int children = parent*2+1;
        while (children < n){
            if ((children+1)<n && num[children+1]>num[children])
                children = children+1;
            if (num[children] > num[parent]){
                int tmp = num[parent];
                num[parent] = num[children];
                num[children] = tmp;
            }
            parent = children;
            children = parent*2+1;
        }
    }

    /**
     * 快速排序：让基准值的左边的数字都比它小，右边的数字都比它大
     * 时间复杂度：O(N*lgN)  空间复杂度：O(N*logN)  不稳定
     * @param num
     * @param
     */
    public static void quickSort(int[] num, int left, int right){
        if (left < right){
            //int div = part1(num, left, right);
            int div = part2(num, left, right);
            quickSort(num, left, div);
            quickSort(num, div+1, right);
        }
    }

    /**
     * haore 版本
     * @param num
     * @param left
     * @param right
     * @return
     */
    public static int part1(int[] num, int left, int right){
        int start = left, end = right-1;
        int key = num[right-1];
        while (start < end){
            while (num[start] <= key && start < end)
                start++;
            while (num[end] >= key && end > start)
                end--;
            int tmp = num[start];
            num[start] = num[end];
            num[end] = tmp;
        }

        /**
         * num[right-1]就是key的值，将key放在应该放的位置上
         * 不能直接拿key交换，不然就是仅仅改变了key的值，没有改变数组中的值
         */
        if (start != (right-1)){
            int tmp = num[start];
            num[start] = num[right-1];
            num[right-1] = tmp;
        }
        return start;
    }

    /**
     * 挖坑法
     * @param num
     * @param left
     * @param right
     * @return
     */
    public static int part2(int[] num, int left, int right){
        int start = left, end = right-1;
        int key = num[right-1];
        while (start < end){
            while (start < end && num[start] <= key)
                start++;
            if (start < end){
                num[end] = num[start];
                end--;
            }
            while (start < end && num[end] >= key)
                end--;
            if (start < end){
                num[start] = num[end];
                start++;
            }
        }
        num[start] = key;
        return start;
    }

    /**
     * 归并排序
     * 时间复杂度：O(N*lgN)  空间复杂度：O(N)  稳定
     * @param num
     * @param n
     */
    public static void mergeSort(int[] num, int n){
        int[] tmp = new int[n];
        int gap = 1;  //分组中元素的个数
        while (gap < n){
            for (int i = 0; i < n; i+=gap*2){
                int left = i;
                int mid = left+gap;
                int right = mid+gap;
                if (mid > n){
                    mid = n;
                }
                if (right > n){
                    right = n;
                }
                //合并
                mergeData(num, left, mid, right, tmp);

                for (int j = 0; j < (right-left); j++){
                    num[j+left] = tmp[j];
                }
            }
            gap *= 2;
        }
    }

    /**
     * 合并有序数组
     * @param num
     * @param left
     * @param mid
     * @param right
     * @param tmp
     */
    public static void mergeData(int[] num, int left, int mid, int right, int[] tmp){
        int start1 = left;
        int end1 = mid;
        int start2 = mid;
        int end2 = right;
        int index = 0;
        while (start1 < end1 && start2 < end2){
            if (num[start1] < num[start2]){
                tmp[index++] = num[start1];
                start1++;
            }else if (num[start1] > num[start2]){
                tmp[index++] = num[start2];
                start2++;
            }else{
                tmp[index++] = num[start1];
                tmp[index++] = num[start2];
                start1++;
                start2++;
            }
        }
        while (start1 < end1){
            tmp[index++] = num[start1++];
        }
        while (start2 < end2){
            tmp[index++] = num[start2++];
        }
    }
}
