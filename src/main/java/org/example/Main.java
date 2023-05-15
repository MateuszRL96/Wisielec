package org.example;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Wisielec wisielec = new Wisielec();
        Gra gra = new Gra(wisielec);

        System.out.println("Witaj w grze Wisielec!");

        boolean playAgain = true;
        while (playAgain) {
            gra.nowaGra();
            while (!gra.czyKoniec()) {
                System.out.println("Pozostało " + gra.liczbaProb() + " prób.");
                System.out.println("Hasło: " + gra.haslo());
                System.out.print("Podaj literę: ");
                String input = scanner.nextLine();
                if (input.length() == 1) {
                    gra.odgadnij(input.charAt(0));
                } else {
                    System.out.println("Podaj dokładnie jedną literę!");
                }
            }

            if (gra.czyWygrana()) {
                System.out.println("Brawo, odgadłeś hasło!");
            } else {
                System.out.println("Nie udało ci się odgadnąć hasła...");
                System.out.println("Hasło to: " + gra.haslo());
            }

            System.out.print("Czy chcesz zagrać jeszcze raz? (t/n): ");
            String input = scanner.nextLine();
            playAgain = input.equalsIgnoreCase("t");
        }

        System.out.println("Dziękujemy za grę!");
    }
}
