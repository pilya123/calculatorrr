package bin.hex.calculator1.pages;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import bin.hex.calculator1.R;
import bin.hex.calculator1.elements.InputElement;
import bin.hex.calculator1.elements.RadioGroupElement;
import bin.hex.calculator1.math.CRC_16;
import bin.hex.calculator1.math.CRC_32;
import bin.hex.calculator1.math.CRC_8;
import bin.hex.calculator1.math.Calculate;

import static bin.hex.calculator1.math.Calculate.NumeralSystem.DEC;

public class CrcPage extends AbstractPage {

    private InputElement input, crc8_result_output, crc16_result_output, crc32_result_output;
    private RadioGroupElement inputType, outputType, codingType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crc);

        input  = new InputElement(findViewById(R.id.crc_input));

        inputType = new RadioGroupElement((RadioGroup) findViewById(R.id.crc_input_type));
        outputType = new RadioGroupElement((RadioGroup) findViewById(R.id.crc_output_type));
        codingType = new RadioGroupElement((RadioGroup) findViewById(R.id.crc_coding_type));

        crc8_result_output = new InputElement(findViewById(R.id.crc8_result));
        crc16_result_output = new InputElement(findViewById(R.id.crc16_result));
        crc32_result_output = new InputElement(findViewById(R.id.crc32_result));



    }

    public void onCalculateClick(View view){

        String crc8;
        String crc16;
        String crc32;

        String initialValue = input.getConvertedValue();
        if(initialValue == null || initialValue.equals("")){
            showError("Please populate initial value");
            return;
        }
        String inputRadioValue = "";
        String outputRadioValue = "";
        String codingValue = "";
        try {
            int inputTypeId = inputType.getSelectedId();
            int outputTypeId = outputType.getSelectedId();
            int codingID = codingType.getSelectedId();

            inputRadioValue = ((RadioButton) findViewById(inputTypeId)).getText().toString();
            outputRadioValue = ((RadioButton) findViewById(outputTypeId)).getText().toString();
            codingValue = ((RadioButton) findViewById(codingID)).getText().toString();
        }catch (Exception e){
            e.printStackTrace();
            showError("Please select input type, output type and coding type.");
            return;
        }

        Calculate.NumeralSystem inputType = Calculate.NumeralSystem.get(inputRadioValue.toLowerCase());
        Calculate.NumeralSystem outputType = Calculate.NumeralSystem.get(outputRadioValue.toLowerCase());
        Calculate.CodingType coding = Calculate.CodingType.get(codingValue);

        if(inputType == DEC){
            showError("Incorrect input type: " + DEC + ". It's not allowed for input.");
            return;
        }

        if(inputType == null || outputType == null || coding == null){
            showError("Please select input type, output type and coding type.");
            return;
        }
        InputElement resultInput = crc8_result_output;
        String result;
        switch (coding){
            default:
                showError("Unknown coding type: " + coding);
                return;
            case CRC_8:
                result = CRC_8.calculate(initialValue, inputType, outputType);
                break;
            case CRC_16:
                resultInput = crc16_result_output;
                result = CRC_16.calculate(initialValue, inputType, outputType);
                break;
            case CRC_32:
                resultInput = crc32_result_output;
                result = CRC_32.calculate(initialValue, inputType, outputType);
                break;
        }

        updateValueOnUi(resultInput, result);

//        updateValueOnUi(crc8_result_output, crc8);
//        updateValueOnUi(crc16_result_output, crc16);
//        updateValueOnUi(crc32_result_output, crc32);

    }

}
