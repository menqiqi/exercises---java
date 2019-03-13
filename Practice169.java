import java.util.*;

public class Practice169 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int i = Integer.parseInt(in.nextLine());
        List<String> set = new ArrayList<>();
        //根据方程式得出7x+4y = 100
        int x = 100;
        int numF = 100/7;
        int numM = 0;
        int tmp = x % 7;
        while (true){
            while (tmp > 0){
                if (tmp > 4){
                    numM++;
                    tmp = tmp-4;
                }else if (tmp < 4){
                    numF--;
                    tmp = tmp+7;
                }else {
                    numM++;
                    int numCh = 100-numF-numM;
                    if (numF>=0 && numM>=0 && numCh >=0){

                        set.add(numF+" "+numM+" "+numCh);
                    }
                    break;
                }
            }
            numF--;
            tmp = 7;
            if (numF == -1)
                break;
        }
        for (int k = set.size()-1; k >= 0; k--){
            String str = set.get(k);
            String[] n = str.split(" ");
            int father = Integer.parseInt(n[0]);
            int mather = Integer.parseInt(n[1]);
            int childer = Integer.parseInt(n[2]);
            System.out.println(father+" "+mather+" "+childer);
        }

    }
}
