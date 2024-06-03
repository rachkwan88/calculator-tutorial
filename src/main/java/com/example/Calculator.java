package com.example;

public class Calculator {

    public Calculator() {
    }

    private String[] parse(String input) throws Exception {

        String op1 = "";
        String op = "";
        String op2 = "";
        int b = 0;

        int i = 0;
        int j = 0;

        while (j < input.length()) {
            if (input.charAt(j) == '(') {
                b += 1;
                j += 1;
                continue;
            }
            if (input.charAt(j) == ')') {
                b -= 1;
                if (b == 0) {
                    String op1_tmp = input.substring(i + 1, j);
                    op1 = Double.toString(this.calc(op1_tmp));
                    op = input.charAt(j + 1) + "";
                    String op2_tmp = input.substring(j + 2, input.length());
                    if (op2_tmp.charAt(0) == '(') {
                        String op2_tmp1 = op2_tmp.substring(1, op2_tmp.length() - 1);
                        op2 = Double.toString(this.calc(op2_tmp1));
                    } else {
                        op2 = op2_tmp;
                    }
                    break;
                }
            }

            if (input.charAt(j) >= '0' && input.charAt(j) <= '9') {
                j += 1;
            } else {
                if (b > 0) {
                    j += 1;
                    continue;
                }
                op1 = input.substring(i, j);
                op = input.charAt(j) + "";
                op2 = input.substring(j + 1, input.length());
                if (op2.charAt(0) == '(') {
                    String op2_1 = op2.substring(1, op2.length() - 1);
                    op2 = Double.toString(this.calc(op2_1));
                }
                break;
            }
        }

        if (op == "") {
            throw new Exception("No operator in input " + input);
        }

        String[] result = { op1, op, op2 };
        return result;

    }

    public double calc(String input) throws Exception {

        String[] result = null;

        result = parse(input);

        String op1 = result[0];
        String op = result[1];
        String op2 = result[2];

        double answer;

        double op1_value = Double.parseDouble(op1);
        double op2_value = Double.parseDouble(op2);

        if (op.equals("*")) {
            answer = op1_value * op2_value;
        } else if (op.equals("/")) {
            answer = op1_value / op2_value;
        } else if (op.equals("+")) {
            answer = op1_value + op2_value;
        } else {
            answer = op1_value - op2_value;
        }

        return answer;
    }
}
