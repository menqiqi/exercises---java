/**
 * 工厂方法模式
 * 一个抽象产品，多个具体产品类，一个抽象工厂，多个具体工厂
 * 优点：降低代码的耦合度，将对象的生成交给子类来完成
 *      实现了OCP原则：每次增加子产品，都不需要修改原有代码，只要增加代码
 * 缺点：增加代码量，每个子产品都需要一个具体工厂类
 *      当增加其他产品的时候，需要修改工厂，违反了OCP原则
 */

interface Computer{
    void buyComputer();
}

class MacComputer implements  Computer{
    @Override
    public void buyComputer() {
        System.out.println("买一个Mac book");
    }
}

class SurfaceComputer implements Computer{
    @Override
    public void buyComputer() {
        System.out.println("买一个Surface book");
    }
}

interface Factory{
    Computer createComputer();
}

class CreateMacComputerFactory implements  Factory{
    @Override
    public Computer createComputer() {
        return new MacComputer();
    }
}

class CreateSurfaceComputerFactory implements Factory{

    @Override
    public Computer createComputer() {
        return new SurfaceComputer();
    }
}

public class Practice196 {

    public void buyComputer(Computer computer){
        computer.buyComputer();
    }

    public static void main(String[] args) {
        Practice196 p = new Practice196();
        Factory macFactory = new CreateMacComputerFactory();
        p.buyComputer(macFactory.createComputer());
    }
}
