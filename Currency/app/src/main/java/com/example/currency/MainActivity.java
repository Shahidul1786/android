package com.example.currency;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

Spinner fromSpinner, toSpinner;
EditText amountText,resultEditText;
Button convertButton,clearButton;

String[] currency={"BDT","USD","EURO"};
double[] rates   ={83.00, 1, 0.69881};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fromSpinner=findViewById(R.id.formSpinner);
        toSpinner=findViewById(R.id.toSpinner);
        amountText= findViewById(R.id.amounteditText);
       resultEditText=findViewById(R.id.resulteditText);

        convertButton=findViewById(R.id.convertbutton);
        clearButton=findViewById(R.id.clearbutton);

        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,currency);

        fromSpinner.setAdapter(adapter);
        toSpinner.setAdapter(adapter);
    }

    public void convert(View v){
        double amount=Double.parseDouble(amountText.getText().toString());
        double from=rates[fromSpinner.getSelectedItemPosition()];
        double to=rates[toSpinner.getSelectedItemPosition()];
        double result=(to/from)*amount;
        resultEditText.setText(String.valueOf(result+""));


    }

    public void DoClear(View v){
       amountText.setText("");
       resultEditText.setText("");

    }

}
