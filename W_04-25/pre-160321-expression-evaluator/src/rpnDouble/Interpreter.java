package rpnDouble;

import java.util.Scanner;

/**
 * Created by Ben on 3/30/2015.
 */
public class Interpreter {


    private Scanner scn;
    private Calculator calc;

    public Interpreter(String source) {
        this(source, new Calculator());
    }

    public Interpreter(String source, Calculator calc) {
        this(new Scanner(source), calc);
    }

    public Interpreter(Scanner scn) {
        this(scn, new Calculator());
    }

    public Interpreter(Scanner scn, Calculator calc) {
        this.scn = scn;
        this.calc = calc;
    }

    public void step() {
        if(scn.hasNext()) {
            String token = scn.next();
            double val = tryParse(token);
            if(Double.isNaN(val)) {
                switch (token) {
                    case "+":
                        calc.add();
                        break;
                    case "-":
                        calc.subtract();
                        break;
                    case "dup":
                        calc.dup();
                        break;
                    case "drop":
                        calc.pop();
                        break;
                    case ".":
                        double v = calc.pop();
                        System.out.println(v);
                        break;
                    case "swap":
                        calc.swap();
                        break;
                    default:
                        throw new IllegalArgumentException("Unrecognized input token:  " + token);
                }
            } else{
                calc.push(val);
            }
        } else {
            throw new IllegalStateException("Interpreter attempts to step on empty input");
        }
    }

    public void exec() {
        while(!done()) {
            step();
        }
    }

    public Calculator getCalculator() {
        return calc;
    }

    public boolean done() {
        return !scn.hasNext();
    }


    /**
     * Convert str to a double.
     * If successful, return the value.
     * If it fails, return NaN.
     *
     * @return Value if conversion works, NaN if it fails.
     */
    public static double tryParse(String str) {
        try {
            double val = Double.parseDouble(str);
            return val;
        } catch(NumberFormatException nfe) {
            return Double.NaN;
        }
    }

}
