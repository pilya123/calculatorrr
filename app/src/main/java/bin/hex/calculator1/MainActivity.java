package bin.hex.calculator1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import bin.hex.calculator1.elements.InputElement;
import bin.hex.calculator1.elements.NumeralSysRadioGroup;
import bin.hex.calculator1.elements.OperatorsRadioGroup;
import bin.hex.calculator1.math.Calculate;
import bin.hex.calculator1.util.Log;

import static android.widget.Toast.makeText;

public class MainActivity extends AppCompatActivity {

    private InputElement inputNumber_1, inputNumber_2, inputNumberOfBitsToShift, resultInput;
    private OperatorsRadioGroup operatorGroup;
    private NumeralSysRadioGroup numeralSystemRadioGroup;

    private Integer number1, number2, numberOfBitsToShift;
    private String result;

    private Calculate.NumeralSystem numSystem;
    private Calculate.Operator operator;

    private Button calculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputNumber_1 = new InputElement(findViewById(R.id.input_number_1));
        inputNumber_2 = new InputElement(findViewById(R.id.input_number_2));
        inputNumberOfBitsToShift = new InputElement(findViewById(R.id.input_number_of_bits_to_shift));
        resultInput = new InputElement(findViewById(R.id.result_input));

        operatorGroup = new OperatorsRadioGroup((RadioGroup) findViewById(R.id.operator));
        numeralSystemRadioGroup = new NumeralSysRadioGroup((RadioGroup) findViewById(R.id.num_sys_select));

        calculate = findViewById(R.id.calculate_btn);

    }

    public void onOperatorSelect(View v){
        setOperator();

    }

    private void setOperator(){
        int radioBtnId = operatorGroup.getSelectedId();
        String radioValue = ((RadioButton)findViewById(radioBtnId)).getText().toString();
        operator = Calculate.Operator.get(radioValue);
    }

    public void onNumeralSelection(View v){
        Log.log("Numeral system clicked.");
        setNumeralSystem();
    }

    private void setNumeralSystem(){
        int radioBtnId = numeralSystemRadioGroup.getSelectedId();
        String radioValue = ((RadioButton)findViewById(radioBtnId)).getText().toString();
        numSystem = Calculate.NumeralSystem.get(radioValue);
    }

    public void onCalculate(View v){
        Button btn = (Button) v;

        number1 = inputNumber_1.getConvertedValue();
        number2 = inputNumber_2.getConvertedValue();
        numberOfBitsToShift = inputNumberOfBitsToShift.getConvertedValue();

        String msg = "Please select a valid Numeral system.";
        if(numSystem == null){
            Log.log(msg);
            makeText(MainActivity.this, msg, Toast.LENGTH_SHORT);
            return;
        }

        switch (numSystem){
            default:
                makeText(MainActivity.this, msg, Toast.LENGTH_SHORT);
            case BIN:
                int bin = Calculate.getBin(number1, number2, operator);
                result = String.valueOf(bin);
                break;
            case DEC:
                int dec = Calculate.getDec(number1, number2, operator);
                result = String.valueOf(dec);
                break;
            case HEX:
                result = Calculate.getHex(number1, numberOfBitsToShift, operator);
                break;
        }
        Log.log("Calculation completed.");

        updateResultsOnUi();

    }

    private void updateResultsOnUi(){
        resultInput.setValue(String.valueOf(result));
        Log.log("Result was updated with '"+result+"'.");
    }

    public void onResetClick(View v){
        Button btn = (Button) v;

        inputNumber_1.clear();
        inputNumber_2.clear();
        inputNumberOfBitsToShift.clear();
        resultInput.clear();
        Log.log("Reset all values.");

    }


}
