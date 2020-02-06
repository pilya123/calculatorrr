package bin.hex.calculator1.elements;

import android.view.View;
import android.widget.EditText;

public class InputElement {

    private EditText view;

    public InputElement(View v){
        this.view = (EditText) v;
    }

    public Long getConvertedValue(){
        return Long.getLong(view.getText().toString());
    }

    public void clear(){
        view.getText().clear();
    }

}
