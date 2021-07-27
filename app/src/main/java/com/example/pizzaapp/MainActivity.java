package com.example.pizzaapp;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final RadioGroup radiobtn = (RadioGroup) findViewById(R.id.radiobuttonGRP);
        final EditText txtQ = (EditText) findViewById(R.id.txtquantity);
        final RadioGroup radiobtnS = (RadioGroup) findViewById(R.id.radiobuttonSize);
        final CheckBox checkBoxC = (CheckBox) findViewById(R.id.checkBoxCheese);
        final CheckBox checkBoxSPC = (CheckBox) findViewById(R.id.checkBoxSPC);

        Button pressMe = (Button) findViewById(R.id.btnGo);
        Button clear = (Button) findViewById(R.id.btnClear);


        // clicking button

        //button clear
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                // get selected radio button from radioGroup
                int selectedbtn = radiobtn.getCheckedRadioButtonId();
                int selectedbtn2 = radiobtnS.getCheckedRadioButtonId();

                // find the radiobutton by returned id
                RadioButton selectedRadioButton = (RadioButton) findViewById(selectedbtn);
                RadioButton selectedRadioButton2 = (RadioButton) findViewById(selectedbtn2);


                if (radiobtn.getCheckedRadioButtonId() != -1) {
                    selectedRadioButton.setChecked(false);
                }
                if (radiobtnS.getCheckedRadioButtonId() != -1) {
                    selectedRadioButton2.setChecked(false);
                }


                txtQ.setText("");


                if (checkBoxC.isChecked()) {
                    checkBoxC.setChecked(false);
                }
                if (checkBoxSPC.isChecked()) {
                    checkBoxSPC.setChecked(false);
                }


            }
        });


        //button pressMe
        pressMe.setOnClickListener(new View.OnClickListener() {

                                       @Override
                                       public void onClick(View v) {


                                           try {


                                               // get selected radio button from radioGroup
                                               int selectedbtn = radiobtn.getCheckedRadioButtonId();
                                               int selectedbtn2 = radiobtnS.getCheckedRadioButtonId();

                                               // find the radiobutton by returned id
                                               RadioButton selectedRadioButton = (RadioButton) findViewById(selectedbtn);
                                               RadioButton selectedRadioButton2 = (RadioButton) findViewById(selectedbtn2);


                                               //create an intent object to go to the second page
                                               Intent gotoScreen2 = new Intent(MainActivity.this, ShowChoices.class);

                                               //pack the variables with this Intent object
                                               gotoScreen2.putExtra("typeKey", selectedRadioButton.getText().toString());
                                               gotoScreen2.putExtra("sizeKey", selectedRadioButton2.getText().toString());
                                               gotoScreen2.putExtra("quantityKey", txtQ.getText().toString());

                                               //Checking checkboxes and doing the end results of the math to get total of cost
                                               // depending which topping the user gets
                                               int amountQ = Integer.parseInt(txtQ.getText().toString());
                                               int totalCostQ = amountQ * 10;
                                               int totalCostCheese = 3;
                                               int totalCostSPC = 4;

                                               if (checkBoxC.isChecked() && !checkBoxSPC.isChecked()) {

                                                   gotoScreen2.putExtra("extraKey", checkBoxC.getText().toString());

                                                   int totalC = totalCostQ + totalCostCheese;
                                                   String totalCostC = Integer.toString(totalC);

                                                   gotoScreen2.putExtra("totalCostKey", totalCostC);


                                               } else if (checkBoxSPC.isChecked() && !checkBoxC.isChecked()) {

                                                   gotoScreen2.putExtra("extraKey", checkBoxSPC.getText().toString());

                                                   int totalSPC = totalCostQ + totalCostSPC;
                                                   String totalcoSPC = Integer.toString(totalSPC);

                                                   gotoScreen2.putExtra("totalCostKey", totalcoSPC);

                                               } else if (checkBoxC.isChecked() && checkBoxSPC.isChecked()) {

                                                   gotoScreen2.putExtra("extraKey", checkBoxC.getText().toString());
                                                   gotoScreen2.putExtra("extraKey", checkBoxSPC.getText().toString());

                                                   int totalCSPC = totalCostQ + totalCostCheese + totalCostSPC;
                                                   String totalCostCSPC = Integer.toString(totalCSPC);

                                                   gotoScreen2.putExtra("totalCostKey", totalCostCSPC);

                                               } else if (!checkBoxC.isChecked() && !checkBoxSPC.isChecked()) {

                                                   gotoScreen2.putExtra("extraKey", "N/A");

                                                   int totalCSPC = totalCostQ;
                                                   String totalCostCSPC = Integer.toString(totalCSPC);

                                                   gotoScreen2.putExtra("totalCostKey", totalCostCSPC);

                                               }


                                               //ready to go to the second screen named ShowChoices
                                               startActivity(gotoScreen2);


                                           } catch (Exception e) {

                                               if (radiobtn.getCheckedRadioButtonId() == -1 && radiobtnS.getCheckedRadioButtonId() == -1
                                                       && txtQ.getText().toString().equals("")) {

                                                   // no radio buttons are checked
                                                   Toast.makeText(MainActivity.this,
                                                           "Didn't select a type, size and quantity of pizza.", Toast.LENGTH_LONG).show();

                                               } else if (radiobtn.getCheckedRadioButtonId() != -1 && radiobtnS.getCheckedRadioButtonId() == -1
                                                       && txtQ.getText().toString().equals("")) {

                                                   // only clicked type of pizza
                                                   Toast.makeText(MainActivity.this,
                                                           "Didn't select a quantity and size of pizza.", Toast.LENGTH_LONG).show();

                                               } else if (radiobtn.getCheckedRadioButtonId() == -1 && radiobtnS.getCheckedRadioButtonId() != -1
                                                       && txtQ.getText().toString().equals("")) {

                                                   // only clicked size of pizza
                                                   Toast.makeText(MainActivity.this,
                                                           "Didn't select a type and quantity of pizza.", Toast.LENGTH_LONG).show();

                                               } else if (radiobtn.getCheckedRadioButtonId() == -1 && radiobtnS.getCheckedRadioButtonId() == -1
                                                       && !(txtQ.getText().toString()).equals("")) {

                                                   // only clicked quantity of pizza
                                                   Toast.makeText(MainActivity.this,
                                                           "Didn't select a type and size of pizza.", Toast.LENGTH_LONG).show();

                                               } else if (radiobtn.getCheckedRadioButtonId() != -1 && radiobtnS.getCheckedRadioButtonId() != -1
                                                       && txtQ.getText().toString().equals("")) {

                                                   // only clicked on type and size of pizza
                                                   Toast.makeText(MainActivity.this,
                                                           "Didn't add quantity of pizza.", Toast.LENGTH_LONG).show();

                                               } else if (radiobtn.getCheckedRadioButtonId() != -1 && radiobtnS.getCheckedRadioButtonId() == -1
                                                       && !(txtQ.getText().toString()).equals("")) {

                                                   // only clicked quantity of pizza
                                                   Toast.makeText(MainActivity.this,
                                                           "Didn't select a size of pizza.", Toast.LENGTH_LONG).show();

                                               } else if (radiobtn.getCheckedRadioButtonId() == -1 && radiobtnS.getCheckedRadioButtonId() != -1
                                                       && !(txtQ.getText().toString()).equals("")) {

                                                   // only clicked quantity of pizza
                                                   Toast.makeText(MainActivity.this,
                                                           "Didn't select a type of pizza.", Toast.LENGTH_LONG).show();

                                               }
                                           }

                                       }
                                   }
        );

    }

}