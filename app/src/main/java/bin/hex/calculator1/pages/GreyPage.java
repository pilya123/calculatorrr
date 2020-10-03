package bin.hex.calculator1.pages;

import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;

import bin.hex.calculator1.CalculatorState;
import bin.hex.calculator1.R;
import bin.hex.calculator1.elements.InputElement;
import bin.hex.calculator1.listeners.GreySelectListener;
import bin.hex.calculator1.math.Calculate;
import bin.hex.calculator1.math.GrayCode;

import static android.widget.Toast.makeText;

public class GreyPage extends AbstractPage {

    private InputElement greyInput, greyOutput, grey1_of_n_input, grey1_of_n_output, greyValueInputK, greyValueInputN, greyK_of_N_output;

//    private Spinner greyTypeSelect;

    private String greyResultValue = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gray);

        greyInput = new InputElement(findViewById(R.id.grey_input));
        greyOutput = new InputElement(findViewById(R.id.output_gray_bin_hex));
        grey1_of_n_input = new InputElement(findViewById(R.id.grey_one_of_n_input));
        grey1_of_n_output = new InputElement(findViewById(R.id.grey_one_of_n_output));

        greyValueInputK = new InputElement(findViewById(R.id.gray_k_input));
        greyValueInputN = new InputElement(findViewById(R.id.gray_n_input));
        greyK_of_N_output = new InputElement(findViewById(R.id.grey_k_of_n_output));

//        greyTypeSelect = addListenerOnConvertTypeSpinner(new GreySelectListener(), R.id.gray_type_spinner);

    }

    public void onGreyConvertClick(View view){
        Calculate.GreyConvertType type = Calculate.GreyConvertType.GREY_TO_BIN;//CalculatorState.getGreyConvertType();
        String initial = greyInput.getConvertedValue();

        if(initial == null || initial.isEmpty()){
            showError("Please type initial value.");
            return;
        }

        switch (type){
            default:
                showError("Please select a valid convert type.");
                return;
            case GRAY_TO_HEX:
                greyResultValue = Calculate.greyToHex(initial);
                break;
            case GREY_TO_BIN:
                greyResultValue = Calculate.convertGrayToBin(initial);
                break;

        }

        updateValueOnUi(greyOutput, greyResultValue);

    }

    public void onGray1ofNClick(View view){
        String initial = grey1_of_n_input.getConvertedValue();
        String result = "";

        if(initial == null || initial.isEmpty()){
            showError("Please type initial value.");
            return;
        }
        try {
            int initialConverted = Integer.parseInt(initial);
            result = GrayCode.generateGrayarr(initialConverted);
        }catch (NumberFormatException e){
            showError("Only Integer is allowed for Grey 1 of N input.");
        }
        updateValueOnUi(grey1_of_n_output, result);
    }

    public void onGrayKofNClick(View view){
        String k = greyValueInputK.getConvertedValue();
        String n = greyValueInputN.getConvertedValue();
        String result = "";

        if(k == null || k.isEmpty() || n == null || n.isEmpty()){
            showError("Please type initial value.");
            return;
        }
        try {
            int initialK = Integer.parseInt(k);
            int initialN = Integer.parseInt(n);
            result = GrayCode.gray_K_of_N(initialN, initialK);
        }catch (NumberFormatException e){
            showError("Only Integer is allowed for Grey K of N input.");
        }
        updateValueOnUi(greyK_of_N_output, result);
    }

}
