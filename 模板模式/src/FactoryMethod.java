/**
 * 工厂方法模式
 * 一个抽象产品类，多个具体产品类，一个抽象工厂类，多个具体工厂类
 *
 * 优：降低代码耦合度，把对象的生成交给子类完成
 *     添加产品不需要修改代码
 * 缺：增加代码量，每增加一个产品都要增加一个相应的工厂类
 *     如果要添加其他产品族，就需要修改代码，违反OCP原则
 */

interface IPhone{
    void buyPhone();
}

class MI implements IPhone{

    @Override
    public void buyPhone() {
        System.out.println("买一个小米手机");
    }
}

class HUAWEI implements IPhone{

    @Override
    public void buyPhone() {
        System.out.println("买一个华为手机");
    }
}

interface PhoneFactory{
    IPhone createPhone();
}

class MIFactory implements PhoneFactory{

    @Override
    public IPhone createPhone() {
        return new MI();
    }
}

class HUAWEIFactory implements PhoneFactory{

    @Override
    public IPhone createPhone() {
        return new HUAWEI();
    }
}

public class FactoryMethod {
    public static void main(String[] args) {
        MIFactory miFactory = new MIFactory();
        miFactory.createPhone().buyPhone();
    }
}
