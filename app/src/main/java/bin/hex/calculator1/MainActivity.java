package bin.hex.calculator1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import bin.hex.calculator1.elements.InputElement;

public class MainActivity extends AppCompatActivity {

    InputElement inputNumber_1, inputNumber_2, inputNumberOfBitsToShift;
    Long number1, number2, numberOfBitsToShift;

    Button calculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputNumber_1 = new InputElement(findViewById(R.id.input_number_1));
        inputNumber_2 = new InputElement(findViewById(R.id.input_number_2));
        inputNumberOfBitsToShift = new InputElement(findViewById(R.id.input_number_of_bits_to_shift));

        calculate = findViewById(R.id.calculate_btn);

    }

    public void onCalculate(View v){
        Button btn = (Button) v;

        number1 = inputNumber_1.getConvertedValue();
        number2 = inputNumber_2.getConvertedValue();
        numberOfBitsToShift = inputNumberOfBitsToShift.getConvertedValue();

        //TODO: make calculation Calculate...

        updateResultsFields();

    }

    private void updateResultsFields(){
        //TODO:
    }

    public void onResetClick(View v){
        Button btn = (Button) v;

        inputNumber_1.clear();
        inputNumber_2.clear();
        inputNumberOfBitsToShift.clear();


    }


}
