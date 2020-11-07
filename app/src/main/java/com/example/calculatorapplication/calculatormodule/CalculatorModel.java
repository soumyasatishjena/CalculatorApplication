package com.example.calculatorapplication.calculatormodule;

public class CalculatorModel implements CalculatorInterface.Model {

    private final CalculatorPresenter calculatorPresenter;

    public CalculatorModel(CalculatorPresenter calculatorPresenter) {
        this.calculatorPresenter = calculatorPresenter;
    }

    @Override
    public void performingAction(String inputOne, String inputTwo, String action) {
        String output = null;
        switch (action){
            case "Addition":
                int add = Integer.parseInt(inputOne) + Integer.parseInt(inputTwo);
                output = String.valueOf(add);
                break;
            case "Subtraction":
                int sub = Integer.parseInt(inputOne) - Integer.parseInt(inputTwo);
                output = String.valueOf(sub);
                break;
        }
        calculatorPresenter.resultAction(output, action);
    }
}
