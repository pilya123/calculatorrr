package bin.hex.calculator1.elements;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class InputElement {

    private EditText view;

    public InputElement(View v){
        this.view = (EditText) v;
    }

    public String getConvertedValue(){
        return view.getText().toString();
    }

    public void clear(){
        view.getText().clear();
    }

    public void setValue(String v){
        view.setText(v, TextView.BufferType.EDITABLE);
    }

}
