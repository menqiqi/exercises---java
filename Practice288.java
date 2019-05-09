/**
 * 按照手机键盘输入字母的方式，计算所花费的时间 如：a,b,c都在“1”键上，输入a只需要按一次，输入c需要连续按三次。
 * 如果连续两个字符不在同一个按键上，则可直接按，如：ad需要按两下，kz需要按6下 如果连续两字符在同一个按键上，则两个按键之间需要等一段时间，
 * 如ac，在按了a之后，需要等一会儿才能按c。 现在假设每按一次需要花费一个时间段，等待时间需要花费两个时间段。
 * 现在给出一串字符，需要计算出它所需要花费的时间。
 */

import java.util.Scanner;

public class Practice288 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String string = scanner.nextLine();
            char[] ch = string.toCharArray();
            int number = 0, count = 0, number2 = 0;
            for (int i = 0; i < ch.length; i++) {
                number = ch[i] - 97;
                if (i == ch.length - 1) {
                    number2 = 100;
                } else {
                    number2 = ch[i + 1] - 97;
                }
                if (number < 15) {
                    if (Math.abs(number2 - number) < 3 && (number / 3 - number2 / 3 == 0)) {
                        count += 2;
                    }
                    number = number % 3 + 1;
                } else if (number < 19) {
                    if (number2 < 19 && number2 > 14) {
                        count += 2;
                    }
                    number = number - 14;
                } else if (number < 22) {
                    if (number2 < 22 && number2 > 18) {
                        count += 2;
                    }
                    number = number - 18;
                } else {
                    if (number2 < 26 && number2 > 21) {
                        count += 2;
                    }
                    number = number - 21;
                }
                count += number;
            }
            System.out.println(count);
        }
    }
}
