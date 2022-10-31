import java.util.Map;
import java.util.function.IntBinaryOperator;

public class DoMath {
    public static  Map<String, IntBinaryOperator> calculate = Map.of(
            "-", (x, y) -> x - y,
            "+", (x, y) -> x + y,
            "/", (x, y) -> x / y,
            "*", (x, y) -> x * y);
}
