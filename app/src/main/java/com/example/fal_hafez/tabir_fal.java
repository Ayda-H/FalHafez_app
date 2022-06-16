package com.example.fal_hafez;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;
import java.util.Random;

import com.example.fal_hafez.model.Faal;
import com.example.fal_hafez.network.FalAPI;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class tabir_fal extends AppCompatActivity {
    TextView poet, num;
    ImageView back;
    String random_string = "";
    ImageView again;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabir_fal);

        poet = findViewById(R.id.textView5);
        num = findViewById(R.id.resault);

        back = findViewById(R.id.imageView8);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(tabir_fal.this, MainActivity.class);
                startActivity(intent);
    }
});


        textView = findViewById(R.id.textView6);
        again = findViewById(R.id.againfal);
        again.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFaal();

            }
        });



        getFaal();

        int random_string_length = 5;
        String[] all_characters = {
                "از کار خیر دست برندار و دل دیگران را به دست بیاور. انسانی خیر باش. خداوند نیز یاور شما خواهد بود. اگر رکود موقتی در کار شما حادث شده، علتش ناشکری سال گذشته شما بود.",
                "از آنجایی که زندگی آرام داشته ای طاقت تحمل سختیها را نداری، اما بدان که اگر می خواهی به مقصود خود برسی باید رنج و مشقت بسیاری را تحمل نمایی. انسانهای بسیاری همچون تو در این راه قدم گذاشته اند و با صبر و بردباری به مقصود رسیده اند. ",
                "روزهای خوبی در پیش رو خواهی داشت. به زودی اتفاقات بسیار مثبتی در زندگیت روی می دهد که زندگیت را رونقی تازه می بخشد. به یاری خدا درهای بسته به رویت گشوده خواهد شد. در حال حاضر صلاح نیست که کار خود را عوض کنی. به کار قبلی خود ادامه بده .",
                "اگر قصد انجام این نیت را داری باید در مقابل مشکلات و سختی های این راه ناهموار صبر و تحمل داشته باشی و با شکیبایی قدم به قدم پیش بروی و بدان که هرچه انسانی دارای مقام و قدرت باشد، بدون یاری خدا از عهده هیچ کاری بر نخواهد آمد. پس به خدا توکل کن .",
                "شما اکنون در بهار عمر خود به سر می برید و بهتر آن است که تا آنجا که می توانی از لذت های زندگی استفاده کنی و زندگی را بر خود و دیگران سخت نگیری. از چشم حسودان و بدخواهان به خدا پناه ببر و از نعماتی که خدا در اختیارت گذارده است، نهایت استفاده را ببر .",
                "عزیزی را از دست داده ای که می اندیشی هیچ کس در دنیا جای خالی او را برایت پر نمی کند و این موضوع تو را به شدت غمناک و بی تاب کرده است. فکر می کنی تمام زندگیت به او وابسته بود و اکنون که او رفته زندگی تو نیز فنا شده است. \n"
        };
        int all_characters_length = all_characters.length;

        int min = 0;
        int max = all_characters_length - 1;


        Random r = new Random();
        int random_number = r.nextInt(max - min + 1) + min;
        String random_character = all_characters[random_number];
        random_string = random_string + random_character;
    }


    private void getFaal () {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(FalAPI.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        FalAPI falApi = retrofit.create(FalAPI.class);
        Call<Faal> call = falApi.getFal();
        call.enqueue(new Callback<Faal>() {
            @Override
            public void onResponse(Call<Faal> call, Response<Faal> response) {
                if (response.isSuccessful()) {
                    Faal faal = response.body();
                    num.setText(faal.getTitle());
                    poet.setText(faal.getPlainText());
                    textView.setText(random_string);
                }
            }


            @Override
            public void onFailure(Call<Faal> call, Throwable t) {
                Toast.makeText(tabir_fal.this, "Fail to get the data..", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void onClickback(View view) {
        Intent intent1 = new Intent(tabir_fal.this, MainActivity.class);
        startActivity(intent1);
    }
}

