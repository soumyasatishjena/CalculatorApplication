package com.example.calculatorapplication.calculatormodule;

public class CalculatorPresenter implements CalculatorInterface.Presenter {

    private final CalculatorModel calculatorModel;
    private final CalculatorInterface.View view;

    CalculatorPresenter(CalculatorInterface.View view) {
        this.calculatorModel = new CalculatorModel(this);
        this.view = view;
    }

    @Override
    public void performingAction(String inputOne, String inputTwo, String action) {
        calculatorModel.performingAction(inputOne, inputTwo, action);
    }

    @Override
    public void resultAction(String output, String action) {
        view.resultAction(output, action);
    }
}
