import java.util.Stack;

public class QuickSortNor {
    public void quickSortNor(int[] arr){
        int size = arr.length;
        Stack<Integer> stack = new Stack<>();
        stack.push(size);
        stack.push(0);
        while(!stack.isEmpty()){
            int left = stack.pop();
            int right = stack.pop();
            if (right - left > 1){
                int div = partion3(arr,left,right);
                stack.push(right);
                stack.push(div+1);

                stack.push(div);
                stack.push(left);
            }
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
