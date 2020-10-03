package bin.hex.calculator1.pages;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import bin.hex.calculator1.R;
import bin.hex.calculator1.elements.InputElement;
import bin.hex.calculator1.elements.RadioGroupElement;
import bin.hex.calculator1.math.Calculate;
import bin.hex.calculator1.math.ParityOfNumber;
import bin.hex.calculator1.util.Log;

public class HammingParityPage extends AbstractPage {

    private InputElement hammingInput, hammingResult,
            endiannessInput, endiannessResult,
            parityInput, parityBruteForce, parityBasedOnClearingSetBit, parityMostEfficient, parityWithCaching;
    private String convertedHammingValue, convertedEndiannessValue = "";
    private RadioGroupElement endiannessType;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hamming__parity_endianness);

        hammingInput = new InputElement(findViewById(R.id.input_hamming_value));
        hammingResult = new InputElement(findViewById(R.id.output_hamming_value));

        endiannessInput = new InputElement(findViewById(R.id.input_endianness_value));
        endiannessResult = new InputElement(findViewById(R.id.output_endianness));
        endiannessType = new RadioGroupElement((RadioGroup) findViewById(R.id.endian_type));

        parityInput = new InputElement(findViewById(R.id.parity_input));
        parityBruteForce = new InputElement(findViewById(R.id.parity_bruce_force));
        parityBasedOnClearingSetBit = new InputElement(findViewById(R.id.parity_based_on_clearing_set_bin));
        parityMostEfficient = new InputElement(findViewById(R.id.parity_most_efficient));
        parityWithCaching = new InputElement(findViewById(R.id.parity_with_cashing));

    }

    public void onConvertHammingClick(View view) {
        String initial = hammingInput.getConvertedValue();

        if (initial == null || initial.isEmpty()) {
            showError("Please type initial value.");
            return;
        }
        convertedHammingValue = Calculate.convertHamming(initial);

        updateValueOnUi(hammingResult, convertedHammingValue);
    }

    public void onConvertEndiannessClick(View view) {
        String initial = endiannessInput.getConvertedValue();

        if (initial == null || initial.isEmpty()) {
            showError("Please type initial value.");
            return;
        }

        int radioBtnId = endiannessType.getSelectedId();
        String radioValue = ((RadioButton)findViewById(radioBtnId)).getText().toString();
        Log.log("Endianness Type = " + radioValue);
        boolean isLittle = radioValue.toLowerCase().contains("little");
        convertedEndiannessValue = Calculate.convertEndianness(initial, isLittle);

        updateValueOnUi(endiannessResult, convertedEndiannessValue);

    }

    public void onConvertParityClick(View view) {
        String initial = parityInput.getConvertedValue();

        if (initial == null || initial.isEmpty()) {
            showError("Please type initial value.");
            return;
        }
        long convertedInitial;
        try {
            convertedInitial = Long.parseLong(initial);
        }catch (Exception e){
            e.printStackTrace();
            showError("Incorrect Initial Parity value: " + initial);
            return;
        }
        Log.log("[Parity] Binary representation of the number: " + Long.toBinaryString(convertedInitial));

        String computeParityBruteForce = String.valueOf(ParityOfNumber.computeParityBruteForce(convertedInitial));
        String computeParityBasedOnClearingSetBit = String.valueOf(ParityOfNumber.computeParityBasedOnClearingSetBit(convertedInitial));
        String computeParityMostEfficient = String.valueOf(ParityOfNumber.computeParityMostEfficient(convertedInitial));
        String computeParityWithCaching = String.valueOf(ParityOfNumber.computeParityWithCaching(convertedInitial));

        updateValueOnUi(parityBruteForce, computeParityBruteForce);
        updateValueOnUi(parityBasedOnClearingSetBit, computeParityBasedOnClearingSetBit);
        updateValueOnUi(parityMostEfficient, computeParityMostEfficient);
        updateValueOnUi(parityWithCaching, computeParityWithCaching);

    }




}
