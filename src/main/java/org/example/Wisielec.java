package org.example;

import java.util.Random;

public class Wisielec {
    private String[] slowa = {"Java", "programowanie", "klasa", "metoda", "zmienna", "obiekt", "interfejs"};
    private String slowo;
    private int liczbaProb;
    private int liczbaBledow;
    boolean[] odgadnieteLitery;

    public Wisielec() {
        this.losujSlowko();
        this.liczbaProb = 0;
        this.liczbaBledow = 0;
        this.odgadnieteLitery = new boolean[slowo.length()];
    }

    public void losujSlowko() {
        Random rand = new Random();
        int index = rand.nextInt(slowa.length);
        this.slowo = slowa[index];
    }

    public boolean odgadnijLitere(char litera) {
        boolean trafienie = false;
        for (int i = 0; i < slowo.length(); i++) {
            if (slowo.charAt(i) == litera) {
                odgadnieteLitery[i] = true;
                trafienie = true;
            }
        }
        if (!trafienie) {
            liczbaBledow++;
        }
        liczbaProb++;
        return trafienie;
    }

    public boolean czyOdgadniete() {
        for (int i = 0; i < slowo.length(); i++) {
            if (!odgadnieteLitery[i]) {
                return false;
            }
        }
        return true;
    }

    public boolean czyPrzegrana() {
        return liczbaBledow >= 7;
    }

    public int ileBledow() {
        return liczbaBledow;
    }

    public int ileProb() {
        return liczbaProb;
    }

    public String getSlowko() {
        return slowo;
    }
}
