package vlab.server_java.expressions;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class Operations {

    public static BigDecimal[] union(BigDecimal[] first, BigDecimal[] second) {
        BigDecimal[] result = new BigDecimal[Utils.FUZZY_SET_LENGTH];
        for (int index = 0; index < result.length; index++) {
            result[index] = first[index].max(second[index]);
        }
        return result;
    }

    public static BigDecimal[] intersection(BigDecimal[] first, BigDecimal[] second) {
        BigDecimal[] result = new BigDecimal[Utils.FUZZY_SET_LENGTH];
        for (int index = 0; index < result.length; index++) {
            result[index] = first[index].min(second[index]);
        }
        return result;
    }

    public static BigDecimal[] absolute_complement(BigDecimal[] operand) {
        BigDecimal[] result = new BigDecimal[Utils.FUZZY_SET_LENGTH];
        for (int index = 0; index < result.length; index++) {
            result[index] = BigDecimal.ONE.subtract(operand[index]);
        }
        return result;
    }

    public static BigDecimal[] round(BigDecimal[] operand) {
        BigDecimal[] result = new BigDecimal[Utils.FUZZY_SET_LENGTH];
        for (int index = 0; index < result.length; index++) {
            result[index] = operand[index].setScale(0, RoundingMode.HALF_DOWN);
        }
        return result;
    }

    public static BigDecimal[] linear_distance_elements(BigDecimal[] first, BigDecimal[] second) {
        BigDecimal[] result = new BigDecimal[Utils.FUZZY_SET_LENGTH];
        for (int index = 0; index < result.length; index++) {
            result[index] = first[index].subtract(second[index]).abs();
        }
        return result;
    }

    public static BigDecimal[] euclid_distance_elements(BigDecimal[] first, BigDecimal[] second) {
        BigDecimal[] result = linear_distance_elements(first, second);
        for (int index = 0; index < result.length; index++) {
            result[index] = result[index].pow(2);
        }
        return result;
    }

    public static BigDecimal linear_distance(BigDecimal[] first, BigDecimal[] second) {
        BigDecimal result = BigDecimal.ZERO;
        BigDecimal[] sums = linear_distance_elements(first, second);
        for (BigDecimal s : sums) {
            result = result.add(s);
        }
        return result;
    }

    public static BigDecimal euclid_distance(BigDecimal[] first, BigDecimal[] second) {
        BigDecimal result = BigDecimal.ZERO;
        BigDecimal[] sums = euclid_distance_elements(first, second);
        for (BigDecimal s : sums) {
            result = result.add(s);
        }
        result = sqrt_big_decimal(result);
        return result;
    }

    public static BigDecimal from_linear_measure_to_linear_index(BigDecimal measure, BigDecimal elementsAmount) {
        if (elementsAmount.compareTo(BigDecimal.ZERO) > 0) {
            return measure.divide(elementsAmount, 2);
        } else {
            return BigDecimal.ZERO;
        }
    }

    public static BigDecimal sqrt_big_decimal(BigDecimal value) {
        BigDecimal x = new BigDecimal(Math.sqrt(value.doubleValue()));
        return x.add(new BigDecimal(value.subtract(x.multiply(x)).doubleValue() / (x.doubleValue() * 2.0)));
    }
}
