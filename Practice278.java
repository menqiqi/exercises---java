/**
 * 由数字 1 到 n 组成的一个序列我们称为一个 n 排列。
 * 对于两个不同的 n 排列𝐴 = 𝑎1𝑎2 ... 𝑎𝑛和 𝐵 = 𝑏1𝑏2 ... 𝑏𝑛我们可以按字典序比较他们的大小:
 * 从前往后找到第一个两个排列中数字不同 的位置，即找到一个位置𝑝使得𝑎1 = 𝑏1, 𝑎2 = 𝑏2, ... , 𝑎𝑝−1 = 𝑏𝑝−1, 𝑎𝑝 ≠ 𝑏𝑝，
 * 若𝑎𝑝 < 𝑏𝑝，我们 则称排列𝐴小于排列𝐵，反之则𝐴大于𝐵。
 * 现在给出一个 n 排列，你需要选择排列中的两个不同的位置，然后交换这两个位置的数字，
 * 你需要使得最后得到的排列尽量小。注意你必须进行一次且只能进行一次操作。
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice278 {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] tem = br.readLine().split(" ");
        int[] para = new int[n];
        for (int i=0; i<n; ++i){
            para[i] = Integer.parseInt(tem[i]);
        }
        for(int i=0; i<para.length; ++i){
            if(i==para.length-2){
                int k = para[i];
                para[i] = para[i+1];
                para[i+1] = k;
                break;
            }
            if(i+1==para[i])
                continue;
            int index = 0;
            for(int j=i+1; j<para.length; ++j){
                if(para[j]==i+1){
                    index = j;
                    break;
                }
            }
            int t = para[index];
            para[index] = para[i];
            para[i] = t;
            break;
        }
        StringBuilder res = new StringBuilder();
        for(int i=0; i<para.length; ++i){
            res.append(para[i]);
            res.append(" ");
        }
        res.deleteCharAt(res.length()-1);
        System.out.println(res.toString());
    }
}

