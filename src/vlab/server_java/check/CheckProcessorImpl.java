package vlab.server_java.check;

import com.fasterxml.jackson.databind.ObjectMapper;
import rlcp.check.ConditionForChecking;
import rlcp.generate.GeneratingResult;
import rlcp.server.processor.check.PreCheckProcessor.PreCheckResult;
import rlcp.server.processor.check.PreCheckResultAwareCheckProcessor;
import vlab.server_java.expressions.Utils;
import vlab.server_java.model.GenerateInstructionsResult;

import java.math.BigDecimal;

import static vlab.server_java.model.util.HtmlParamEscaper.prepare_input_json_string;

public class CheckProcessorImpl implements PreCheckResultAwareCheckProcessor<String> {
    @Override
    public CheckingSingleConditionResult checkSingleCondition(ConditionForChecking condition, String instructions, GeneratingResult generatingResult) throws Exception {
        BigDecimal points = BigDecimal.ONE;
        String comment = "";
        try {
            instructions = prepare_input_json_string(instructions);
            generatingResult = new GeneratingResult(
                    generatingResult.getText(),
                    prepare_input_json_string(generatingResult.getCode()),
                    prepare_input_json_string(generatingResult.getInstructions())
            );
            ObjectMapper mapper = new ObjectMapper();
            GenerateInstructionsResult checkTask = mapper.readValue(instructions, GenerateInstructionsResult.class);
            GenerateInstructionsResult varInstr = mapper.readValue(generatingResult.getInstructions(), GenerateInstructionsResult.class);

            BigDecimal[] not_x_expression_task = checkTask.get_not_x_expression();
            BigDecimal[] not_x_expression_instr = varInstr.get_not_x_expression();
            for (int index = 0; index < Utils.FUZZY_SET_LENGTH; index++) {
                if (!(not_x_expression_task[index].compareTo(not_x_expression_instr[index]) == 0)) {
                    points = points.subtract(new BigDecimal("0.04375"));
                    String task_answer = "";
                    String instr_answer = "";
                    for (int task_index = 0; task_index < Utils.FUZZY_SET_LENGTH; task_index++) {
                        task_answer += not_x_expression_task[task_index] + " ";
                        instr_answer += not_x_expression_instr[task_index] + " ";
                    }
                    comment += "Ваш ответ: not_x = [ " + task_answer + "], правильный ответ: not_x = [ " + instr_answer + "]. ";
                    break;
                }
            }

            BigDecimal[] not_y_expression_task = checkTask.get_not_y_expression();
            BigDecimal[] not_y_expression_instr = varInstr.get_not_y_expression();
            for (int index = 0; index < Utils.FUZZY_SET_LENGTH; index++) {
                if (!(not_y_expression_task[index].compareTo(not_y_expression_instr[index]) == 0)) {
                    points = points.subtract(new BigDecimal("0.04375"));
                    String task_answer = "";
                    String instr_answer = "";
                    for (int task_index = 0; task_index < Utils.FUZZY_SET_LENGTH; task_index++) {
                        task_answer += not_y_expression_task[task_index] + " ";
                        instr_answer += not_y_expression_instr[task_index] + " ";
                    }
                    comment += "Ваш ответ: not_y = [ " + task_answer + "], правильный ответ: not_y = [ " + instr_answer + "]. ";
                    break;
                }
            }

            BigDecimal[] x_or_y_expression_task = checkTask.get_x_or_y_expression();
            BigDecimal[] x_or_y_expression_instr = varInstr.get_x_or_y_expression();
            for (int index = 0; index < Utils.FUZZY_SET_LENGTH; index++) {
                if (!(x_or_y_expression_task[index].compareTo(x_or_y_expression_instr[index]) == 0)) {
                    points = points.subtract(new BigDecimal("0.04375"));
                    String task_answer = "";
                    String instr_answer = "";
                    for (int task_index = 0; task_index < Utils.FUZZY_SET_LENGTH; task_index++) {
                        task_answer += x_or_y_expression_task[task_index] + " ";
                        instr_answer += x_or_y_expression_instr[task_index] + " ";
                    }
                    comment += "Ваш ответ: x_or_y = [ " + task_answer + "], правильный ответ: x_or_y = [ " + instr_answer + "]. ";
                    break;
                }
            }

            BigDecimal[] x_and_y_expression_task = checkTask.get_x_and_y_expression();
            BigDecimal[] x_and_y_expression_instr = varInstr.get_x_and_y_expression();
            for (int index = 0; index < Utils.FUZZY_SET_LENGTH; index++) {
                if (!(x_and_y_expression_task[index].compareTo(x_and_y_expression_instr[index]) == 0)) {
                    points = points.subtract(new BigDecimal("0.04375"));
                    String task_answer = "";
                    String instr_answer = "";
                    for (int task_index = 0; task_index < Utils.FUZZY_SET_LENGTH; task_index++) {
                        task_answer += x_and_y_expression_task[task_index] + " ";
                        instr_answer += x_and_y_expression_instr[task_index] + " ";
                    }
                    comment += "Ваш ответ: x_and_y = [ " + task_answer + "], правильный ответ: x_and_y = [ " + instr_answer + "]. ";
                    break;
                }
            }

            BigDecimal[] not_x_or_y_expression_task = checkTask.get_not_x_or_y_expression();
            BigDecimal[] not_x_or_y_expression_instr = varInstr.get_not_x_or_y_expression();
            for (int index = 0; index < Utils.FUZZY_SET_LENGTH; index++) {
                if (!(not_x_or_y_expression_task[index].compareTo(not_x_or_y_expression_instr[index]) == 0)) {
                    points = points.subtract(new BigDecimal("0.04375"));
                    String task_answer = "";
                    String instr_answer = "";
                    for (int task_index = 0; task_index < Utils.FUZZY_SET_LENGTH; task_index++) {
                        task_answer += not_x_or_y_expression_task[task_index] + " ";
                        instr_answer += not_x_or_y_expression_instr[task_index] + " ";
                    }
                    comment += "Ваш ответ: not_x_or_y = [ " + task_answer + "], правильный ответ: not_x_or_y = [ " + instr_answer + "]. ";
                    break;
                }
            }

            BigDecimal[] not_x_and_y_expression_task = checkTask.get_not_x_and_y_expression();
            BigDecimal[] not_x_and_y_expression_instr = varInstr.get_not_x_and_y_expression();
            for (int index = 0; index < Utils.FUZZY_SET_LENGTH; index++) {
                if (!(not_x_and_y_expression_task[index].compareTo(not_x_and_y_expression_instr[index]) == 0)) {
                    points = points.subtract(new BigDecimal("0.04375"));
                    String task_answer = "";
                    String instr_answer = "";
                    for (int task_index = 0; task_index < Utils.FUZZY_SET_LENGTH; task_index++) {
                        task_answer += not_x_and_y_expression_task[task_index] + " ";
                        instr_answer += not_x_and_y_expression_instr[task_index] + " ";
                    }
                    comment += "Ваш ответ: not_x_and_y = [ " + task_answer + "], правильный ответ: not_x_and_y = [ " + instr_answer + "]. ";
                    break;
                }
            }

            BigDecimal[] x_or_not_y_expression_task = checkTask.get_x_or_not_y_expression();
            BigDecimal[] x_or_not_y_expression_instr = varInstr.get_x_or_not_y_expression();
            for (int index = 0; index < Utils.FUZZY_SET_LENGTH; index++) {
                if (!(x_or_not_y_expression_task[index].compareTo(x_or_not_y_expression_instr[index]) == 0)) {
                    points = points.subtract(new BigDecimal("0.04375"));
                    String task_answer = "";
                    String instr_answer = "";
                    for (int task_index = 0; task_index < Utils.FUZZY_SET_LENGTH; task_index++) {
                        task_answer += x_or_not_y_expression_task[task_index] + " ";
                        instr_answer += x_or_not_y_expression_instr[task_index] + " ";
                    }
                    comment += "Ваш ответ: x_or_not_y = [ " + task_answer + "], правильный ответ: x_or_not_y = [ " + instr_answer + "]. ";
                    break;
                }
            }

            BigDecimal[] x_and_not_y_expression_task = checkTask.get_x_and_not_y_expression();
            BigDecimal[] x_and_not_y_expression_instr = varInstr.get_x_and_not_y_expression();
            for (int index = 0; index < Utils.FUZZY_SET_LENGTH; index++) {
                if (!(x_and_not_y_expression_task[index].compareTo(x_and_not_y_expression_instr[index]) == 0)) {
                    points = points.subtract(new BigDecimal("0.04375"));
                    String task_answer = "";
                    String instr_answer = "";
                    for (int task_index = 0; task_index < Utils.FUZZY_SET_LENGTH; task_index++) {
                        task_answer += x_and_not_y_expression_task[task_index] + " ";
                        instr_answer += x_and_not_y_expression_instr[task_index] + " ";
                    }
                    comment += "Ваш ответ: x_and_not_y = [ " + task_answer + "], правильный ответ: x_and_not_y = [ " + instr_answer + "]. ";
                    break;
                }
            }

            BigDecimal[] not_x_or_not_y_expression_task = checkTask.get_not_x_or_not_y_expression();
            BigDecimal[] not_x_or_not_y_expression_instr = varInstr.get_not_x_or_not_y_expression();
            for (int index = 0; index < Utils.FUZZY_SET_LENGTH; index++) {
                if (!(not_x_or_not_y_expression_task[index].compareTo(not_x_or_not_y_expression_instr[index]) == 0)) {
                    points = points.subtract(new BigDecimal("0.04375"));
                    String task_answer = "";
                    String instr_answer = "";
                    for (int task_index = 0; task_index < Utils.FUZZY_SET_LENGTH; task_index++) {
                        task_answer += not_x_or_not_y_expression_task[task_index] + " ";
                        instr_answer += not_x_or_not_y_expression_instr[task_index] + " ";
                    }
                    comment += "Ваш ответ: not_x_or_not_y = [ " + task_answer + "], правильный ответ: not_x_or_not_y = [ " + instr_answer + "]. ";
                    break;
                }
            }

            BigDecimal[] not_x_and_not_y_expression_task = checkTask.get_not_x_and_not_y_expression();
            BigDecimal[] not_x_and_not_y_expression_instr = varInstr.get_not_x_and_not_y_expression();
            for (int index = 0; index < Utils.FUZZY_SET_LENGTH; index++) {
                if (!(not_x_and_not_y_expression_task[index].compareTo(not_x_and_not_y_expression_instr[index]) == 0)) {
                    points = points.subtract(new BigDecimal("0.04375"));
                    String task_answer = "";
                    String instr_answer = "";
                    for (int task_index = 0; task_index < Utils.FUZZY_SET_LENGTH; task_index++) {
                        task_answer += not_x_and_not_y_expression_task[task_index] + " ";
                        instr_answer += not_x_and_not_y_expression_instr[task_index] + " ";
                    }
                    comment += "Ваш ответ: not_x_and_not_y = [ " + task_answer + "], правильный ответ: not_x_and_not_y = [ " + instr_answer + "]. ";
                    break;
                }
            }

            BigDecimal[] x0_expression_task = checkTask.get_x0_expression();
            BigDecimal[] x0_expression_instr = varInstr.get_x0_expression();
            for (int index = 0; index < Utils.FUZZY_SET_LENGTH; index++) {
                if (!(x0_expression_task[index].compareTo(x0_expression_instr[index]) == 0)) {
                    points = points.subtract(new BigDecimal("0.04375"));
                    String task_answer = "";
                    String instr_answer = "";
                    for (int task_index = 0; task_index < Utils.FUZZY_SET_LENGTH; task_index++) {
                        task_answer += x0_expression_task[task_index] + " ";
                        instr_answer += x0_expression_instr[task_index] + " ";
                    }
                    comment += "Ваш ответ: x0 = [ " + task_answer + "], правильный ответ: x0 = [ " + instr_answer + "]. ";
                    break;
                }
            }

            BigDecimal[] y0_expression_task = checkTask.get_y0_expression();
            BigDecimal[] y0_expression_instr = varInstr.get_y0_expression();
            for (int index = 0; index < Utils.FUZZY_SET_LENGTH; index++) {
                if (!(y0_expression_task[index].compareTo(y0_expression_instr[index]) == 0)) {
                    points = points.subtract(new BigDecimal("0.04375"));
                    String task_answer = "";
                    String instr_answer = "";
                    for (int task_index = 0; task_index < Utils.FUZZY_SET_LENGTH; task_index++) {
                        task_answer += y0_expression_task[task_index] + " ";
                        instr_answer += y0_expression_instr[task_index] + " ";
                    }
                    comment += "Ваш ответ: y0 = [ " + task_answer + "], правильный ответ: y0 = [ " + instr_answer + "]. ";
                    break;
                }
            }

            BigDecimal[] linear_x_y_expression_task = checkTask.get_linear_x_y_expression();
            BigDecimal[] linear_x_y_expression_instr = varInstr.get_linear_x_y_expression();
            for (int index = 0; index < Utils.FUZZY_SET_LENGTH; index++) {
                if (!(linear_x_y_expression_task[index].compareTo(linear_x_y_expression_instr[index]) == 0)) {
                    points = points.subtract(new BigDecimal("0.04375"));
                    String task_answer = "";
                    String instr_answer = "";
                    for (int task_index = 0; task_index < Utils.FUZZY_SET_LENGTH; task_index++) {
                        task_answer += linear_x_y_expression_task[task_index] + " ";
                        instr_answer += linear_x_y_expression_instr[task_index] + " ";
                    }
                    comment += "Ваш ответ: linear_x_y = [ " + task_answer + "], правильный ответ: linear_x_y = [ " + instr_answer + "]. ";
                    break;
                }
            }

            BigDecimal[] euclid_x_y_expression_task = checkTask.get_euclid_x_y_expression();
            BigDecimal[] euclid_x_y_expression_instr = varInstr.get_euclid_x_y_expression();
            for (int index = 0; index < Utils.FUZZY_SET_LENGTH; index++) {
                if (!(euclid_x_y_expression_task[index].compareTo(euclid_x_y_expression_instr[index]) == 0)) {
                    points = points.subtract(new BigDecimal("0.04375"));
                    String task_answer = "";
                    String instr_answer = "";
                    for (int task_index = 0; task_index < Utils.FUZZY_SET_LENGTH; task_index++) {
                        task_answer += euclid_x_y_expression_task[task_index] + " ";
                        instr_answer += euclid_x_y_expression_instr[task_index] + " ";
                    }
                    comment += "Ваш ответ: euclid_x_y = [ " + task_answer + "], правильный ответ: euclid_x_y = [ " + instr_answer + "]. ";
                    break;
                }
            }

            BigDecimal[] linear_x_x0_expression_task = checkTask.get_linear_x_x0_expression();
            BigDecimal[] linear_x_x0_expression_instr = varInstr.get_linear_x_x0_expression();
            for (int index = 0; index < Utils.FUZZY_SET_LENGTH; index++) {
                if (!(linear_x_x0_expression_task[index].compareTo(linear_x_x0_expression_instr[index]) == 0)) {
                    points = points.subtract(new BigDecimal("0.04375"));
                    String task_answer = "";
                    String instr_answer = "";
                    for (int task_index = 0; task_index < Utils.FUZZY_SET_LENGTH; task_index++) {
                        task_answer += linear_x_x0_expression_task[task_index] + " ";
                        instr_answer += linear_x_x0_expression_instr[task_index] + " ";
                    }
                    comment += "Ваш ответ: linear_x_x0 = [ " + task_answer + "], правильный ответ: linear_x_x0 = [ " + instr_answer + "]. ";
                    break;
                }
            }

            BigDecimal[] linear_y_y0_expression_task = checkTask.get_linear_y_y0_expression();
            BigDecimal[] linear_y_y0_expression_instr = varInstr.get_linear_y_y0_expression();
            for (int index = 0; index < Utils.FUZZY_SET_LENGTH; index++) {
                if (!(linear_y_y0_expression_task[index].compareTo(linear_y_y0_expression_instr[index]) == 0)) {
                    points = points.subtract(new BigDecimal("0.04375"));
                    String task_answer = "";
                    String instr_answer = "";
                    for (int task_index = 0; task_index < Utils.FUZZY_SET_LENGTH; task_index++) {
                        task_answer += linear_y_y0_expression_task[task_index] + " ";
                        instr_answer += linear_y_y0_expression_instr[task_index] + " ";
                    }
                    comment += "Ваш ответ: linear_y_y0 = [ " + task_answer + "], правильный ответ: linear_y_y0 = [ " + instr_answer + "]. ";
                    break;
                }
            }

            BigDecimal x_y_hemming_index_task = checkTask.get_x_y_hemming_index();
            BigDecimal x_y_hemming_index_instr = varInstr.get_x_y_hemming_index();
            if (!(x_y_hemming_index_task.compareTo(x_y_hemming_index_instr) == 0)) {
                points = points.subtract(new BigDecimal("0.05"));
                comment += "Ваш ответ: x_y_hemming_index = " + x_y_hemming_index_task + ", правильный ответ: x_y_hemming_index = " + x_y_hemming_index_instr + ". ";
            }

            BigDecimal x_y_euclid_index_task = checkTask.get_x_y_euclid_index();
            BigDecimal x_y_euclid_index_instr = varInstr.get_x_y_euclid_index();
            if (!(x_y_euclid_index_task.compareTo(x_y_euclid_index_instr) == 0)) {
                points = points.subtract(new BigDecimal("0.05"));
                comment += "Ваш ответ: x_y_euclid_index = " + x_y_euclid_index_task + ", правильный ответ: x_y_euclid_index = " + x_y_euclid_index_instr + ". ";
            }

            BigDecimal x_x0_measure_task = checkTask.get_x_x0_measure();
            BigDecimal x_x0_measure_instr = varInstr.get_x_x0_measure();
            if (!(x_x0_measure_task.compareTo(x_x0_measure_instr) == 0)) {
                points = points.subtract(new BigDecimal("0.05"));
                comment += "Ваш ответ: x_x0_measure = " + x_x0_measure_task + ", правильный ответ: x_x0_measure = " + x_x0_measure_instr + ". ";
            }

            BigDecimal y_y0_measure_task = checkTask.get_y_y0_measure();
            BigDecimal y_y0_measure_instr = varInstr.get_y_y0_measure();
            if (!(y_y0_measure_task.compareTo(y_y0_measure_instr) == 0)) {
                points = points.subtract(new BigDecimal("0.05"));
                comment += "Ваш ответ: y_y0_measure = " + y_y0_measure_task + ", правильный ответ: y_y0_measure = " + y_y0_measure_instr + ". ";
            }

            BigDecimal x_x0_index_task = checkTask.get_x_x0_index();
            BigDecimal x_x0_index_instr = varInstr.get_x_x0_index();
            if (!(x_x0_index_task.compareTo(x_x0_index_instr) == 0)) {
                points = points.subtract(new BigDecimal("0.05"));
                comment += "Ваш ответ: x_x0_index = " + x_x0_index_task + ", правильный ответ: x_x0_index = " + x_x0_index_instr + ". ";
            }

            BigDecimal y_y0_index_task = checkTask.get_y_y0_index();
            BigDecimal y_y0_index_instr = varInstr.get_y_y0_index();
            if (!(y_y0_index_task.compareTo(y_y0_index_instr) == 0)) {
                points = points.subtract(new BigDecimal("0.05"));
                comment += "Ваш ответ: y_y0_index = " + y_y0_index_task + ", правильный ответ: y_y0_index = " + y_y0_index_instr + ". ";
            }

            if (points.compareTo(BigDecimal.ONE) < 0) {
                comment = "В решении имеются ошибки. " + comment;
            } else {
                comment += "Решение верно.";
            }
        } catch (Exception e) {
            points = points.subtract(BigDecimal.ONE);
            comment = "Failed, " + e.getMessage();
        }
        return new CheckingSingleConditionResult(points, comment);
    }

    @Override
    public void setPreCheckResult(PreCheckResult<String> preCheckResult) {
    }
}
