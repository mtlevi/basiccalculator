package com.simpleapps.basiccalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView calculatorText;

    float currentResult = 0;
    String lastOperation = "";

    Button buttonSum;
    Button buttonSub;
    Button buttonMultiply;
    Button buttonDivide;
    Button buttonEquals;

    Button buttonOne;
    Button buttonTwo;
    Button buttonThree;

    Button buttonFour;
    Button buttonFive;
    Button buttonSix;

    Button buttonSeven;
    Button buttonEight;
    Button buttonNine;

    Button buttonClear;
    Button buttonZero;
    Button buttonDot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //elements on screen
        calculatorText    = (TextView) findViewById(R.id.calculatorText);

        buttonSum       = (Button) findViewById(R.id.buttonSum);
        buttonSub       = (Button) findViewById(R.id.buttonSub);
        buttonMultiply  = (Button) findViewById(R.id.buttonMultiply);
        buttonDivide    = (Button) findViewById(R.id.buttonDivide);
        buttonEquals    = (Button) findViewById(R.id.buttonEquals);

        buttonOne       = (Button) findViewById(R.id.buttonOne);
        buttonTwo       = (Button) findViewById(R.id.buttonTwo);
        buttonThree     = (Button) findViewById(R.id.buttonThree);

        buttonFour      = (Button) findViewById(R.id.buttonFour);
        buttonFive      = (Button) findViewById(R.id.buttonFive);
        buttonSix       = (Button) findViewById(R.id.buttonSix);

        buttonSeven     = (Button) findViewById(R.id.buttonSeven);
        buttonEight     = (Button) findViewById(R.id.buttonEight);
        buttonNine      = (Button) findViewById(R.id.buttonNine);

        buttonClear     = (Button) findViewById(R.id.buttonClear);
        buttonZero      = (Button) findViewById(R.id.buttonZero);
        buttonDot       = (Button) findViewById(R.id.buttonDot);

        //listeners
        buttonSum.setOnClickListener(this);
        buttonSub.setOnClickListener(this);
        buttonMultiply.setOnClickListener(this);
        buttonDivide.setOnClickListener(this);
        buttonEquals.setOnClickListener(this);

        buttonOne.setOnClickListener(this);
        buttonTwo.setOnClickListener(this);
        buttonThree.setOnClickListener(this);

        buttonFour.setOnClickListener(this);
        buttonFive.setOnClickListener(this);
        buttonSix.setOnClickListener(this);

        buttonSeven.setOnClickListener(this);
        buttonEight.setOnClickListener(this);
        buttonNine.setOnClickListener(this);

        buttonClear.setOnClickListener(this);
        buttonZero.setOnClickListener(this);
        buttonDot.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Basic actions for each button
     * @param v
     */
    @Override
    public void onClick(View v){

        switch (v.getId()){
            case R.id.buttonSum:
                if (currentResult == 0){
                    currentResult = Float.parseFloat(getCalculatorValue());
                } else {
                    currentResult = currentResult + Float.parseFloat(getCalculatorValue());
                }
                lastOperation = "+";
                clearCalculatorValue();
                break;
            case R.id.buttonSub:
                if (currentResult == 0){
                    currentResult = Float.parseFloat(getCalculatorValue());
                } else {
                    currentResult = currentResult - Float.parseFloat(getCalculatorValue());
                }
                lastOperation = "-";
                clearCalculatorValue();
                break;
            case R.id.buttonMultiply:
                if (currentResult == 0){
                    currentResult = Float.parseFloat(getCalculatorValue());
                } else {
                    currentResult = currentResult * Float.parseFloat(getCalculatorValue());
                }
                lastOperation = "*";
                clearCalculatorValue();
                break;
            case R.id.buttonDivide:
                if (currentResult == 0){
                    currentResult = Float.parseFloat(getCalculatorValue());
                } else {
                    currentResult = currentResult / Float.parseFloat(getCalculatorValue());
                }
                lastOperation = "/";
                clearCalculatorValue();
                break;
            case R.id.buttonEquals:
                calculateResult();
                updateCalculatorValue(String.valueOf(currentResult));
                break;
            case R.id.buttonZero:
                if (Float.parseFloat(getCalculatorValue()) != 0){
                    appendCalculatorValue("0");
                }
                break;
            case R.id.buttonOne:
                appendCalculatorValue("1");
                break;
            case R.id.buttonTwo:
                appendCalculatorValue("2");
                break;
            case R.id.buttonThree:
                appendCalculatorValue("3");
                break;
            case R.id.buttonFour:
                appendCalculatorValue("4");
                break;
            case R.id.buttonFive:
                appendCalculatorValue("5");
                break;
            case R.id.buttonSix:
                appendCalculatorValue("6");
                break;
            case R.id.buttonSeven:
                appendCalculatorValue("7");
                break;
            case R.id.buttonEight:
                appendCalculatorValue("8");
                break;
            case R.id.buttonNine:
                appendCalculatorValue("9");
                break;
            case R.id.buttonClear:
                currentResult = 0;
                clearCalculatorValue();
                break;
            case R.id.buttonDot:
                if (!getCalculatorValue().contains(".")){
                    appendCalculatorValue(".");
                }
                break;
            default:
                break;
        }
    }

    /**
     * Clears the current calculator value
     */
    public void clearCalculatorValue(){
        updateCalculatorValue("0");
    }

    /**
     * Appends numbers to the calculator value
     * @param toAppend
     */
    public void appendCalculatorValue(String toAppend){
        //if current text is 0 and will not append a dot, substitute the text with the appended text
        if (getCalculatorValue().equals("0") && !toAppend.equals(".")){
            updateCalculatorValue(toAppend);
        } else {
            updateCalculatorValue(getCalculatorValue() + toAppend);
        }
    }

    /**
     * Updates de value shown on the calculator
     * @param text
     */
    public void updateCalculatorValue(String text){
        calculatorText.setText(text);
    }

    /**
     * Returns the value show on the calculator (as String)
     * @return
     */
    public String getCalculatorValue(){
        return calculatorText.getText().toString();
    }

    /**
     * Calculates the result for when equals is touched
     */
    public void calculateResult(){
        if (lastOperation.equals("+")){
            currentResult = currentResult + Float.parseFloat(getCalculatorValue());
        } else if (lastOperation.equals("-")){
            currentResult = currentResult - Float.parseFloat(getCalculatorValue());
        } else if (lastOperation.equals("*")){
            currentResult = currentResult * Float.parseFloat(getCalculatorValue());
        } else if (lastOperation.equals("/")){
            currentResult = currentResult / Float.parseFloat(getCalculatorValue());
        }
    }
}
