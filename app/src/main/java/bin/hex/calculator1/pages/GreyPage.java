package bin.hex.calculator1.pages;

import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;

import bin.hex.calculator1.CalculatorState;
import bin.hex.calculator1.R;
import bin.hex.calculator1.elements.InputElement;
import bin.hex.calculator1.listeners.GreySelectListener;
import bin.hex.calculator1.math.Calculate;

import static android.widget.Toast.makeText;

public class GreyPage extends AbstractPage {

    private InputElement greyInput, greyOutput;

    private Spinner greyTypeSelect;

    private String greyResultValue = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gray);

        greyInput = new InputElement(findViewById(R.id.grey_input));
        greyOutput = new InputElement(findViewById(R.id.output_gray_bin_hex));

        greyTypeSelect = addListenerOnConvertTypeSpinner(new GreySelectListener(), R.id.gray_type_spinner);

    }

    public void onGreyConvertClick(View view){
        Calculate.GreyConvertType type = CalculatorState.getGreyConvertType();
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
                greyResultValue = Calculate.convertToGray(initial);
                break;
            case GREY_TO_BIN:
                greyResultValue = Calculate.greyToHex(initial);

        }

        updateValueOnUi(greyOutput, greyResultValue);

    }

}
