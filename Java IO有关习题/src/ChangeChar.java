//内存流实现字母转换

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class ChangeChar {
    public static void main(String[] args) throws Exception {
        //内存流实现字母的转换
        String msg = "hello";
        //取得内存流
        ByteArrayInputStream inputStream = new ByteArrayInputStream(msg.getBytes());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        int len = 0;
        while((len = inputStream.read()) != -1){
            outputStream.write(Character.toUpperCase(len));
        }
        //直接将内存输出流输出
        System.out.println(outputStream);
    }
}