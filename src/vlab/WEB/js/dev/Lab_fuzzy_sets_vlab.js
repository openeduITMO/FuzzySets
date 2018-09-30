function init_lab() {
    var container,
        help_active = false,
        default_variant = {
            'x_set': [0, 0.5, 0.7, 0.6, 0.3, 0.9, 1, 0.9],
            'y_set': [0.4, 0.9, 0.8, 0.1, 0.8, 0.2, 0.9, 1]
        },
        lab_variant,
        window =
            '<div class="vlab_setting">' +
            '<div class="block_title">' +
            '<div class="vlab_name">Виртуальная лаборатория «Нечеткие множества»</div>' +
            '<input class="btn_help btn" type="button" value="Справка"/>' +
            '</div>' +
            '<div class="block_workspace">' +
            '<div class="variant_title">Исходные множества</div>' +
            '<table class="variant_table">' +
            '<thead><tr><th class="variant_cell"></th></tr></thead>' +
            '<tbody>' +
            '<tr class="variant_x"><td>X</td></tr>' +
            '<tr class="variant_y"><td>Y</td></tr>' +
            '</tbody>' +
            '</table>' +
            '<div class="expressions_title">Таблица выражений</div>' +
            '<table class="expressions_table">' +
            '<tbody>' +
            '<tr class="expressions_row" data-expression="not_x_expression"><td>X\'</td></tr>' +
            '<tr class="expressions_row" data-expression="not_y_expression"><td>Y\'</td></tr>' +
            '<tr class="expressions_row" data-expression="x_or_y_expression"><td>X &#8899; Y</td></tr>' +
            '<tr class="expressions_row" data-expression="x_and_y_expression"><td>X &#8898; Y</td></tr>' +
            '<tr class="expressions_row" data-expression="not_x_or_y_expression"><td>X\' &#8899; Y</td></tr>' +
            '<tr class="expressions_row" data-expression="not_x_and_y_expression"><td>X\' &#8898; Y</td></tr>' +
            '<tr class="expressions_row" data-expression="x_or_not_y_expression"><td>X &#8899; Y\'</td></tr>' +
            '<tr class="expressions_row" data-expression="x_and_not_y_expression"><td>X &#8898; Y\'</td></tr>' +
            '<tr class="expressions_row" data-expression="not_x_or_not_y_expression"><td>X\' &#8899; Y\'</td></tr>' +
            '<tr class="expressions_row" data-expression="not_x_and_not_y_expression"><td>X\' &#8898; Y\'</td></tr>' +
            '<tr class="expressions_row" data-expression="x0_expression"><td>X<sub>0</sub></td></tr>' +
            '<tr class="expressions_row" data-expression="y0_expression"><td>Y<sub>0</sub></td></tr>' +
            '<tr class="expressions_row" data-expression="linear_x_y_expression"><td>Линейное расстояние между X и Y</td></tr>' +
            '<tr class="expressions_row" data-expression="euclid_x_y_expression"><td>Евклидово расстояние между X и Y</td></tr>' +
            '<tr class="expressions_row" data-expression="linear_x_x0_expression"><td>Линейное расстояние между X и X<sub>0</sub></td></tr>' +
            '<tr class="expressions_row" data-expression="linear_y_y0_expression"><td>Линейное расстояние между Y и Y<sub>0</sub></td></tr>' +
            '</tbody>' +
            '</tbody></table>' +
            '<div class="indexes_title">Таблица индексов</div>' +
            '<table class="indexes_table">' +
            '<tbody>' +
            '<tr class="indexes_row" data-index="x_y_hemming_index"><td>Абсолютное расстояние по Хеммингу</td></tr>' +
            '<tr class="indexes_row" data-index="x_y_euclid_index"><td>Абсолютное расстояние по Евклиду</td></tr>' +
            '<tr class="indexes_row" data-index="x_x0_measure"><td>Линейная мера нечеткости X</td></tr>' +
            '<tr class="indexes_row" data-index="y_y0_measure"><td>Линейная мера нечеткости Y</td></tr>' +
            '<tr class="indexes_row" data-index="x_x0_index"><td>Линейный индекс нечеткости X</td></tr>' +
            '<tr class="indexes_row" data-index="y_y0_index"><td>Линейный индекс нечеткости Y</td></tr>' +
            '</tbody>' +
            '</table>' +
            '</div>' +
            '<div class="block_help">' +
            '<h1>Помощь по работе в виртуальной лаборатории</h1>' +
            '<p>Необходимо ввести верные значения в ячейки таблицы. Формат ввода: десятичное число, ' +
            'округленное до второго знака после разделителя. В качестве разделителя используйте точку.</p>' +
            '<p>Желаем удачи в выполнении виртуальной лабораторной работы!</p>' +
            '</div>' +
            '</div>';

    function show_help() {
        if (!help_active) {
            help_active = true;
            $(".block_help").css("display", "block");
            $(".btn_help").attr("value", "Вернуться");
        } else {
            help_active = false;
            $(".block_help").css("display", "none");
            $(".btn_help").attr("value", "Справка");
        }
    }

    function parse_generated(str, def_obj) {
        var parse_str;
        if (typeof str === 'string' && str !== "") {
            try {
                parse_str = str.replace(/<br\/>/g, "\r\n").replace(/&amp;/g, "&").replace(/&quot;/g, "\"").replace(/&lt;br\/&gt;/g, "\r\n")
                    .replace(/&lt;/g, "<").replace(/&gt;/g, ">").replace(/&minus;/g, "-").replace(/&apos;/g, "\'").replace(/&#0045;/g, "-");
                parse_str = JSON.parse(parse_str);
            } catch (e) {
                if (def_obj) {
                    parse_str = def_obj;
                } else {
                    parse_str = false;
                }
            }
        } else {
            if (def_obj) {
                parse_str = def_obj;
            } else {
                parse_str = false;
            }
        }
        return parse_str;
    }

    function get_variant() {
        var variant;
        if ($("#preGeneratedCode") !== null) {
            variant = parse_generated($("#preGeneratedCode").val(), default_variant);
        } else {
            variant = default_variant;
        }
        return variant;
    }

    function draw_previous_solution(previous_solution) {
        $('.indexes_row').each(function () {
            $(this).find('input').val(previous_solution[$(this).data('index')]);
        });
        $('.expressions_row').each(function () {
            var expression = $(this).data('expression');
            $(this).find('input').each(function (key) {
                $(this).val(previous_solution[expression][key]);
            });
        });
    }

    function draw_tables() {
        var row_cell = $($.parseHTML('<td class="row_cell"><input type="number" step="0.01" value="0"></td>')[0]).clone();
        var variant_header_cell = $($.parseHTML('<th class="variant_cell"></th>')[0]);
        var variant_cell = $($.parseHTML('<td class="variant_cell"></td>')[0]);
        for (var i = 0; i < lab_variant.x_set.length; i++) {
            $('.variant_table thead tr').append(variant_header_cell.clone().text(i + 1));
            $('.variant_x').append(variant_cell.clone().text(lab_variant.x_set[i]));
            $('.variant_y').append(variant_cell.clone().text(lab_variant.y_set[i]));
            $('.expressions_table tr').append(row_cell.clone().attr('index', i));
        }
        $('.indexes_table tr').append(row_cell.clone());
    }

    return {
        init: function () {
            lab_variant = get_variant();
            container = $("#jsLab")[0];
            container.innerHTML = window;
            draw_tables();
            if ($("#previousSolution") !== null && $("#previousSolution").length > 0 && parse_generated($("#previousSolution").val())) {
                var previous_solution = parse_generated($("#previousSolution").val());
                draw_previous_solution(previous_solution);
            }
            $(".btn_help").click(function () {
                show_help();
            });
        },
        getResults: function () {
            var answer = {};
            $('.indexes_row').each(function () {
                answer[$(this).data('index')] = $(this).find('input').val();
            });
            $('.expressions_row').each(function () {
                var value = [];
                $(this).find('input').each(function () {
                    value.push($(this).val());
                });
                answer[$(this).data('expression')] = value;
            });
            return JSON.stringify(answer);
        }
    }
}

var Vlab = init_lab();