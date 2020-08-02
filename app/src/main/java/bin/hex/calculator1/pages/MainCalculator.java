package bin.hex.calculator1.pages;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import bin.hex.calculator1.CalculatorState;
import bin.hex.calculator1.R;
import bin.hex.calculator1.elements.InputElement;
import bin.hex.calculator1.elements.NumeralSysRadioGroup;
import bin.hex.calculator1.elements.OperatorsRadioGroup;
import bin.hex.calculator1.listeners.ConvertTypeSelectedListener;
import bin.hex.calculator1.math.Calculate;
import bin.hex.calculator1.util.Log;

import static android.widget.Toast.makeText;

public class MainCalculator extends AppCompatActivity {

    private InputElement inputNumber_1, inputNumber_2,  resultInput;
    private OperatorsRadioGroup operatorGroup;
    private NumeralSysRadioGroup numeralSystemRadioGroup;

    private InputElement convertInput, convertResultInput, convertBinInput, convertHexInput, convertDecInput;


    private String convBin, convDec, convHex;

    private String number1, number2;
    private String calculateResult = "";
    private String convertResultValue = "";



    private Calculate.NumeralSystem numSystem;
    private Calculate.Operator operator;


    private Button calculate;

//    private Spinner bitSelectSpinner;
//    private Spinner selectConvertType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator_main);

        inputNumber_1 = new InputElement(findViewById(R.id.input_number_1));
        inputNumber_2 = new InputElement(findViewById(R.id.input_number_2));
        resultInput = new InputElement(findViewById(R.id.result_input));

        operatorGroup = new OperatorsRadioGroup((RadioGroup) findViewById(R.id.operator));
        numeralSystemRadioGroup = new NumeralSysRadioGroup((RadioGroup) findViewById(R.id.num_sys_select));
        calculate = findViewById(R.id.calculate_btn);

//        convertInput = new InputElement(findViewById(R.id.convert_input));
//        convertResultInput = new InputElement(findViewById(R.id.convert_result));

        convertBinInput = new InputElement(findViewById(R.id.convertBin));
        convertDecInput = new InputElement(findViewById(R.id.convertDec));
        convertHexInput = new InputElement(findViewById(R.id.convertHex));

//        addListenerOnSpinnerItemSelection();
//        addListenerOnConvertTypeSpinner();

    }

//    public void addListenerOnConvertTypeSpinner(){
//        selectConvertType = findViewById(R.id.convert_type_spinner);
//        selectConvertType.setOnItemSelectedListener(new ConvertTypeSelectedListener());
//    }

//    public void addListenerOnSpinnerItemSelection() {
//        bitSelectSpinner = findViewById(R.id.bit_select_spinner);
//        bitSelectSpinner.setOnItemSelectedListener(new CustomOnItemSelectedListener());
//    }

    public void onOperatorSelect(View v){
        setOperator();
    }

//    public static void setBits(Calculate.Bit bit){
//        BITS = bit;
//        Log.log("Bits applied: " + BITS);
//    }

