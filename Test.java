package www.bit.java;

import java.util.Scanner;

interface Compute{
    int computer(int n, int m);
}

class Add implements Compute{
    public int computer(int n, int m){
        return n+m;
    }
}

class Sub implements Compute{
    public int computer(int n, int m){
        return n-m;
    }
}

class Mul implements Compute{
    public int computer(int n, int m){
        return n*m;
    }
}

class Div implements Compute{
    public int computer(int n, int m){
        return n/m;
    }
}

class UseCompute{
    public void useCom(Compute com, int one, int two){
        System.out.println(com.computer(one,two));
    }
}

public class Test {
    public static void main(String[] args) {
       UseCompute uc = new UseCompute();
       Add a = new Add();
       Sub b = new Sub();
       Mul c = new Mul();
       Div d = new Div();
       System.out.println("请输入数据：");
       Scanner scanner = new Scanner(System.in);
       int i = scanner.nextInt();
       int j = scanner.nextInt();
       System.out.print("和：");
       uc.useCom(a,i,j);
       System.out.print("差：");
       uc.useCom(b,i,j);
       System.out.print("积：");
       uc.useCom(c,i,j);
       System.out.print("商：");
       uc.useCom(d,i,j);
    }
}
