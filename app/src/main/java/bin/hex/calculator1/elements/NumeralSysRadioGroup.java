package bin.hex.calculator1.elements;

import android.widget.RadioGroup;
import android.widget.Toast;

import bin.hex.calculator1.math.Calculate;
import bin.hex.calculator1.util.Log;

import static android.widget.Toast.makeText;

public class NumeralSysRadioGroup extends RadioGroupElement{


    public NumeralSysRadioGroup(RadioGroup group){
        super(group);
    }

//    public Calculate.NumeralSystem getSelectedSystem(){
//        String option = super.getSelectedText();
//        switch (option.toLowerCase()){
//            default:
//                String msg = "Unknown numeral system '"+option+"'";
//                Log.log(msg);
//                return null;
//            case "bin":
//                return Calculate.NumeralSystem.BIN;
//            case "dec":
//                return Calculate.NumeralSystem.DEC;
//            case "hex":
//                return Calculate.NumeralSystem.HEX;
//
//        }
//
//    }
}
