package bin.hex.calculator1.elements;

import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import bin.hex.calculator1.util.Log;


public class RadioGroupElement extends AppCompatActivity {
    private  RadioGroup group;

    public RadioGroupElement(RadioGroup group){
        this.group = group;
    }

    public int getSelectedId(){
        return group.getCheckedRadioButtonId();
    }

//    String getSelectedText(){
//        int id = getSelectedId();
//        if(id == 0){
//            Log.log("Radiobutton was not selected.");
//        }
//
//        return new RadioButtonElement(id)
//                .getText();
//    }



//    public class RadioButtonElement {
//        RadioButton button;
//
//        private RadioButtonElement(int id){
//            if(id == 0){
//                Log.log("Radiobutton was not shown.");
//            }
//            this.button = findViewById(id);
//        }
//
//        String getText(){
//            return button.getText().toString();
//        }
//
//    }

}
