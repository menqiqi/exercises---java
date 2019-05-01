/**
 * 无类别域间路由（CIDR）是一个用于对IPV4地址进行分类表述的方法。CIDR 路由描述的IP地址组的子网mask长度是可变长度, 例如10.0.0.0/22 表示前22位和10.0.0.0相同的网络地址都被覆盖, 22包含了10.0这前两个字段(0-7位,8-15位)和第三个字段的前6位(16-21,即0b000000**), 涵盖了 10.0.0.*, 10.0.1.*, 10.0.2.*, 10.0.3.* 四组ip地址. 在此前提下请实现IP网络中的一个常用的去重操作: 给定一系列 CIDR 路由地址, 其中没有完全等价的路由, 去掉被重复表示的 CIDR 路由, 即去掉已经被其他CIDR路由表示覆盖的路由地址. 例如 10.0.1.1/32 已经被 10.0.0.0/22覆盖了, 如果路由列表中已经有了后者, 就可以去掉前者.
 *
 *
 * 输入描述:
 * k+1行, k表示输入的CIDR路由个数
 * 第1行:表示路由个数k
 * 第2~k+1行: 表示一个CIDR路由, 形如 x.x.x.x/x
 *
 * 输出描述:
 * n+1行, n表示去重后剩下的CIDR路由个数
 * 第1行:n
 * 第2~n+1行: 表示一个去重后的CIDR路由, 输出按照输入顺序
 */


// 务必注意分隔符.需要转义
// 一个IP地址正好可以用一个int表示，符号位不重要，只需要无符号右移
import java.io.*;
import java.util.*;
public class Practice272 {
    static class Addr{
        String addrStr;
        int mask;
        int addr;
        public Addr(String addrStr, int mask, int addr){this.addrStr = addrStr; this.mask = mask; this.addr = addr;}
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        LinkedList<Addr> list = new LinkedList<>();
        while(n-->0){
            String addrStr = br.readLine();
            String[] strs = addrStr.split("/");
            int mask = Integer.parseInt(strs[1]);
            strs = strs[0].split("\\.");
            int addr = (Integer.parseInt(strs[0])<<24) | (Integer.parseInt(strs[1])<<16) | (Integer.parseInt(strs[2])<<8) | Integer.parseInt(strs[3]);
            boolean flag = true;
            for(Iterator<Addr> it = list.iterator(); it.hasNext(); ){
                Addr tmp = it.next();
                if(mask < tmp.mask && ( (addr ^ tmp.addr) >>> (32-mask) == 0) ) it.remove();
                if(mask >= tmp.mask && ( (addr ^ tmp.addr) >>> (32-tmp.mask) == 0) ){flag = false;break;}
            }
            if(flag) list.add(new Addr(addrStr,mask,addr));
        }
        System.out.println(list.size());
        for(Iterator<Addr> it = list.iterator(); it.hasNext(); ){
            Addr tmp = it.next();
            System.out.println(tmp.addrStr);
        }
    }
}
