import java.util.Scanner;

public class Practice316 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            char[] str = in.next().toCharArray();
            for(int i = 0; i < str.length; i++){
                int tmp = str[i];  //字符串中每个字符
                int[] res = new int[9];  //每个字符校验后的结果
                int count = 0, index = 0;//1的个数
                while(tmp != 0){
                    res[index++] = tmp%2;
                    if(tmp%2 == 1)
                        count++;
                    tmp = tmp/2;
                }
                while(index < 7){
                    res[index++] = 0;
                }
                if(count%2 == 0){
                    res[index] = 1;
                }else{
                    res[index] = 0;
                }

                //输出
                for(int j = index; j >=0; j--){
                    System.out.print(res[j]);
                }
                System.out.println();
            }
        }
    }
}
