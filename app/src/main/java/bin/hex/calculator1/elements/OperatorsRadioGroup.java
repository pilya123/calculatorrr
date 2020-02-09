package bin.hex.calculator1.elements;

import android.widget.RadioGroup;
import android.widget.Toast;

import bin.hex.calculator1.math.Calculate;
import bin.hex.calculator1.util.Log;

import static android.widget.Toast.makeText;

public class OperatorsRadioGroup extends RadioGroupElement{


    public OperatorsRadioGroup(RadioGroup group){
        super(group);
    }

//    public Calculate.Operator getSelectedOperator(){
//        String option = super.getSelectedText();
//        switch (option){
//            default:
//                String msg = "Unknown select operator '"+option+"'";
//                Log.log(msg);
//                makeText(OperatorsRadioGroup.this, msg, Toast.LENGTH_SHORT);
//                return null;
//            case "and":
//                return Calculate.Operator.AND;
//            case "or":
//                return Calculate.Operator.OR;
//            case "xor":
//                return Calculate.Operator.XOR;
//            case "not":
//                return Calculate.Operator.NOT;
//            case "sh_l":
//                return Calculate.Operator.SH_L;
//            case "sh_r":
//                return Calculate.Operator.SH_R;
//
//        }
//
//    }
}
