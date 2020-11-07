package com.example.calculatorapplication.calculatormodule;

public interface CalculatorInterface {

    interface Model {
        void performingAction(String inputOne, String inputTwo, String action);
    }

    interface View {
        void resultAction(String output, String action);

        void onBackPressed(String action, String output);
    }

    interface Presenter {
        void performingAction(String inputOne, String inputTwo, String action);
        void resultAction(String output, String action);
    }
}
