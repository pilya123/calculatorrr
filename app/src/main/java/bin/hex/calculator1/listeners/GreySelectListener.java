package bin.hex.calculator1.listeners;

import android.view.View;
import android.widget.AdapterView;

import bin.hex.calculator1.CalculatorState;
import bin.hex.calculator1.math.Calculate;
import bin.hex.calculator1.util.Log;

public class GreySelectListener implements AdapterView.OnItemSelectedListener {

    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        String value = parent.getItemAtPosition(pos).toString();
        CalculatorState.setGreyConvertType(Calculate.GreyConvertType.get(value));
        Log.log("Value selected: " + value);

    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }

}
