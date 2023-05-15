package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Gra {
    private Wisielec wisielec;

    public Gra(Wisielec wisielec) {
        this.wisielec = wisielec;
    }

    public void nowaGra() {
        wisielec.losujSlowko();
    }

    public boolean odgadnij(char litera) {
        return wisielec.odgadnijLitere(litera);
    }

    public boolean czyWygrana() {
        return wisielec.czyOdgadniete();
    }

    public boolean czyPrzegrana() {
        return wisielec.czyPrzegrana();
    }

    public int liczbaProb() {
        return wisielec.ileProb();
    }

    public int liczbaBledow() {
        return wisielec.ileBledow();
    }

    public String haslo() {
        String slowo = wisielec.getSlowko();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < slowo.length(); i++) {
            if (wisielec.odgadnieteLitery[i]) {
                sb.append(slowo.charAt(i)).append(" ");
            } else {
                sb.append("_ ");
            }
        }
        return sb.toString();
    }

    public boolean czyKoniec() {
        return czyPrzegrana() || czyWygrana();
    }
}
