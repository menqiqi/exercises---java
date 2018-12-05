//模拟实现文件拷贝

import java.io.*;

public class CopyFile {
    public static void main(String[] args) throws Exception {
        String sourceFilePath = "C:"+File.separator+ "Users"
                +File.separator+"Administrator"+File.separator+
                "Desktop"+File.separator+"公路.jpg";
        String destFilePath = "C:"+File.separator+ "Users"
                +File.separator+"Administrator"+File.separator+
                "Desktop"+File.separator+"图片.jpg";
        copyFile(sourceFilePath,destFilePath);
    }

    /**
     * 文件拷贝
     * @param sourceFilePath 源文件绝对路径
     * @param destFilePath 目标文件绝对路径
     * @return
     */

    public static boolean copyFile(String sourceFilePath,
                                   String destFilePath)throws Exception{
        //1.取得文件对象
        File sourceFile = new File(sourceFilePath);
        File destFile = new File(destFilePath);
        //2.取得输入输出
        InputStream in = new FileInputStream(sourceFile);
        OutputStream out = new FileOutputStream(destFile);
        //3.数据的输入输出
        long start = System.currentTimeMillis();
        byte[] data = new byte[1024];
        int len = 0;
        //设置一个缓冲区
        while((len = in.read(data)) != -1){
            out.write(data,0,len);
        }
        long end = System.currentTimeMillis();
        System.out.println("文件拷贝结束，共耗时"+(end-start)+"毫秒");
        return true;
    }
}