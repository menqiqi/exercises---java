package www.bit.java;

/**
 * 有10个人围成一圈，顺序排号。
 * 从第一个人开始报数（从1到3报数），凡报到3的人退出圈子，
 * 问最后留下的是原来第几号那位。
 */

public class practice1 {
    public static void main(String[] args) {
        int[] people = new int[10];
        //编号
        for(int i = 0; i < 10; i++){
            people[i] = i+1;
        }
        //报数标志
        int flag = 0;
        //退出人数
        int quitPeople = 0;
        //计数
        int i = 0;
        while(quitPeople < 9){
            if(people[i] != 0){
                //该编号的人还在圈中
                flag++;
            }
            if(flag == 3){
                flag = 0;
                people[i] = 0;
                quitPeople++;
            }
            i++;
            if(i == 10){
                //当报到最后一个人时，接下来从第一个人开始报
                i = 0;
            }
        }
        for(int j = 0; j < 10; j++){
            if(people[j] != 0){
                System.out.println(j+1);
            }
        }
    }
}
