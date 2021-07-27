package com.example.pizzaapp;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class ShowChoices extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_show_choices);

        //declare & define objects
        EditText pizzatypeET = (EditText) findViewById(R.id.typeET);
        EditText pizzaquantityET = (EditText) findViewById(R.id.quantityET);
        EditText pizzasizeET = (EditText) findViewById(R.id.sizeET);
        EditText pizzaextraET = (EditText) findViewById(R.id.extraET);
        TextView totalCost = (TextView) findViewById(R.id.totalCost);


        //getting the values (pizzaType, pizzaSize) sent by the first screen
        //we also need to create an attempt to create an Intent to get the values
        Intent getValues = getIntent();

        //getting each value by storing it in a variable
        String pizzaType = getValues.getExtras().getString("typeKey");
        String pizzaQuantity = getValues.getExtras().getString("quantityKey");
        String pizzaSize = getValues.getExtras().getString("sizeKey");
        String pizzaExtra = getValues.getExtras().getString("extraKey");
        String pizzaTotalCost = getValues.getExtras().getString("totalCostKey");


        //let's display these value in the EditText pizzatypeET
        pizzatypeET.setText(pizzaType);
        pizzaquantityET.setText(pizzaQuantity);
        pizzasizeET.setText(pizzaSize);
        pizzaextraET.setText(pizzaExtra);
        totalCost.setText("Total Cost: " + pizzaTotalCost);




    }
}