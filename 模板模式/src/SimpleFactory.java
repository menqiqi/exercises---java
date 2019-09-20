import javax.swing.plaf.ComponentUI;
import java.util.Scanner;

/**
 * 简单工厂模式
 * 一个抽象产品类，n个具体产品类，一个工厂类
 * 优点：实例化交给工厂，易于解耦
 * 缺点：添加产品需要修改工厂，违反OCP原则
 */


interface IComputer{
    void buyComputer();
}

class SurfaceBookComputer implements IComputer{

    @Override
    public void buyComputer() {
        System.out.println("buy surfaceBookComputer");
    }
}

class MacBookComputer implements IComputer{

    @Override
    public void buyComputer() {
        System.out.println("buy macBookCpmputer");
    }
}

class Factory{
    public static IComputer createComputer(String type){
        IComputer computer = null;
        if (type.equals("surface")){
            return new SurfaceBookComputer();
        }else if (type.equals("mac")){
            return new MacBookComputer();
        }
        return computer;
    }
}



public class SimpleFactory {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String type = in.nextLine();
        Factory.createComputer(type).buyComputer();

    }
}
