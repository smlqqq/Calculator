import java.util.List;
import java.util.Scanner;
import java.util.function.IntFunction;
import java.util.function.ToIntFunction;
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        var number1 = sc.next(Numbers.ROMAN + Numbers.OR + Numbers.ARABIC);
        var operator = sc.next(Numbers.OP);
        var romanNums = number1.matches(Numbers.ROMAN);
        var number2 = sc.next(romanNums ? Numbers.ROMAN : Numbers.ARABIC) ;


        ToIntFunction<String> toInt = romanNums ? Main::romanToArabic : Integer::parseInt;
        IntFunction<String> toString = romanNums ? Main::arabicToRoman : Integer::toString;

        int result = DoMath.calculate.get(operator).applyAsInt(toInt.applyAsInt(number1), toInt.applyAsInt(number2));

        System.out.println(toString.apply(result));
    }
    static int romanToArabic(String number) {
        return 1 + List.of("I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X").indexOf(number);
    }

    static String arabicToRoman(int number) {
        return String.join("",
                number == 100 ? "C" : "",
                new String[]{"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"}[number % 100 / 10],
                new String[]{"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"}[number % 10]
        );
    }
}
