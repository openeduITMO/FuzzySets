package vlab.server_java.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import vlab.server_java.expressions.Utils;

import java.math.BigDecimal;
import java.util.Objects;

import static vlab.server_java.model.util.HtmlParamEscaper.shrink;

public class GenerateInstructionsResult {
    private final BigDecimal[] not_x_expression;
    private final BigDecimal[] not_y_expression;
    private final BigDecimal[] x_or_y_expression;
    private final BigDecimal[] x_and_y_expression;
    private final BigDecimal[] not_x_or_y_expression;
    private final BigDecimal[] not_x_and_y_expression;
    private final BigDecimal[] x_or_not_y_expression;
    private final BigDecimal[] x_and_not_y_expression;
    private final BigDecimal[] not_x_or_not_y_expression;
    private final BigDecimal[] not_x_and_not_y_expression;
    private final BigDecimal[] x0_expression;
    private final BigDecimal[] y0_expression;
    private final BigDecimal[] linear_x_y_expression;
    private final BigDecimal[] euclid_x_y_expression;
    private final BigDecimal[] linear_x_x0_expression;
    private final BigDecimal[] linear_y_y0_expression;
    private final BigDecimal x_y_hemming_index;
    private final BigDecimal x_y_euclid_index;
    private final BigDecimal x_x0_measure;
    private final BigDecimal y_y0_measure;
    private final BigDecimal x_x0_index;
    private final BigDecimal y_y0_index;

