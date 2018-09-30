package vlab.server_java.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.Objects;

import static vlab.server_java.model.util.HtmlParamEscaper.shrink;

public class GenerateCodeResult {

    private final BigDecimal[] x_set;
    private final BigDecimal[] y_set;

    @JsonCreator
    public GenerateCodeResult(
            @JsonProperty("x_set") BigDecimal[] x_set,
            @JsonProperty("y_set") BigDecimal[] y_set
    ) {
        Objects.requireNonNull(x_set);
        Objects.requireNonNull(y_set);

        this.x_set = x_set;
        for (int i = 0; i < x_set.length; i++) {
            this.x_set[i] = shrink(x_set[i]);
        }

        this.y_set = y_set;
        for (int i = 0; i < y_set.length; i++) {
            this.y_set[i] = shrink(y_set[i]);
        }
    }

    public BigDecimal[] getX_set() {
        return x_set;
    }

    public BigDecimal[] getY_set() {
        return y_set;
    }
}
