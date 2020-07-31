package bin.hex.calculator1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import bin.hex.calculator1.pages.IEEEConverter_v2;
import bin.hex.calculator1.pages.IEEECoverterPage;
import bin.hex.calculator1.pages.MainCalculator;

public class MainActivity extends AppCompatActivity {


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

//        Button button3 = findViewById(R.id.IEEE_converter_v2);
//        button3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                openIEEEConverter_v2();
//            }
//        });

    }

    private void openMainCalPage(){
        Intent intent = new Intent(this, MainCalculator.class);
        startActivity(intent);
    }

    private void openIEEEConverter(){
        Intent intent = new Intent(this, IEEECoverterPage.class);
        startActivity(intent);
    }

    private void openIEEEConverter_v2(){
        Intent intent = new Intent(this, IEEEConverter_v2.class);
        startActivity(intent);
    }



}
