package com.example.calculatorapplication.appmodule;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.example.calculatorapplication.R;
import com.example.calculatorapplication.calculatormodule.CalculationActivity;
import com.example.calculatorapplication.databinding.ActivityMainBinding;
import static android.view.View.GONE;
import static android.view.View.VISIBLE;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityMainBinding binding;
    private String inputOne=null,inputTwo= null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        intiView();
    }

    private void intiView() {
        binding.textCalculate.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        setVisibility();
        super.onResume();
    }

    private void setVisibility(){
        binding.textCalculateValue.setVisibility(GONE);
        binding.layoutDisplay.setVisibility(GONE);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.textCalculate){
            setVisibility();
            inputOne = binding.inputValueOne.getText().toString().trim();
            inputTwo = binding.inputValueTwo.getText().toString().trim();
            if(!inputOne.isEmpty() && !inputTwo.isEmpty()){
              startActivityForResult(new Intent(this, CalculationActivity.class)
                      .putExtra("one", inputOne).putExtra("two", inputTwo),
                      1001);
            }else
            Toast.makeText(this, "Please fill both the values", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1001 && resultCode == RESULT_OK){
            if(data!= null){
                binding.textInputOneValueDis.setText(inputOne);
                binding.textInputTwoValueDis.setText(inputTwo);
                binding.textOutputDis.setText(data.getStringExtra("output"));
                binding.textActionDis.setText(data.getStringExtra("action"));
                binding.textCalculateValue.setVisibility(VISIBLE);
                binding.layoutDisplay.setVisibility(VISIBLE);
                binding.inputValueOne.setText("");
                binding.inputValueTwo.setText("");
                binding.inputValueOne.setCursorVisible(true);
                binding.inputValueOne.requestFocus();
            }
        }
    }
}