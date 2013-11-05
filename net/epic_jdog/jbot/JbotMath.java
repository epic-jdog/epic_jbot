package net.epic_jdog.jbot;

import java.util.Random;

/**
 * Created by James Ward (epic_jdog)
 * <p/>
 * Date: 03/11/13
 * Time: 2:31 PM
 */
public class JbotMath {      // Basically, we break the given expression down into a set of things that have to be added together. We then add those things. Hopefully it works.
    public String result = "Unknown Error: Something went wrong.";

    public String calculate(String MathExpression, boolean accuracy) {
        // the operations string array, as made by the parse method, will basically have an operation, followed by the required numbers, then the next operation, then their numbers, etc.
        String[] operations = parse(MathExpression);
        double steps = Math.floor(((operations.length) / 2));   //Here, we make a number of all the steps needed. That's basically length of the operations array over two, rounded down.
        int i2 = 0;
        int i = 0;
        int p = 0;
        int p2 = 1;
        String[] operators = new String[42];
        for (i = 0; i < Math.floor(((operations.length) / 2)); i++) {    //for each operation, we put an entry into the operators array, so we can pick out which operation we want to do.
            operators[i] = operations[i2];
            i2 = i2 + 2;
        }
        String[] values = new String[42];
        for (p = 0; p < Math.ceil(((operations.length) / 2)); p++) {    //for each set of values, we put an entry into the value array, so we can pick out which value set we want.
            values[p] = operations[p2];
            p2 = p2 + 2;
        }
        double total = 0;
        for (int q = 0; q <= (i - 2); q++) {       //This is where we decide which method each operator refers to. I've got a method for each operator.
           System.out.println(q);
           System.out.println(i);
            switch (operators[q]) {
                case "times": {
                    total += multiply(values[q]);
                    break;
                }
                case "minus": {
                    total += subtract(values[q]);
                    break;
                }
                case "over": {
                    total += divide(values[q]);
                    break;
                }
                case "plus": {
                    total += add(values[q]);
                    break;
                }
                case "powerof": {
                    total += exponent(values[q]);
                    break;
                }
                case "sqrt": {
                    total += squareroot(values[q]);
                    break;
                }
                case "formaterr": {
                    result = "Error: Invalid format - should be !jbot math x <operation> y";
                    break;
                }
                case "derp": {
                    result = "Error: Invalid Operation";
                    break;
                }
                case "stop": {
                    result = "Error: VLEEEEEE";
                    break;
                }
            }
        }


        if (result.startsWith("Error: ")) return result;
        if (accuracy) {
            return "" + total;
        } else {
            return ("Result: " + total);
        }
    }

    public String miscalculate(String MathExpression) {
        Random r = new Random();
        boolean pppppp = r.nextBoolean();
        double d = Double.parseDouble(calculate(MathExpression, true));    // LOL DOUBLE D I SO FUNNY
        d = pppppp ? d + (4 * (Math.getExponent(d))) : d - (4 * (Math.getExponent(d)));
        return ("Result: " + d);
    }

    public String rekkyncalculate(String MathExpression) {
        return ("http://en.wikipedia.org/wiki/Special:Random");
    }