    @JsonCreator
    public GenerateInstructionsResult(
            @JsonProperty("not_x_expression") BigDecimal[] not_x_expression,
            @JsonProperty("not_y_expression") BigDecimal[] not_y_expression,
            @JsonProperty("x_or_y_expression") BigDecimal[] x_or_y_expression,
            @JsonProperty("x_and_y_expression") BigDecimal[] x_and_y_expression,
            @JsonProperty("not_x_or_y_expression") BigDecimal[] not_x_or_y_expression,
            @JsonProperty("not_x_and_y_expression") BigDecimal[] not_x_and_y_expression,
            @JsonProperty("x_or_not_y_expression") BigDecimal[] x_or_not_y_expression,
            @JsonProperty("x_and_not_y_expression") BigDecimal[] x_and_not_y_expression,
            @JsonProperty("not_x_or_not_y_expression") BigDecimal[] not_x_or_not_y_expression,
            @JsonProperty("not_x_and_not_y_expression") BigDecimal[] not_x_and_not_y_expression,
            @JsonProperty("x0_expression") BigDecimal[] x0_expression,
            @JsonProperty("y0_expression") BigDecimal[] y0_expression,
            @JsonProperty("linear_x_y_expression") BigDecimal[] linear_x_y_expression,
            @JsonProperty("euclid_x_y_expression") BigDecimal[] euclid_x_y_expression,
            @JsonProperty("linear_x_x0_expression") BigDecimal[] linear_x_x0_expression,
            @JsonProperty("linear_y_y0_expression") BigDecimal[] linear_y_y0_expression,
            @JsonProperty("x_y_hemming_index") BigDecimal x_y_hemming_index,
            @JsonProperty("x_y_euclid_index") BigDecimal x_y_euclid_index,
            @JsonProperty("x_x0_measure") BigDecimal x_x0_measure,
            @JsonProperty("y_y0_measure") BigDecimal y_y0_measure,
            @JsonProperty("x_x0_index") BigDecimal x_x0_index,
            @JsonProperty("y_y0_index") BigDecimal y_y0_index
    ) {
        Objects.requireNonNull(not_x_expression);
        Objects.requireNonNull(not_y_expression);
        Objects.requireNonNull(x_or_y_expression);
        Objects.requireNonNull(x_and_y_expression);
        Objects.requireNonNull(not_x_or_y_expression);
        Objects.requireNonNull(not_x_and_y_expression);
        Objects.requireNonNull(x_or_not_y_expression);
        Objects.requireNonNull(x_and_not_y_expression);
        Objects.requireNonNull(not_x_or_not_y_expression);
        Objects.requireNonNull(not_x_and_not_y_expression);
        Objects.requireNonNull(x0_expression);
        Objects.requireNonNull(y0_expression);
        Objects.requireNonNull(linear_x_y_expression);
        Objects.requireNonNull(euclid_x_y_expression);
        Objects.requireNonNull(linear_x_x0_expression);
        Objects.requireNonNull(linear_y_y0_expression);

        if (not_x_expression.length != Utils.FUZZY_SET_LENGTH) {
            throw new IllegalArgumentException("not_x_expression should have " + Utils.FUZZY_SET_LENGTH + " elements but there was " + not_x_expression.length);
        }
        if (not_y_expression.length != Utils.FUZZY_SET_LENGTH) {
            throw new IllegalArgumentException("not_y_expression should have " + Utils.FUZZY_SET_LENGTH + " elements but there was " + not_y_expression.length);
        }
        if (x_or_y_expression.length != Utils.FUZZY_SET_LENGTH) {
            throw new IllegalArgumentException("x_or_y_expression should have " + Utils.FUZZY_SET_LENGTH + " elements but there was " + x_or_y_expression.length);
        }
        if (x_and_y_expression.length != Utils.FUZZY_SET_LENGTH) {
            throw new IllegalArgumentException("x_and_y_expression should have " + Utils.FUZZY_SET_LENGTH + " elements but there was " + x_and_y_expression.length);
        }
        if (not_x_or_y_expression.length != Utils.FUZZY_SET_LENGTH) {
            throw new IllegalArgumentException("not_x_or_y_expression should have " + Utils.FUZZY_SET_LENGTH + " elements but there was " + not_x_or_y_expression.length);
        }
        if (not_x_and_y_expression.length != Utils.FUZZY_SET_LENGTH) {
            throw new IllegalArgumentException("not_x_and_y_expression should have " + Utils.FUZZY_SET_LENGTH + " elements but there was " + not_x_and_y_expression.length);
        }
        if (x_or_not_y_expression.length != Utils.FUZZY_SET_LENGTH) {
            throw new IllegalArgumentException("x_or_not_y_expression should have " + Utils.FUZZY_SET_LENGTH + " elements but there was " + x_or_not_y_expression.length);
        }
        if (x_and_not_y_expression.length != Utils.FUZZY_SET_LENGTH) {
            throw new IllegalArgumentException("x_and_not_y_expression should have " + Utils.FUZZY_SET_LENGTH + " elements but there was " + x_and_not_y_expression.length);
        }
        if (not_x_or_not_y_expression.length != Utils.FUZZY_SET_LENGTH) {
            throw new IllegalArgumentException("not_x_or_not_y_expression should have " + Utils.FUZZY_SET_LENGTH + " elements but there was " + not_x_or_not_y_expression.length);
        }
        if (not_x_and_not_y_expression.length != Utils.FUZZY_SET_LENGTH) {
            throw new IllegalArgumentException("not_x_and_not_y_expression should have " + Utils.FUZZY_SET_LENGTH + " elements but there was " + not_x_and_not_y_expression.length);
        }
        if (x0_expression.length != Utils.FUZZY_SET_LENGTH) {
            throw new IllegalArgumentException("x0_expression should have " + Utils.FUZZY_SET_LENGTH + " elements but there was " + x0_expression.length);
        }
        if (y0_expression.length != Utils.FUZZY_SET_LENGTH) {
            throw new IllegalArgumentException("y0_expression should have " + Utils.FUZZY_SET_LENGTH + " elements but there was " + y0_expression.length);
        }
        if (linear_x_y_expression.length != Utils.FUZZY_SET_LENGTH) {
            throw new IllegalArgumentException("linear_x_y_expression should have " + Utils.FUZZY_SET_LENGTH + " elements but there was " + linear_x_y_expression.length);
        }
        if (euclid_x_y_expression.length != Utils.FUZZY_SET_LENGTH) {
            throw new IllegalArgumentException("euclid_x_y_expression should have " + Utils.FUZZY_SET_LENGTH + " elements but there was " + euclid_x_y_expression.length);
        }
        if (linear_x_x0_expression.length != Utils.FUZZY_SET_LENGTH) {
            throw new IllegalArgumentException("linear_x_x0_expression should have " + Utils.FUZZY_SET_LENGTH + " elements but there was " + linear_x_x0_expression.length);
        }
        if (linear_y_y0_expression.length != Utils.FUZZY_SET_LENGTH) {
            throw new IllegalArgumentException("linear_y_y0_expression should have " + Utils.FUZZY_SET_LENGTH + " elements but there was " + linear_y_y0_expression.length);
        }

        this.not_x_expression = not_x_expression;
        for (int i = 0; i < not_x_expression.length; i++) {
            this.not_x_expression[i] = shrink(not_x_expression[i]);
        }
        this.not_y_expression = not_y_expression;
        for (int i = 0; i < not_y_expression.length; i++) {
            this.not_y_expression[i] = shrink(not_y_expression[i]);
        }
        this.x_or_y_expression = x_or_y_expression;
        for (int i = 0; i < x_or_y_expression.length; i++) {
            this.x_or_y_expression[i] = shrink(x_or_y_expression[i]);
        }
        this.x_and_y_expression = x_and_y_expression;
        for (int i = 0; i < x_and_y_expression.length; i++) {
            this.x_and_y_expression[i] = shrink(x_and_y_expression[i]);
        }
        this.not_x_or_y_expression = not_x_or_y_expression;
        for (int i = 0; i < not_x_or_y_expression.length; i++) {
            this.not_x_or_y_expression[i] = shrink(not_x_or_y_expression[i]);
        }
        this.not_x_and_y_expression = not_x_and_y_expression;
        for (int i = 0; i < not_x_and_y_expression.length; i++) {
            this.not_x_and_y_expression[i] = shrink(not_x_and_y_expression[i]);
        }
        this.x_or_not_y_expression = x_or_not_y_expression;
        for (int i = 0; i < x_or_not_y_expression.length; i++) {
            this.x_or_not_y_expression[i] = shrink(x_or_not_y_expression[i]);
        }
        this.x_and_not_y_expression = x_and_not_y_expression;
        for (int i = 0; i < x_and_not_y_expression.length; i++) {
            this.x_and_not_y_expression[i] = shrink(x_and_not_y_expression[i]);
        }
        this.not_x_or_not_y_expression = not_x_or_not_y_expression;
        for (int i = 0; i < not_x_or_not_y_expression.length; i++) {
            this.not_x_or_not_y_expression[i] = shrink(not_x_or_not_y_expression[i]);
        }
        this.not_x_and_not_y_expression = not_x_and_not_y_expression;
        for (int i = 0; i < not_x_and_not_y_expression.length; i++) {
            this.not_x_and_not_y_expression[i] = shrink(not_x_and_not_y_expression[i]);
        }
        this.x0_expression = x0_expression;
        for (int i = 0; i < x0_expression.length; i++) {
            this.x0_expression[i] = shrink(x0_expression[i]);
        }
        this.y0_expression = y0_expression;
        for (int i = 0; i < y0_expression.length; i++) {
            this.y0_expression[i] = shrink(y0_expression[i]);
        }
        this.linear_x_y_expression = linear_x_y_expression;
        for (int i = 0; i < linear_x_y_expression.length; i++) {
            this.linear_x_y_expression[i] = shrink(linear_x_y_expression[i]);
        }
        this.euclid_x_y_expression = euclid_x_y_expression;
        for (int i = 0; i < euclid_x_y_expression.length; i++) {
            this.euclid_x_y_expression[i] = shrink(euclid_x_y_expression[i]);
        }
        this.linear_x_x0_expression = linear_x_x0_expression;
        for (int i = 0; i < linear_x_x0_expression.length; i++) {
            this.linear_x_x0_expression[i] = shrink(linear_x_x0_expression[i]);
        }
        this.linear_y_y0_expression = linear_y_y0_expression;
        for (int i = 0; i < linear_y_y0_expression.length; i++) {
            this.linear_y_y0_expression[i] = shrink(linear_y_y0_expression[i]);
        }

        this.x_y_hemming_index = shrink(x_y_hemming_index);
        this.x_y_euclid_index = shrink(x_y_euclid_index);
        this.x_x0_measure = shrink(x_x0_measure);
        this.y_y0_measure = shrink(y_y0_measure);
        this.x_x0_index = shrink(x_x0_index);
        this.y_y0_index = shrink(y_y0_index);
    }

