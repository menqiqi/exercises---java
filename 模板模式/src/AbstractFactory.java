import com.sun.xml.internal.bind.v2.model.core.ID;

/**
 * 抽象工厂模式：创建一系列相关相互依赖的接口，而无需指定具体的类
 * 多个抽象产品，多个具体产品，一个抽象工厂，多个具体工厂
 *
 * 优：增加新的产品族很方便，符合OCP原则
 *     具体类的实现与客户端分离
 * 缺：增加新的产品等级结构不方便，违反OCP原则
 */

interface IUser{
    void insert();
    void getId();
}

interface IDepartment{
    void insert();
    void getDepartmentId();
}

class SQLServerUser implements IUser{

    @Override
    public void insert() {
        System.out.println("insert User into SQLServer");
    }

    @Override
    public void getId() {
        System.out.println("get UserId in SQLServer");
    }
}

class AccessUser implements IUser{

    @Override
    public void insert() {
        System.out.println("insert User into Access");
    }

    @Override
    public void getId() {
        System.out.println("get UserId in Access");
    }
}

class SQLServerDepartment implements IDepartment{

    @Override
    public void insert() {
        System.out.println("insert department into SQLServer");
    }

    @Override
    public void getDepartmentId() {
        System.out.println("get DepartmentId int SQLServer");
    }
}

class AaccessDepartment implements IDepartment{

    @Override
    public void insert() {
        System.out.println("insert department into Access");
    }

    @Override
    public void getDepartmentId() {
        System.out.println("get DepartmentId int Access");
    }
}

interface IFactory{
    IUser createUser();
    IDepartment createDepartment();
}

class SQLFactory implements IFactory{

    @Override
    public IUser createUser() {
        return new SQLServerUser();
    }

    @Override
    public IDepartment createDepartment() {
        return new SQLServerDepartment();
    }
}

class AccessFactory implements IFactory{

    @Override
    public IUser createUser() {
        return new AccessUser();
    }

    @Override
    public IDepartment createDepartment() {
        return new AaccessDepartment();
    }
}

public class AbstractFactory {
    public static void main(String[] args) {
        IFactory factory = new SQLFactory();
        IUser user = factory.createUser();
        IDepartment department = factory.createDepartment();
        user.insert();
        user.getId();
        department.insert();
        department.getDepartmentId();
    }
}