//    public void onClickToBitsSelect(View v){
//        Log.log("Bits calculated according to " + BITS);
//        //TODO:
//    }

    private void setOperator(){
        int radioBtnId = operatorGroup.getSelectedId();
        String radioValue = ((RadioButton)findViewById(radioBtnId)).getText().toString();
        Log.log("Operator radiobutton value = " + radioValue);
        operator = Calculate.Operator.get(radioValue);
        Log.log("Operator updated to " + operator);
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

    public void onSymbolButtonClick(View v){
        Button btn = (Button) v;
        String btnSymbol = btn.getText().toString();

        if(numSystem != Calculate.NumeralSystem.HEX){
            showError("Symbols are not available for '"+numSystem+"' mode. ");
            return;
        }

        InputElement input = inputNumber_1;
        if(inputNumber_2.focused()){
            input = inputNumber_2;
        }

        String currentInputValue = input.getConvertedValue();
        input.setValue(currentInputValue + btnSymbol);

    }

    public void onCalculate(View v){
        Button btn = (Button) v;

        number1 = inputNumber_1.getConvertedValue();
        number2 = inputNumber_2.getConvertedValue();

        String val_1 = number1;
        String val_2 = number2;

        Log.log("Number 1 = '"+val_1+"'");
        Log.log("Number 2 = '"+val_2+"'");

        boolean operatorPopulated = assertIsNotTrue(operator == null, "Please select a valid Operator.");
        boolean numSystemSelected = assertIsNotTrue(numSystem == null, "Please select a valid Numeral system.");
        boolean val1Populated = assertIsNotTrue(val_1.isEmpty(), "Number 1 is empty.");
        boolean val2Populated = assertIsNotTrue((val_2 == null || val_2.isEmpty()), "Number 2 is empty.");


        if(numSystemSelected &&
                operatorPopulated
                && val1Populated
                && val2Populated)
        {
            switch (numSystem) {
                default:
                    makeText(MainCalculator.this, "Invalid numeral system selected", Toast.LENGTH_SHORT).show();
                case BIN:
                    try {
                        calculateResult = Calculate.getBin(val_1, val_2, operator);
                    }catch (NumberFormatException e){
                        showError("Not a valid value for binary input. \n(Input 1 = '"+val_1+"'; Input 2 ='"+val_2+"')");
                    }
                    break;
                case DEC:
                    calculateResult = Calculate.getDec(val_1, val_2, operator);
                    break;
                case HEX:
                    calculateResult = Calculate.getHex(val_1, val_2, operator);
                    break;
            }
        }
        Log.log("Calculation completed.");

        updateCalculatedResultsOnUi();

    }

    private void showError(String msg){
        makeText(MainCalculator.this, msg, Toast.LENGTH_SHORT).show();
    }

    private boolean assertIsNotTrue(boolean condition, String error){
        if(condition){
            Log.log(error);
            showError(error);
            return false;
        }
        return true;

    }

    public void onConvertCodesClick(View view){
        Calculate.ConvertType type = CalculatorState.getConvertType();
        String initial = convertInput.getConvertedValue();

        if(initial == null || initial.isEmpty()){
            showError("Please type initial value.");
            return;
        }

        switch (type){
            default:
                showError("Please select a valid convert type.");
                return;
            case HAMMING:
                convertResultValue = Calculate.convertHamming(initial);
                break;
            case GRAY:
                convertResultValue = Calculate.convertToGray(initial);
                break;
            case PARITY:
                convertResultValue = Calculate.convertParity(initial);
                break;
        }

        updateConvertedResultsOnUi();

    }

    public void onConvertBinDecHexClick(View view){
        String bin = convertBinInput.getConvertedValue();
        String dec = convertDecInput.getConvertedValue();
        String hex = convertHexInput.getConvertedValue();

        String errorInField = "bin";
        try {
            if (!bin.isEmpty()) {
                convBin = bin;
                convDec = Calculate.binToDec(bin);
                convHex = Calculate.binToHex(bin);

            } else if (!dec.isEmpty()) {
                errorInField = "dec";
                convDec = dec;
                convBin = Calculate.decToBin(dec);
                convHex = Calculate.decToHex(dec);

            } else if (!hex.isEmpty()) {
                errorInField = "hex";
                convHex = hex;
                convBin = Calculate.hexToBin(hex);
                convDec = Calculate.hexToDec(hex);
            } else {
                showError("Please set at least one value: bin, dec, hex");
            }
        }catch (NumberFormatException e){
            showError("Incorrect value in '"+errorInField+"'");
        }

        updateConvertedBinHexDecResultsOnUi();

    }


    private void updateCalculatedResultsOnUi(){
        resultInput.setValue(calculateResult);
        Log.log("Result was updated with '"+ calculateResult +"'.");
    }

    private void updateConvertedResultsOnUi(){
        convertResultInput.setValue(convertResultValue);
        Log.log("Result was updated with '"+ convertResultValue +"'.");
    }

    private void updateConvertedBinHexDecResultsOnUi(){
        convertBinInput.setValue(convBin);
        convertDecInput.setValue(convDec);
        convertHexInput.setValue(convHex);
    }

    public void onResetClick(View v){
        Button btn = (Button) v;

        inputNumber_1.clear();
        inputNumber_2.clear();
        resultInput.clear();
        convertInput.clear();
        Log.log("Reset all values.");

    }

    public void onClearBinDecHex(View view){
        convertDecInput.clear();
        convertBinInput.clear();
        convertHexInput.clear();
        Log.log("Bin/Dec/Hex values have been cleared.");
    }

}
