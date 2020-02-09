package bin.hex.calculator1.elements;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class InputElement {

    private EditText view;

    public InputElement(View v){
        this.view = (EditText) v;
    }

    public Integer getConvertedValue(){
        String value = view.getText().toString();
        if(value.isEmpty()){
            return 0;
        }
        return Integer.parseInt(view.getText().toString());
    }

    public void clear(){
        view.getText().clear();
    }

    public void setValue(String v){
        view.setText(v, TextView.BufferType.EDITABLE);
    }

}
