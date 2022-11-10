package dev.tomco.a23a_10357_l02;

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

    public void checkAnswer(boolean answer){
        if (current().isInNato() == answer)
            score += current().getScore();
        else
            wrong++;

        index++;
    }
}
