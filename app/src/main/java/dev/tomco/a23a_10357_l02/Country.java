package dev.tomco.a23a_10357_l02;

public class Country {

    private int imageRes;
    private String name;
    private int score;
    private boolean inNato;

    public Country() {
    }

    public int getImageRes() {
        return imageRes;
    }

    public Country setImageRes(int imageRes) {
        this.imageRes = imageRes;
        return this;
    }

    public String getName() {
        return name;
    }

    public Country setName(String name) {
        this.name = name;
        return this;
    }

    public int getScore() {
        return score;
    }

    public Country setScore(int score) {
        this.score = score;
        return this;
    }

    public boolean isInNato() {
        return inNato;
    }

    public Country setInNato(boolean inNato) {
        this.inNato = inNato;
        return this;
    }
}
