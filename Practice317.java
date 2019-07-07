import java.util.Scanner;

/**
 * 对N个长度可达1000的数进行排序
 */

public class Practice317 {
    public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            while (in.hasNextInt()) {
                int n = in.nextInt();
                String[] strs = new String[n];
                for(int i =0;i<n;i++){
                    strs[i] = in.next();
                }
                aSort(strs,n);
                for(String s:strs){
                    System.out.println(s);
                }
            }
        }
        public static void aSort(String[] s,int len){
            for(int i = 0;i<len-1;i++){
                for(int j = i+1;j<len;j++){
                    if(s[i].length()>s[j].length()){
                        String str = s[i];
                        s[i] = s[j];
                        s[j] = str;
                    }else if(s[i].length()==s[j].length()){
                        if(s[i].compareTo(s[j])>0){
                            String str = s[i];
                            s[i] = s[j];
                            s[j] = str;
                        }
                    }
                }
            }
        }
        
}
