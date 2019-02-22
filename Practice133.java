import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Practice133 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        String str[] = br.readLine().split(" ");
        int nums[] = new int[size];
        for (int i=0;i<size;i++){
            nums[i] = Integer.parseInt(str[i]);
        }
        int count = 0;
        int[] tmp = Arrays.copyOf(nums, size);

        for(int i = 1; i < size; i++){
            int key = tmp[i];
            int end = i - 1;
            while(end >= 0 && tmp[end] > key){
                tmp[end+1] = tmp[end];
                end--;
            }
            tmp[end+1] = key;
        }

        for(int j = 0; j < size; j++){
            if(tmp[j] != nums[j])
                count++;
        }
        System.out.println(count);
    }
}