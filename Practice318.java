/**
 * 输入一行字符串，输出其A-Z的字母的次数
 */



import java.util.*;

public class Practice318 {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        char[] a=str.toCharArray();
        int[] num=new int[26];
        char[] letter= {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        for(int i=0;i<a.length;i++) {
            switch(a[i]) {
                case 'A':
                    num[0]=num[0]+1;
                    break;
                case 'B':
                    num[1]=num[1]+1;
                    break;
                case 'C':
                    num[2]=num[2]+1;
                    break;
                case 'D':
                    num[3]=num[3]+1;
                    break;
                case 'E':
                    num[4]=num[4]+1;
                    break;
                case 'F':
                    num[5]=num[5]+1;
                    break;
                case 'G':
                    num[6]=num[6]+1;
                    break;
                case 'H':
                    num[7]=num[7]+1;
                    break;
                case 'I':
                    num[8]=num[8]+1;
                    break;
                case 'J':
                    num[9]=num[9]+1;
                    break;
                case 'K':
                    num[10]=num[10]+1;
                    break;
                case 'L':
                    num[11]=num[11]+1;
                    break;
                case 'M':
                    num[12]=num[12]+1;
                    break;
                case 'N':
                    num[13]=num[13]+1;
                    break;
                case 'O':
                    num[14]=num[14]+1;
                    break;
                case 'P':
                    num[15]=num[15]+1;
                    break;
                case 'Q':
                    num[16]=num[16]+1;
                    break;
                case 'R':
                    num[17]=num[17]+1;
                    break;
                case 'S':
                    num[18]=num[18]+1;
                    break;
                case 'T':
                    num[19]=num[19]+1;
                    break;
                case 'U':
                    num[20]=num[20]+1;
                    break;
                case 'V':
                    num[21]=num[21]+1;
                    break;
                case 'W':
                    num[22]=num[22]+1;
                    break;
                case 'X':
                    num[23]=num[23]+1;
                    break;
                case 'Y':
                    num[24]=num[24]+1;
                    break;
                case 'Z':
                    num[25]=num[25]+1;
                    break;

            }



        }
        for(int i=0;i<26;i++) {
            System.out.println(letter[i]+":"+num[i]);
        }
    }

}