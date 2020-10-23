package bin.hex.calculator1.pages;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;

import bin.hex.calculator1.R;
import bin.hex.calculator1.elements.InputElement;
import bin.hex.calculator1.math.crc.AlgoParams;
import bin.hex.calculator1.math.crc.CrcCalculator;

public class CrcPage_v2 extends AbstractPage {

    private InputElement name, hashSize, poly, init, xorOut, check, crc_result;

    private boolean refInValue = false;
    private boolean refOutValue = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crc_v2);


        name = new InputElement(findViewById(R.id.crc_name));
        hashSize = new InputElement(findViewById(R.id.crc_hashSize));
        poly = new InputElement(findViewById(R.id.crc_poly));
        init = new InputElement(findViewById(R.id.crc_init));
        xorOut = new InputElement(findViewById(R.id.crc_xorOut));
        check = new InputElement(findViewById(R.id.crc_check));
        crc_result = new InputElement(findViewById(R.id.crc_result));

        Switch refIn = (Switch) findViewById(R.id.crc_refIn);
        if (refIn != null) {
            refIn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    refInValue = isChecked;
                }
            });
        }

        Switch refOut = (Switch) findViewById(R.id.crc_refOut);
        if (refOut != null) {
            refOut.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    refOutValue = isChecked;
                }
            });
        }



    }

    //Old approach:
//    public void onCalculateClick(View view){
//
//        String crc8;
//        String crc16;
//        String crc32;
//
//        String initialValue = input.getConvertedValue();
//        if(initialValue == null || initialValue.equals("")){
//            showError("Please populate initial value");
//            return;
//        }
//        String inputRadioValue = "";
//        String outputRadioValue = "";
//        String codingValue = "";
//        try {
//            int inputTypeId = inputType.getSelectedId();
//            int outputTypeId = outputType.getSelectedId();
//            int codingID = codingType.getSelectedId();
//
//            inputRadioValue = ((RadioButton) findViewById(inputTypeId)).getText().toString();
//            outputRadioValue = ((RadioButton) findViewById(outputTypeId)).getText().toString();
//            codingValue = ((RadioButton) findViewById(codingID)).getText().toString();
//        }catch (Exception e){
//            e.printStackTrace();
//            showError("Please select input type, output type and coding type.");
//            return;
//        }
//
//        Calculate.NumeralSystem inputType = Calculate.NumeralSystem.get(inputRadioValue.toLowerCase());
//        Calculate.NumeralSystem outputType = Calculate.NumeralSystem.get(outputRadioValue.toLowerCase());
//        Calculate.CodingType coding = Calculate.CodingType.get(codingValue);
//
//        if(inputType == DEC){
//            showError("Incorrect input type: " + DEC + ". It's not allowed for input.");
//            return;
//        }
//
//        if(inputType == null || outputType == null || coding == null){
//            showError("Please select input type, output type and coding type.");
//            return;
//        }
//        InputElement resultInput = crc8_result_output;
//        String result;
//        switch (coding){
//            default:
//                showError("Unknown coding type: " + coding);
//                return;
//            case CRC_8:
//                result = CRC_8.calculate(initialValue, inputType, outputType);
//                break;
//            case CRC_16:
//                resultInput = crc16_result_output;
//                result = CRC_16.calculate(initialValue, inputType, outputType);
//                break;
//            case CRC_32:
//                resultInput = crc32_result_output;
//                result = CRC_32.calculate(initialValue, inputType, outputType);
//                break;
//        }
//
//        updateValueOnUi(resultInput, result);
//
////        updateValueOnUi(crc8_result_output, crc8);
////        updateValueOnUi(crc16_result_output, crc16);
////        updateValueOnUi(crc32_result_output, crc32);
//
//    }

    //new approach:
    public void onCalculateClick(View view){
        String result = "";
        try {
            String nameV = name.getConvertedValue();
            int hashSizeV = Integer.parseInt(hashSize.getConvertedValue());
            long polyV = Long.parseLong(poly.getConvertedValue());
            long initV = Long.parseLong(init.getConvertedValue());
            boolean refInV = refInValue;
            boolean refOutV = refOutValue;
            long xorOutV = Long.parseLong(xorOut.getConvertedValue());
            long checkV = Long.parseLong(check.getConvertedValue());

            AlgoParams params = new AlgoParams(nameV, hashSizeV, polyV, initV, refInV, refOutV, xorOutV, checkV);
            result = CrcCalculator.check(params);
        }catch (Exception e){
            showError("Incorrect value populated. Exceptin returned: " + e.getMessage());
        }

        updateValueOnUi(crc_result, result);


    }

}
