/**
 * 抽象工厂类
 * 多个抽象产品类，多个具体产品类，一个抽象工厂类，多个具体工厂类
 * 优点：代码解耦
 *      实现多个产品族
 *      满足OCP原则
 *      抽象工厂模式可以定义不止一个接口，一个工厂也可以不止生产一个产品，对于复杂对象的生产相对灵活，易扩展
 * 缺点：扩展产品族相当麻烦，会修改工厂，违反了OCP原则
 *      代码量多，比较笨重
 */

interface Computer{
    void buyComputer();
}

class MacComputer implements Computer{
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

interface OperatingSystem{
    void operatingSystem();
}

class AppleSystem implements OperatingSystem {

    @Override
    public void operatingSystem() {
        System.out.println("苹果系统");
    }
}

class WindowsSystem implements OperatingSystem{
    @Override
    public void operatingSystem() {
        System.out.println("Windows系统");
    }
}

interface Factory{
    Computer createComputer();
    OperatingSystem useSystem();
}

class AppleFactory implements Factory{
    @Override
    public Computer createComputer() {
        return new MacComputer();
    }

    @Override
    public OperatingSystem useSystem() {
        return new AppleSystem();
    }
}

class WindowsFactory implements Factory{

    @Override
    public Computer createComputer() {
        return new SurfaceComputer();
    }

    @Override
    public OperatingSystem useSystem() {
        return new WindowsSystem();
    }
}

public class Practice197 {
    public void buyComputer(Computer computer){
        computer.buyComputer();
    }

    public void useSystem(OperatingSystem system){
        system.operatingSystem();
    }

    public static void main(String[] args) {
        Practice197 p = new Practice197();
        Factory factory = new AppleFactory();
        Computer computer = factory.createComputer();
        OperatingSystem system = factory.useSystem();
        p.buyComputer(computer);
        p.useSystem(system);
    }
}
