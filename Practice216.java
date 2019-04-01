/**
 * 链接：https://www.nowcoder.com/questionTerminal/00ffd656b9604d1998e966d555005a4b
 * 来源：牛客网
 *
 * 考试题目和要点：
 *
 * 1、中文大写金额数字前应标明“人民币”字样。中文大写金额数字应用壹、贰、叁、肆、伍、陆、柒、捌、玖、拾、佰、仟、万、亿、元、角、分、零、整等字样填写。（30分）
 *
 * 2、中文大写金额数字到“元”为止的，在“元”之后，应写“整字，如￥ 532.00应写成“人民币伍佰叁拾贰元整”。在”角“和”分“后面不写”整字。（30分）
 *
 * 3、阿拉伯数字中间有“0”时，中文大写要写“零”字，阿拉伯数字中间连续有几个“0”时，中文大写金额中间只写一个“零”字，如￥6007.14，应写成“人民币陆仟零柒元壹角肆分“。
 */

import java.util.Scanner;
public class Practice216 {
    public static void main(String[] args){
        final String[] st = {"零","壹","贰","叁","肆","伍","陆","柒","捌","玖"};
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            Double money = sc.nextDouble();
            StringBuffer stb = new StringBuffer();
            int yi = (int)(money/100000000);
            int wan = (int)((money%100000000)/10000);
            int yuan = (int)(money%10000);
//取余数运算有问题这里，所以加上0.001
            int xiaoshu=(int) ((money - yi * 100000000 - wan * 10000 - yuan + 0.001) * 100);
            int xiao=xiaoshu/10;
            int shu =  (int)((money%1+0.001)*100%10);
            System.out.print("人民币");
            if(yi != 0){
                stb.append(change(yi) + "亿");
            }
            if(wan != 0){
                stb.append(change(wan) + "万");
            }
            if(yuan != 0){
                stb.append(change(yuan) + "元");
            }
            if(xiao == 0 && shu == 0){
                stb.append("整");
            }else if(xiao != 0 && shu != 0){
                stb.append(st[xiao] + "角" + st[shu] + "分");
            }else if(xiao != 0 && shu == 0){
                stb.append(st[xiao] + "角");
            }else{
                stb.append(st[shu] + "分");
            }
            String moni = stb.toString();
            System.out.println(moni);
        }
        sc.close();
    }

    public static String change(int db){
        final String[] st = {"零","壹","贰","叁","肆","伍","陆","柒","捌","玖"};
        StringBuffer stb = new StringBuffer();
        int qian = db/1000;
        int bai = (db%1000)/100;
        int shi = (db%100)/10;
        int ge = (db%10);
        if(qian != 0){
            stb.append(st[qian] + "仟");
        }
        if(bai != 0){
            stb.append(st[bai] + "佰");
        }else if(qian != 0 && bai == 0 &&(shi != 0 || ge != 0) ){
            stb.append("零");
        }
        if(shi != 0 && shi != 1){
            stb.append(st[shi] + "拾");
        }else if(qian ==0 && bai == 0 && shi != 0 && shi == 1){
            stb.append("拾");
        }else if((qian != 0 || bai != 0) && shi != 0 && shi == 1){
            stb.append(st[shi] + "拾");
        }
        if(ge != 0)
        {
            stb.append(st[ge]);
        }
        String str = stb.toString();
        return str;
    }
}