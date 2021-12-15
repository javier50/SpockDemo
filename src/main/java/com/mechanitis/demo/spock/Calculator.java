package com.mechanitis.demo.spock;

import java.util.ArrayList;

public class Calculator {
    public static enum OperationType {Addition, Subtraction}

    public Calculator(){}

    public int addition(int a, int b){
        return a + b;
    }

    public int subtraction(int a, int b){
        return a - b;
    }
}
