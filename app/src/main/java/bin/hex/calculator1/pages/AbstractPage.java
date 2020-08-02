package bin.hex.calculator1.pages;

import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import bin.hex.calculator1.elements.InputElement;
import bin.hex.calculator1.util.Log;

import static android.widget.Toast.makeText;

public abstract class AbstractPage extends AppCompatActivity {

    protected void showError(String msg){
        makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    protected void updateValueOnUi(InputElement input, String value){
        input.setValue(value);
        Log.log("Input was updated with '"+ value +"'.");
    }
}
