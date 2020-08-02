package bin.hex.calculator1.pages;

import android.os.Bundle;
import android.view.View;

import bin.hex.calculator1.R;
import bin.hex.calculator1.elements.InputElement;
import bin.hex.calculator1.math.Calculate;
import bin.hex.calculator1.util.Log;

public class HammingParityPage extends AbstractPage {

    private InputElement hammingInput, hammingResult, endiannessInput, endiannessResult;
    private String convertedHammingValue, convertedEndiannessValue = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hamming__parity_endianness);

        hammingInput = new InputElement(findViewById(R.id.input_hamming_value));
        hammingResult = new InputElement(findViewById(R.id.output_hamming_value));

        endiannessInput = new InputElement(findViewById(R.id.input_endianness_value));
        endiannessResult = new InputElement(findViewById(R.id.output_endianness));
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
        convertedEndiannessValue = Calculate.convertEndianness(initial);

        updateValueOnUi(endiannessResult, convertedEndiannessValue);

    }




}
