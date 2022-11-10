package dev.tomco.a23a_10357_l02;

import java.util.ArrayList;

public class DataManager {
    private static int[] flags = new int[]{
            R.drawable.img_australia,
            R.drawable.img_belarus,
            R.drawable.img_china,
            R.drawable.img_cuba,
            R.drawable.img_european_union,
            R.drawable.img_iraq,
            R.drawable.img_israel,
            R.drawable.img_kazakhstan,
            R.drawable.img_new_zealand,
            R.drawable.img_north_korea,
            R.drawable.img_southkorea,
            R.drawable.img_uk
    };
    private static String[] names = new String[]{
            "australia",
            "belarus",
            "china",
            "cuba",
            "european_union",
            "iraq",
            "israel",
            "kazakhstan",
            "new_zealand",
            "north_korea",
            "southkorea",
            "uk"
    };
    private static int[] scores = new int[]{
            10,
            20,
            10,
            10,
            10,
            10,
            10,
            20,
            20,
            10,
            20,
            10
    };
    private static boolean[] answers = new boolean[]{
            false,
            true,
            false,
            false,
            true,
            false,
            false,
            false,
            true,
            false,
            false,
            true
    };


    public static ArrayList<Country> getCountries(){
        ArrayList<Country> countries = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            Country c = new Country()
                    .setName(names[i])
                    .setScore(scores[i])
                    .setImageRes(flags[i])
                    .setInNato(answers[i]);

            countries.add(c);
        }
        return countries;
    }



}
