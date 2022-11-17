package dev.tomco.a23a_10357_l02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;

import android.os.Bundle;

import com.bumptech.glide.Glide;

public class RaceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_race);
        AppCompatImageView race_IMG_background = findViewById(R.id.race_IMG_background);

        Glide
                .with(this)
                .load("https://soccerprime.com/wp-content/uploads/2020/08/soccer-field.jpg")
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(race_IMG_background);
    }
}