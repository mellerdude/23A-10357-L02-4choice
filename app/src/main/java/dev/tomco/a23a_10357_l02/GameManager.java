package dev.tomco.a23a_10357_l02;

import android.content.Context;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;

import java.util.ArrayList;

public class GameManager {

    private int score = 0;
    private int index = 0;
    private int wrong = 0;
    private int life;

    private ArrayList<Country> countries;

    public GameManager(int life) {
        this.life = life;
        countries = DataManager.getCountries();
    }

    private Country current() {
        return countries.get(index);
    }

    public int getScore() {
        return score;
    }

    public int getCurrentFlag() {
        return current().getImageRes();
    }

    public String getCurrentName() {
        return current().getName();
    }

    public int getWrong() {
        return wrong;
    }

    public boolean isGameEnded(){
        return index == countries.size();
    }

    public boolean isLose(){
        return life == wrong;
    }

    public void checkAnswer(Vibrator v, boolean answer){
        if (current().isInNato() == answer)
            score += current().getScore();
        else {
            wrong++;
            // Vibrate for 500 milliseconds
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                v.vibrate(VibrationEffect.createOneShot(500, VibrationEffect.DEFAULT_AMPLITUDE));
            } else {
                //deprecated in API 26
                v.vibrate(500);
            }
        }
        index++;
    }
}
