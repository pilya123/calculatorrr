package bin.hex.calculator1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import bin.hex.calculator1.pages.GreyPage;
import bin.hex.calculator1.pages.HammingParityPage;
import bin.hex.calculator1.pages.IEEEConverter_v2;
import bin.hex.calculator1.pages.IEEECoverterPage;
import bin.hex.calculator1.pages.MainCalculator;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.open_main_screen);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPage(MainCalculator.class);
            }
        });

//        Button button2 = findViewById(R.id.IEEE_converter);
//        button2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                openPage(IEEECoverterPage.class);
//            }
//        });

        Button button3 = findViewById(R.id.IEEE_converter_v2);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPage(IEEEConverter_v2.class);
            }
        });

        Button button4 = findViewById(R.id.grey_activity_btn);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPage(GreyPage.class);
            }
        });

        Button button5 = findViewById(R.id.hamming_parity);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPage(HammingParityPage.class);
            }
        });

    }

    private void openPage(Class <?> clss){
        Intent intent = new Intent(this, clss);
        startActivity(intent);
    }



}
