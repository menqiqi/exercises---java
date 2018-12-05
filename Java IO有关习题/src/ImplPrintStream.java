//模拟实现PrintStream


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

class PrintUtil{
    private OutputStream out;

    public PrintUtil(OutputStream out) {
        this.out = out;
    }
    public void print(String str){
        try {
            //核心在于OutputStream提供的write
            this.out.write(str.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void println(String str){
        this.print(str+"\r\n");
    }
    public void print(int num){
        this.print(String.valueOf(num));
    }
    public void println(int num){
        this.print(num+"\r\n");
    }
    public void print(double data){
        this.print(String.valueOf(data));
    }
    public void println(double data){
        this.print(data+"\r\n");
    }
    public void close(){
        try {
            this.out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

public class ImplPrintStream {
    public static void main(String[] args) throws Exception {
        //1.取得file对象
        File file = new File("C:"+File.separator+ "Users"
                +File.separator+"Administrator"+File.separator+
                "Desktop"+File.separator+"Test.txt");
        //2.取得输出流
        PrintUtil printUtil = new PrintUtil(new FileOutputStream(file));
        //进行数据输出
        printUtil.print(10.0000);
        printUtil.println(10);
        printUtil.print("hello");
        //关闭流
        printUtil.close();
    }
}
