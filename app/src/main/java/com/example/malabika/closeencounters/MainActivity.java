package com.example.malabika.closeencounters;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class MainActivity extends AppCompatActivity {
   public  static String EMOJI_FRAGMENT = "EMOJI_FRAGMENT";
    public static String base_url = "https://bemyapp.herokuapp.com/";

    @Bind(R.id.background_image)
    RelativeLayout backgroundImage;

    @Bind(R.id.book_title)
    TextView titleText;

    @Bind(R.id.book_author)
    TextView author;

    @Bind(R.id.smiley_minibar)
    RelativeLayout emojiSlider;

    //TODO: include the overlay of zoomed in emojis
    //TODO: Include the cluster
    //TODO: Slide bar with the emoji data

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        emojiSlider.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Toast.makeText(getApplicationContext(), "OPENING SLIDER", Toast.LENGTH_SHORT).show();
                getSupportFragmentManager().beginTransaction().add(R.id.background_image,
                        EmojiSliderActivity.newInstance(),EMOJI_FRAGMENT).commit();
                return false;
            }
        });

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(base_url)
                .build();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void setImageBookCover() {
        ImageView bookImage = (ImageView) findViewById(R.id.book_image);
    }

}
