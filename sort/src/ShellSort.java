public class ShellSort {
    public void shellSort(int[] arr){
        int gap = arr.length;

        //当gap不为1时，是预排序，当gap为1时，进行插入排序
        while(true){
            //这个算式只是根据经验得来的，不一定非得是这个
            gap = gap/3+1;

            //一个排gap组
            for(int g = 0; g < gap; g++){
                //分别按组进行插排
                for(int i = g+gap; i < arr.length; i+=gap){
                    int key = arr[i];
                    int j = i - gap;
                    for(j = i-gap; j >= 0; j-=gap){
                        if (key < arr[j]){
                            arr[j+gap] = arr[j];
                        }else {
                            break;
                        }
                    }
                    arr[j+gap] = key;
                }
            }
            if (gap == 1){
                break;
            }
        }
    }
}
