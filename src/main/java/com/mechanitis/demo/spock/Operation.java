package com.mechanitis.demo.spock;

public class Operation {
    private Calculator.OperationType type;
    private int result;
    private Calculator calculator;

    public Operation(Calculator calculator){
        this.calculator = calculator;
    }

    public int doOperation(int a, int b){
        switch (type){
            case Addition:
                result = calculator.addition(a,b);
                break;
            case Subtraction:
                result = calculator.subtraction(a,b);
                break;
        }

        return result;
    }

    public Calculator.OperationType getType() {
        return type;
    }

    public void setType(Calculator.OperationType type) {
        this.type = type;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}
