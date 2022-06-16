package com.example.fal_hafez;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import com.example.fal_hafez.R;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text=findViewById(R.id.text1);
        Typeface type=Typeface.createFromAsset(getAssets(),"fonts/IranNastaliq.ttf");
        text.setTypeface(type);

    }
    public void onclicktabir(View v) {
        Intent next = new Intent(this, tabir_fal.class);
        startActivity(next);

    }

    public void onclickshaeran(View v) {
        Intent biography = new Intent(this, shaeran.class);
        startActivity(biography);
    }
}