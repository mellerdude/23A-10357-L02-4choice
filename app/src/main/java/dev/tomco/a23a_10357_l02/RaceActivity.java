package dev.tomco.a23a_10357_l02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;

import android.os.Bundle;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class RaceActivity extends AppCompatActivity {

    MaterialButton race_BTN_toast;
    TextInputEditText race_ET_name;
    AppCompatImageView race_IMG_background;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_race);
        findViews();

        initViews();



    }

    private void initViews() {
        Glide
                .with(this)
                .load("https://soccerprime.com/wp-content/uploads/2020/08/soccer-field.jpg")
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(race_IMG_background);
        race_BTN_toast.setOnClickListener(view -> {
            toast();
        });
    }

    private void toast() {
        String name = String.valueOf(race_ET_name.getText());
        Toast
                .makeText(this,"Hello " + name,Toast.LENGTH_LONG)
                .show();
    }

    private void findViews() {
        race_IMG_background = findViewById(R.id.race_IMG_background);
        race_ET_name = findViewById(R.id.race_ET_name);
        race_BTN_toast = findViewById(R.id.race_BTN_toast);
    }
}