package com.example;

public class Calculator {

    private String[] parse(String input) throws Exception {

        String op1 = "";
        String op = "";
        String op2 = "";

        int i = 0;
        int j = 0;

        while (j < input.length()) {
            if (input.charAt(j) >= '0' && input.charAt(j) <= '9') {
                j += 1;
            } else {
                op1 = input.substring(i, j);
                op = input.charAt(j) + "";
                op2 = input.substring(j + 1, input.length());
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

        int op1_value = Integer.parseInt(op1);
        int op2_value = Integer.parseInt(op2);

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
