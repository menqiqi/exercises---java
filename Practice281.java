/**
 * 小招喵喜欢在数轴上跑来跑去，假设它现在站在点n处，它只会3种走法，分别是：
 * 1.数轴上向前走一步，即n=n+1
 * 2.数轴上向后走一步,即n=n-1
 * 3.数轴上使劲跳跃到当前点的两倍，即n=2*n
 * 现在小招喵在原点，即n=0，它想去点x处，快帮小招喵算算最快的走法需要多少步？
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Practice281 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int num=Integer.parseInt(br.readLine());
        if(num<0)
            num=-num;
        if(num==0)
        {
            System.out.print(0);
            return;
        }
        int[] iArr=new int[num+1];
        iArr[0]=0;
        for(int i=1;i<num+1;i++)
        {
            if(i%2==0)
                iArr[i]=iArr[i/2]+1;
            else
                iArr[i]=Math.min(iArr[i-1],iArr[(i+1)/2]+1)+1;
        }
        System.out.print(iArr[num]);
    }
}