    @JsonProperty("not_x_expression")
    public BigDecimal[] get_not_x_expression() {
        return not_x_expression;
    }

    @JsonProperty("not_y_expression")
    public BigDecimal[] get_not_y_expression() {
        return not_y_expression;
    }

    @JsonProperty("x_or_y_expression")
    public BigDecimal[] get_x_or_y_expression() {
        return x_or_y_expression;
    }

    @JsonProperty("x_and_y_expression")
    public BigDecimal[] get_x_and_y_expression() {
        return x_and_y_expression;
    }

    @JsonProperty("not_x_or_y_expression")
    public BigDecimal[] get_not_x_or_y_expression() {
        return not_x_or_y_expression;
    }

    @JsonProperty("not_x_and_y_expression")
    public BigDecimal[] get_not_x_and_y_expression() {
        return not_x_and_y_expression;
    }

    @JsonProperty("x_or_not_y_expression")
    public BigDecimal[] get_x_or_not_y_expression() {
        return x_or_not_y_expression;
    }

    @JsonProperty("x_and_not_y_expression")
    public BigDecimal[] get_x_and_not_y_expression() {
        return x_and_not_y_expression;
    }

    @JsonProperty("not_x_or_not_y_expression")
    public BigDecimal[] get_not_x_or_not_y_expression() {
        return not_x_or_not_y_expression;
    }

