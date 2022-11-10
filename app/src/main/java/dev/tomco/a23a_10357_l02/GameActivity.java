package dev.tomco.a23a_10357_l02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.textview.MaterialTextView;

public class GameActivity extends AppCompatActivity {

    private MaterialTextView game_LBL_score;
    private MaterialTextView game_LBL_name;
    private MaterialButton game_BTN_yes;
    private MaterialButton game_BTN_no;
    private ShapeableImageView game_IMG_flag;
    private ShapeableImageView[] game_IMG_hearts;

    private GameManager gameManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        findViews();
        gameManager = new GameManager(game_IMG_hearts.length);

        refreshUI();

        game_BTN_yes.setOnClickListener(view -> {
            clicked(true);
        });
        game_BTN_no.setOnClickListener(view -> {
            clicked(false);
        });
    }

    private void findViews() {
        game_LBL_score = findViewById(R.id.game_LBL_score);
        game_LBL_name = findViewById(R.id.game_LBL_name);
        game_BTN_yes = findViewById(R.id.game_BTN_yes);
        game_BTN_no = findViewById(R.id.game_BTN_no);
        game_IMG_flag = findViewById(R.id.game_IMG_flag);
        game_IMG_hearts = new ShapeableImageView[]{
                findViewById(R.id.game_IMG_heart1),
                findViewById(R.id.game_IMG_heart2),
                findViewById(R.id.game_IMG_heart3),
                findViewById(R.id.game_IMG_heart4)
        };
    }

    private void clicked(boolean answer) {
        gameManager.checkAnswer(answer);
        refreshUI();
    }

    private void refreshUI() {
        if (gameManager.isLose()) {
            openScoreScreen("Game Over", gameManager.getScore());
        } else if (gameManager.isGameEnded()) {
            openScoreScreen("Winner", gameManager.getScore());
        } else {
            game_IMG_flag.setImageResource(gameManager.getCurrentFlag());
            game_LBL_name.setText(gameManager.getCurrentName());
            game_LBL_score.setText("" + gameManager.getScore());
            if (gameManager.getWrong()!= 0)
                game_IMG_hearts[game_IMG_hearts.length-gameManager.getWrong()].setVisibility(View.INVISIBLE);
        }
    }

    private void openScoreScreen(String status, int score) {
        Intent scoreIntent = new Intent(this, ScoreActivity.class);
        scoreIntent.putExtra(ScoreActivity.KEY_SCORE,score);
        scoreIntent.putExtra(ScoreActivity.KEY_STATUS,status);
        startActivity(scoreIntent);
        finish();
    }


}