package bin.hex.calculator1.pages;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import bin.hex.calculator1.MainActivity;
import bin.hex.calculator1.R;

public class Activity1 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

        Button button = findViewById(R.id.open_main_screen);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainCalPage();
            }
        });

        Button button2 = findViewById(R.id.IEEE_converter);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openIEEEConverter();
            }
        });
    }

    private void openMainCalPage(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void openIEEEConverter(){
        Intent intent = new Intent(this, IEEECoverterPage.class);
        startActivity(intent);
    }



}
