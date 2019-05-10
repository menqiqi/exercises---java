/**
 * You class are planning for a spring outing. N people are voting for a destination out of K candidate places.
 * The voting progress is below:
 * First the class vote for the first candidate place. If more than half of the class agreed on the place, the place is selected. The voting ends.
 * Otherwise they vote for the second candidate place. If more than half of the class agreed on the place, the place is selected. The voting ends.
 * Otherwise they vote for the third candidate place in the same way and go on.
 * If no place is selected at last there will be no spring outing and everybody stays at home.
 * Before the voting, the Chief Entertainment Officer did a survey, found out every one's preference which can be represented as a permutation of 0, 1, ... K. (0 is for staying at home.) For example, when K=3, preference "1, 0, 2, 3" means that the first place is his first choice, staying at home is the second choice, the second place is the third choice and the third place is the last choice.
 * The Chief Entertainment Officer sends the survey results to the class. So everybody knows the others' preferences. Everybody wants his more prefered place to be selected. And they are very smart, they always choose the optimal strategy in the voting progress to achieve his goal.
 * Can you predict which place will be selected?
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice289 {
    public static void main(String[] args) throws IOException {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(
                System.in));
        String str = stdin.readLine();
        while (str != null && str.length() > 0) {
            String[] ss = str.split(" ");
            int N = Integer.parseInt(ss[0]);
            int K = Integer.parseInt(ss[1]);
            int[][] favor = new int[N][K + 1];//favor[i][j]表示第i個人对第j个景点的喜欢程度，值越小表示越喜欢
            for (int i = 0; i < N; i++) {
                str = stdin.readLine();
                ss = str.split(" ");
                for (int j = 0; j < K + 1; j++) {
                    favor[i][Integer.parseInt(ss[j])] =j ;
                }
            }
            int votes=0;
            //从最后一轮投票开始往回找，因为到了后面没有别的选择了，每个人可以清楚自己是否投票，有点递归的思想
            int finalChoice=0;
            for(int i=K;i>=1;i--){
                votes=0;
                for(int j=0;j<N;j++){
                    //比较每一个人对当前方案和下一方案的喜欢程度，来决定是否投票
                    if(favor[j][i]<favor[j][finalChoice]){
                        votes++;
                    }
                }
                if(votes>N-votes){//投票超过一半，更新最终方案
                    finalChoice=i;
                }
            }
            if(finalChoice==0){
                System.out.println("otaku");
            }else{
                System.out.println(finalChoice);
            }
            str = stdin.readLine();
        }
    }
}
