/**
 * 题目描述：
 * 打印所有不超过n(n<256)的，其平方具有对称性质的数。
 * 如11*11=121
 * 输入：
 * 无任何输入数据
 * 输出：
 * 输出具有题目要求的性质的数。如果输出数据不止一组，各组数据之间以回车隔开。
 */
public class Practice234 {
    public static boolean isSquares(int value) {
        if (value < 0) {
            return false;
        }
        double sqrtValue = Math.sqrt(value * 1.0);
        int sqrtSimiValue = (int) sqrtValue;
        if ((sqrtSimiValue * sqrtSimiValue) == value) {
            return true;
        } else {
            return false;
        }
    }
}

/*public static boolean isSquares2(int value) {
        if (value < 0) {
        return false;
        }

        int item = value / 2;
        for (int index = item; index >= 0; index--) {
        if (index * index == value) {
        return true;
        }
        }
        return false;

        }*/