    public String[] parse(String MathExpression) {  // Haha, THIS is where we decide what has to be done to the expression.
        String expression = MathExpression;
        if (MathExpression.contains("}")) {
            String[] array1 = MathExpression.split("[)]", 1);
            expression = array1[0];
        }
        if ((MathExpression.startsWith("√")) || (MathExpression.startsWith("sqrt("))) {
            String[] array2 = expression.split("[√,)]");
            String[] arrayfinal = new String[2];
            arrayfinal[1] = array2[0];
            arrayfinal[0] = "sqrt";
            return arrayfinal;
        }

        //The framework for this has the power to handle as many operations in a row as it needs, though I have not yet got a parser that's that good. For now, it's
        //Basically going to be x (operation) y - You can see squareroot has its own provisions.  So for now, we have this expression parser:

        String[] expressionsplit = expression.split("[ ]");
        if(expressionsplit.length < 3){
            String[] errorarray = new String[2];
            errorarray[1] = "format";
            return errorarray;
        }
        String[] arrayfinal = new String[(expressionsplit.length) + 2];
        arrayfinal[1] = "" + expressionsplit[0] + " " + expressionsplit[2];
        switch (expressionsplit[1]) {

            case "+": {
                arrayfinal[0] = "plus";
                break;
            }
            case "-": {
                arrayfinal[0] = "minus";
                break;
            }
            case "^": {
                arrayfinal[0] = "powerof";
                break;
            }
            case "*": {
                arrayfinal[0] = "times";
                break;
            }
            case "x": {
                arrayfinal[0] = "times";
                break;
            }
            case "/": {
                arrayfinal[0] = "over";
                break;
            }
            case "÷": {
                arrayfinal[0] = "over";
                break;
            }
            case "vlee": {
                arrayfinal[0] = "stop";

                break;
            }
            case "%": {
                arrayfinal[0] = "times";
                arrayfinal[1] = "" + expressionsplit[0] + " " + 0.1;
                break;
            }
            case "test": {
                arrayfinal[0] = "times";
                arrayfinal[1] = "4 5";
                arrayfinal[2] = "plus";
                arrayfinal[3] = "2 3";
                break;
            }
            case "format": {
                arrayfinal[0] = "formaterr";
                break;
            }



            default:{
                arrayfinal[0] = "derp";
                break;
            }

        }
        return arrayfinal;
    }

    public String solveQuadratic(String MathExpressionQuadratic) {
        String quadraticresult = "vEVEVEVEV";
        //stuff
        return quadraticresult;
    }

    double multiply(String input) {
        double product = 0;
        System.out.println(input);
        String[] inputs = input.split("[ ]");
        product = ((Double.parseDouble(inputs[0])) * (Double.parseDouble(inputs[1])));
        return product;
    }

    double subtract(String input) {
        double difference = 0;
        String[] inputs = input.split("[ ]");
        difference = ((Double.parseDouble(inputs[0])) - (Double.parseDouble(inputs[1])));
        return difference;
    }

    double add(String input) {
        double sum = 0;
        String[] inputs = input.split("[ ]");
        sum = ((Double.parseDouble(inputs[0])) + (Double.parseDouble(inputs[1])));
        return sum;
    }

    double divide(String input) {
        double quotient = 0;
        String[] inputs = input.split("[ ]");
        if (Double.parseDouble(inputs[1]) == 0) {
            result = "Error: Answer Undefined: Cannot Divide by zero.";
            return -9001;
        }
        quotient = ((Double.parseDouble(inputs[0])) / (Double.parseDouble(inputs[1])));
        return quotient;
    }

    double squareroot(String input) {
        double product = 0;
        double x = Double.parseDouble(input);
        if (x < 0) {
            result = "Error: Answer not real. Cannot take the square root of a negative number.";
            return -9001;
        }
        product = Math.sqrt(x);
        return product;
    }

    double exponent(String input) {
        double product = 0;
        String[] inputs = input.split("[ ]");
        if ((Double.parseDouble(inputs[0]) < 0) && (Double.parseDouble(inputs[1]) < 0)) {
            result = "Error: Answer not real. Cannot take the square root of a negative number.";
            return -9001;
        }
        product = Math.pow(Double.parseDouble(inputs[0]), Double.parseDouble(inputs[1]));
        return product;

    }

    String quadratic(String input) {
        double root1 = 0;
        double root2 = 0;
        String[] inputs = input.split("[ ]");
        double a = Double.parseDouble(inputs[0]);
        double b = Double.parseDouble(inputs[1]);
        double c = Double.parseDouble(inputs[2]);    //Quadratic formula anyone?!!
        double denominator = 2 * a;
        double determinant = 0;
        if (a == 0) {
            return "coefficient on x^2 cannot be zero; equation not quadratic.";
        }
        if (!(((Math.pow(b, 2D)) - (4 * a * c)) <= 0)) {
            determinant = (Math.sqrt((Math.pow(b, 2D)) - (4 * a * c)));
        } else {
            return "No real roots found.";
        }
        root1 = (((-1 * b) + determinant) / denominator);
        root2 = (((-1 * b) - determinant) / denominator);
        if (root1 == root2) {
            return ("1 root found: x = {" + root1) + "}";
        } else {
            return ("2 roots found: x = {" + root1 + ", " + root2 + "}");
        }

    }

}