    @JsonProperty("not_x_and_not_y_expression")
    public BigDecimal[] get_not_x_and_not_y_expression() {
        return not_x_and_not_y_expression;
    }

    @JsonProperty("x0_expression")
    public BigDecimal[] get_x0_expression() {
        return x0_expression;
    }

    @JsonProperty("y0_expression")
    public BigDecimal[] get_y0_expression() {
        return y0_expression;
    }

    @JsonProperty("linear_x_y_expression")
    public BigDecimal[] get_linear_x_y_expression() {
        return linear_x_y_expression;
    }

    @JsonProperty("euclid_x_y_expression")
    public BigDecimal[] get_euclid_x_y_expression() {
        return euclid_x_y_expression;
    }

    @JsonProperty("linear_x_x0_expression")
    public BigDecimal[] get_linear_x_x0_expression() {
        return linear_x_x0_expression;
    }

    @JsonProperty("linear_y_y0_expression")
    public BigDecimal[] get_linear_y_y0_expression() {
        return linear_y_y0_expression;
    }

    @JsonProperty("x_y_hemming_index")
    public BigDecimal get_x_y_hemming_index() {
        return x_y_hemming_index;
    }

    @JsonProperty("x_y_euclid_index")
    public BigDecimal get_x_y_euclid_index() {
        return x_y_euclid_index;
    }

    @JsonProperty("x_x0_measure")
    public BigDecimal get_x_x0_measure() {
        return x_x0_measure;
    }

    @JsonProperty("y_y0_measure")
    public BigDecimal get_y_y0_measure() {
        return y_y0_measure;
    }

    @JsonProperty("x_x0_index")
    public BigDecimal get_x_x0_index() {
        return x_x0_index;
    }

    @JsonProperty("y_y0_index")
    public BigDecimal get_y_y0_index() {
        return y_y0_index;
    }
}
