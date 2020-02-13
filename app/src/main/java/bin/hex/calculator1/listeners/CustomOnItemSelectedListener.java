package bin.hex.calculator1.listeners;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import bin.hex.calculator1.MainActivity;
import bin.hex.calculator1.math.Calculate;
import bin.hex.calculator1.util.Log;

public class CustomOnItemSelectedListener implements AdapterView.OnItemSelectedListener {

    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        String value = parent.getItemAtPosition(pos).toString();
//        MainActivity.setBits(Calculate.Bit.get(value));
        Log.log("Value selected: " + value);
        Toast.makeText(parent.getContext(),
                "Converted to " + value,
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }

}
