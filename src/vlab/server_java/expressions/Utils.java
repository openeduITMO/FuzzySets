package vlab.server_java.expressions;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Utils {

    public static final int FUZZY_SET_LENGTH = 8;

    public static BigDecimal get_random() {
        double value = Math.random();
        return new BigDecimal(value).setScale(1, RoundingMode.HALF_UP);
    }

    public static BigDecimal not_zero(BigDecimal[] operand) {
        BigDecimal result = BigDecimal.ZERO;
        for (BigDecimal o : operand) {
            if (o.compareTo(BigDecimal.ZERO) > 0) {
                result = result.add(BigDecimal.ONE);
            }
        }
        return result;
    }
}
