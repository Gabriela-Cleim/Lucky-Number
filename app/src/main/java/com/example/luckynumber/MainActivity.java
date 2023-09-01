package com.example.luckynumber;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.inputmethodservice.Keyboard;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    LinearLayout primaryLinear, secondaryLinear,linear1, linear2;
    EditText edt_one, edt_two, edt_three;

    TextView edtnumSor, textFinal;
    Button btn, btnBack;


    int edtOne;
    int edtTwo;
    int edtThree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        findIds();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                edtOne = Integer.parseInt(edt_one.getText().toString());
                edtTwo = Integer.parseInt(edt_two.getText().toString());
                edtThree = Integer.parseInt(edt_three.getText().toString());


                if(edtOne > 0 && edtTwo > 0 && edtThree > 0){

                    List<String> array = new ArrayList<>();
                    int i;

                    for (i = 0; i < edtOne; i++) {
                        int num = (int)(Math.random() * edtThree) + edtTwo;
                        array.add(String.valueOf(num));
                        System.out.println(num);
                    }

                    if(String.valueOf(i).length() == String.valueOf(edtOne).length()){
                        primaryLinear.setVisibility(View.GONE);
                        secondaryLinear.setVisibility(View.VISIBLE);
                        edtnumSor.setText(array.toString());

                        if(imm.isActive()){
                            imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
                        }

                    }
                    if(edtOne >= 2){
                        primaryLinear.setVisibility(View.GONE);
                        secondaryLinear.setVisibility(View.VISIBLE);
                        textFinal.setText(R.string.title_two);
                        edtnumSor.setText(array.toString());
                    }else{
                        textFinal.setText(R.string.title_one);
                    }
                }else{

                    Toast.makeText(MainActivity.this, R.string.toast, Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                primaryLinear.setVisibility(View.VISIBLE);
                secondaryLinear.setVisibility(View.GONE);
                edt_one.setText("0");
                edt_two.setText("0");
                edt_three.setText("0");
            }
        });

    }

    public void findIds(){
        edt_one = findViewById(R.id.edt_one);
        edt_two = findViewById(R.id.edt_two);
        edt_three = findViewById(R.id.edt_three);
        edtnumSor = findViewById(R.id.edtnumSor);
        textFinal = findViewById(R.id.textFinal);
        btn = findViewById(R.id.btn);
        btnBack = findViewById(R.id.btnBack);
        primaryLinear = findViewById(R.id.primaryLinear);
        secondaryLinear = findViewById(R.id.secondaryLinear);

    }
}