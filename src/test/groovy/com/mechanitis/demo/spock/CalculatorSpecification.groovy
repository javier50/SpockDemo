package com.mechanitis.demo.spock

import spock.lang.Specification

class CalculatorSpecification extends Specification{

    def "simple assertion Check sum"(){
        given:
            def calculator = new Calculator()
        when:
            def sum = calculator.addition(22, 1)
        then:
            23 == sum
    }

    def "iteration assertion"(){
        given:
            def calculator = new Calculator()
            Operation operation = new Operation(calculator)
            operation.setType(Calculator.OperationType.Addition)
        when:
            operation.doOperation(22,1);
        then:
            23 == operation.result;
    }

    def "where assertion"(){
        given:
        def calculator = new Calculator()
        Operation operation = new Operation(calculator)
        operation.setType(Calculator.OperationType.Addition)
        when:
        def result = operation.doOperation(a,b);
        then:
        result == resultTable;
        where:
        a   |   b   |   resultTable
        1   |   2   |   3
        4   |   2   |   6
    }

    def "mock assertion" (){
        given:
        def calculatorMock = Mock(Calculator.class)
        def operation = new Operation(calculatorMock)
        operation.setType(Calculator.OperationType.Addition)
        when:
        int result = operation.doOperation(22,1)
        then:
        1*calculatorMock.addition(_,_) >> 23 // driven data
        result == 23
    }

    def "stub assertion" () {
        given:
        def calculatorStub = Stub(Calculator.class)
        calculatorStub.addition(_,_) >> 23 // driven data
        def operation = new Operation(calculatorStub)
        operation.setType(Calculator.OperationType.Addition)
        when:
        int result = operation.doOperation(22,1)
        then:
        result == 23
    }
}
