/**
 * 代理模式
 * 两个子类共同实现一个接口，其中一个子类负责真实业务的实现，另一个子类辅助真实业务的操作
 */

interface ISubject{
    void buyComputer();
}

class RealSubject implements ISubject{


    @Override
    public void buyComputer() {
        System.out.println("买电脑");
    }
}

class ProxSubject implements ISubject{
    private ISubject subject;  //真实的操作业务
    public ProxSubject(ISubject subject) {
        this.subject = subject;
    }

    public void before(){
        System.out.println("生产电脑");
    }

    public void after(){
        System.out.println("电脑售后");
    }

    @Override
    public void buyComputer() {
        before();
        subject.buyComputer();
        after();
    }
}

public class AgencyModel {
    public static void main(String[] args) {
        ProxSubject subject = new ProxSubject(new RealSubject());
        subject.buyComputer();
    }
}
