package bin.hex.calculator1.pages;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import bin.hex.calculator1.R;

import static android.widget.Toast.makeText;

public class GreyPage extends AbstractPage {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gray);
    }

}
