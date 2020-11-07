package com.example.calculatorapplication.calculatormodule;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import com.example.calculatorapplication.R;
import com.example.calculatorapplication.databinding.ActivityCalculationBinding;

public class CalculationActivity extends AppCompatActivity implements View.OnClickListener,
        CalculatorInterface.View {

    private ActivityCalculationBinding binding;
    private CalculatorPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_calculation);
        intiView();
    }

    private void intiView() {
        presenter = new CalculatorPresenter(this);
        binding.textAdd.setOnClickListener(this);
        binding.textSub.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
       getIntentValue();
    }

    private void getIntentValue(){
        Intent intent = getIntent();
        if (intent!=null){
            binding.inputValueOne.setText(intent.getStringExtra("one"));
            binding.inputValueTwo.setText(intent.getStringExtra("two"));
        }
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.textAdd:
                String action = binding.textAdd.getText().toString();
                presenter.performingAction(binding.inputValueOne.getText().toString(),
                        binding.inputValueTwo.getText().toString(), action);
                break;
            case R.id.textSub:
                action = binding.textSub.getText().toString();
                presenter.performingAction(binding.inputValueOne.getText().toString(),
                        binding.inputValueTwo.getText().toString(), action);
                break;
        }
    }

    @Override
    public void resultAction(String output, String action) {
        if(!action.isEmpty() && !output.isEmpty()){
            onBackPressed(action, output);
        }else {
            Toast.makeText(this, "Error !!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onBackPressed(String action, String output) {
        setResult(RESULT_OK,
                new Intent().putExtra("output", output)
                        .putExtra("action", action));
        finish();
    }
}