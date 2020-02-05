package bin.hex.calculator1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView number_1, number_2, number_of_bits_to_shift;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number_1 = findViewById(R.id.input_number_1);
        number_2 = findViewById(R.id.input_number_2);
        number_of_bits_to_shift = findViewById(R.id.number_of_bits_to_shift);







    }
}
