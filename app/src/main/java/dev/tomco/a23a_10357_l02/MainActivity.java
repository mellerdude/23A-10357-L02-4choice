package dev.tomco.a23a_10357_l02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.textview.MaterialTextView;

public class MainActivity extends AppCompatActivity {

    private MaterialTextView main_LBL_score;
    private MaterialTextView main_LBL_name;
    private MaterialButton main_BTN_yes;
    private MaterialButton main_BTN_no;
    private ShapeableImageView main_IMG_flag;
    private ShapeableImageView[] main_IMG_hearts;

    private GameManager gameManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
        gameManager = new GameManager(main_IMG_hearts.length);

        refreshUI();

        main_BTN_yes.setOnClickListener(view -> {
            clicked(true);
        });
        main_BTN_no.setOnClickListener(view -> {
            clicked(false);
        });
    }

    private void findViews() {
        main_LBL_score = findViewById(R.id.main_LBL_score);
        main_LBL_name = findViewById(R.id.main_LBL_name);
        main_BTN_yes = findViewById(R.id.main_BTN_yes);
        main_BTN_no = findViewById(R.id.main_BTN_no);
        main_IMG_flag = findViewById(R.id.main_IMG_flag);
        main_IMG_hearts = new ShapeableImageView[]{
                findViewById(R.id.main_IMG_heart1),
                findViewById(R.id.main_IMG_heart2),
                findViewById(R.id.main_IMG_heart3),
                findViewById(R.id.main_IMG_heart4)
        };
    }

    private void clicked(boolean answer) {
        gameManager.checkAnswer(answer);
        refreshUI();
    }

    private void refreshUI() {
        if (gameManager.isLose()) {
            main_LBL_score.setText("Game Over: " + gameManager.getScore());
        } else if (gameManager.isGameEnded()) {
            main_LBL_score.setText("Winner! " + gameManager.getScore());
        } else {
            main_IMG_flag.setImageResource(gameManager.getCurrentFlag());
            main_LBL_name.setText(gameManager.getCurrentName());
            main_LBL_score.setText("" + gameManager.getScore());
            for (int i = main_IMG_hearts.length - 1; i >= main_IMG_hearts.length - gameManager.getWrong(); i--) {
                main_IMG_hearts[i].setVisibility(View.INVISIBLE);
            }
        }
    }


}