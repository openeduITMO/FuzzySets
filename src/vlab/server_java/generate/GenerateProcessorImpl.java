package vlab.server_java.generate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import rlcp.generate.GeneratingResult;
import rlcp.server.processor.generate.GenerateProcessor;
import vlab.server_java.expressions.Operations;
import vlab.server_java.expressions.Utils;
import vlab.server_java.model.GenerateCodeResult;
import vlab.server_java.model.GenerateInstructionsResult;

import java.math.BigDecimal;

import static vlab.server_java.model.util.HtmlParamEscaper.escape_param;

public class GenerateProcessorImpl implements GenerateProcessor {

    @Override
    public GeneratingResult generate(String condition) {
        ObjectMapper mapper = new ObjectMapper();

        String text = "Ваш вариант загружен в установку";
        String code;
        String instructions = "";
        try {
            BigDecimal[] x_set = new BigDecimal[Utils.FUZZY_SET_LENGTH];
            BigDecimal[] y_set = new BigDecimal[Utils.FUZZY_SET_LENGTH];
            for (int i = 0; i < Utils.FUZZY_SET_LENGTH; i++) {
                x_set[i] = Utils.get_random();
                y_set[i] = Utils.get_random();
            }
            code = mapper.writeValueAsString(new GenerateCodeResult(x_set, y_set));

            BigDecimal[] not_x_expression = Operations.absolute_complement(x_set);
            BigDecimal[] not_y_expression = Operations.absolute_complement(y_set);
            BigDecimal[] or_expression = Operations.union(x_set, y_set);
            BigDecimal[] and_expression = Operations.intersection(x_set, y_set);
            BigDecimal[] not_x_or_y_expression = Operations.union(not_x_expression, y_set);
            BigDecimal[] not_x_and_y_expression = Operations.intersection(not_x_expression, y_set);
            BigDecimal[] x_or_not_y_expression = Operations.union(x_set, not_y_expression);
            BigDecimal[] x_and_not_y_expression = Operations.intersection(x_set, not_y_expression);
            BigDecimal[] not_x_or_not_y_expression = Operations.union(not_x_expression, not_y_expression);
            BigDecimal[] not_x_and_not_y_expression = Operations.intersection(not_x_expression, not_y_expression);
            BigDecimal[] x0_expression = Operations.round(x_set);
            BigDecimal[] y0_expression = Operations.round(y_set);
            BigDecimal[] linear_x_y_expression = Operations.linear_distance_elements(x_set, y_set);
            BigDecimal[] euclid_x_y_expression = Operations.euclid_distance_elements(x_set, y_set);
            BigDecimal[] linear_x_x0_expression = Operations.linear_distance_elements(x_set, x0_expression);
            BigDecimal[] linear_y_y0_expression = Operations.linear_distance_elements(y_set, y0_expression);
            BigDecimal x_y_hemming_index = Operations.linear_distance(x_set, y_set);
            BigDecimal x_y_euclid_index = Operations.euclid_distance(x_set, y_set);
            BigDecimal x_x0_measure = Operations.linear_distance(x_set, x0_expression);
            BigDecimal y_y0_measure = Operations.linear_distance(y_set, y0_expression);
            BigDecimal x_x0_index = Operations.from_linear_measure_to_linear_index(x_x0_measure, Utils.not_zero(x_set));
            BigDecimal y_y0_index = Operations.from_linear_measure_to_linear_index(y_y0_measure, Utils.not_zero(y_set));

            instructions = mapper.writeValueAsString(
                    new GenerateInstructionsResult(
                            not_x_expression,
                            not_y_expression,
                            or_expression,
                            and_expression,
                            not_x_or_y_expression,
                            not_x_and_y_expression,
                            x_or_not_y_expression,
                            x_and_not_y_expression,
                            not_x_or_not_y_expression,
                            not_x_and_not_y_expression,
                            x0_expression,
                            y0_expression,
                            linear_x_y_expression,
                            euclid_x_y_expression,
                            linear_x_x0_expression,
                            linear_y_y0_expression,
                            x_y_hemming_index,
                            x_y_euclid_index,
                            x_x0_measure,
                            y_y0_measure,
                            x_x0_index,
                            y_y0_index
                    )
            );
        } catch (JsonProcessingException e) {
            code = "Failed, " + e.getOriginalMessage();
        }
        return new GeneratingResult(text, escape_param(code), escape_param(instructions));
    }
}
