public class Test {
    public static void main(String[] args) throws Exception {
        String value = "emp.name:yuisama|emp.job:java Coder";
        EmpAction empAction = new EmpAction();
        empAction.setValue(value);
        System.out.println(empAction.getEmp());
    }
}
