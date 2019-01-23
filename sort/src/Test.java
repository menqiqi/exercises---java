public class Test {
    public static void main(String[] args) {
        int[] arr = {21,25,49,25,16,8,10,5};
        InsertSort inSort = new InsertSort();
//        inSort.insertSort1(arr);
        inSort.insertSort2(arr);
        Print pri = new Print();
        pri.print(arr);
    }
}
