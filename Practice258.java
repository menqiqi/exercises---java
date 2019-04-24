/**
 * 输入两个整数n和m，从数列1,2,3.。。n中随意取出几个数，要求将其中所有可能组合列出来。
 */

import java.util.*;
public class Practice258 {
    public static List<Integer> temp=new ArrayList<Integer>();
    public static int sum=0;
    public static void main(String args[]){
        Scanner in=new Scanner(System.in);
        while(in.hasNext()) {
            int N = in.nextInt();
            int M = in.nextInt();
            dfs(M,N,1);
            sum=0;
        }
    }
    public static void dfs(int M,int N,int pos){
        if(sum>M || pos>N+1){
            return ;
        }else if(sum==M){
            for(int i=0;i<temp.size();i++){
                if(i==0){
                    System.out.print(temp.get(i));
                }else{
                    System.out.print(" "+temp.get(i));
                }
            }
            System.out.println();
        }else{
            sum+=pos;
            temp.add(pos);
            dfs(M,N,pos+1);
            sum-=pos;
            temp.remove(temp.size()-1);
            dfs(M,N,pos+1);
        }
    }
}
