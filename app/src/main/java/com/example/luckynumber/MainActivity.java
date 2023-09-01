package com.example.luckynumber;

import androidx.appcompat.app.AppCompatActivity;

import android.inputmethodservice.Keyboard;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    LinearLayout primaryLinear, secondaryLinear,linear1, linear2;
    EditText edt_one, edt_two, edt_three;

    TextView edtnumSor;
    Button btn;


    int edtOne;
    int edtTwo;
    int edtThree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findIds();



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //dtOne =  edt_one.getText().toString();
                //edtTwo = edt_two.getText().toString();
                edtOne = Integer.parseInt(String.valueOf(edt_one.getText()));
                edtTwo = Integer.parseInt(String.valueOf(edt_two.getText()));
                edtThree = Integer.parseInt(String.valueOf(edt_three.getText()));

                if(edtOne > 0){


                    for (int i = 0; i < edtOne; i++) {
                        int num = (int)(Math.random() * edtThree) + edtTwo;
                        primaryLinear.setVisibility(View.GONE);
                        secondaryLinear.setVisibility(View.VISIBLE);
                        edtnumSor.setText(String.valueOf(num));
                        System.out.println(num);


                    }



                }

            }
        });

    }

    public void findIds(){
        edt_one = findViewById(R.id.edt_one);
        edt_two = findViewById(R.id.edt_two);
        edt_three = findViewById(R.id.edt_three);
        edtnumSor = findViewById(R.id.edtnumSor);
        btn = findViewById(R.id.btn);
        primaryLinear = findViewById(R.id.primaryLinear);
        secondaryLinear = findViewById(R.id.secondaryLinear);
    }
}