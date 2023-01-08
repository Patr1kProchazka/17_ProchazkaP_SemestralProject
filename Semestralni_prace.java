/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package semestralni_prace;

import java.util.Scanner;

/**
 *
 * @author pproc
 */
public class Semestralni_prace {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cislo;

        do {
            menu();
            System.out.print("Zadej svojí volbu: ");
            cislo = sc.nextInt();
            System.out.println();
            switch (cislo) {
                case 1:
                    vanocniUloha();
                    break;
                case 2:
                    semestralniPrace();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Nevalidní volba");
            }

        } while (cislo != 0);
    }

    public static void menu() {
        System.out.println("Vítej v semestrální práci, zvol si možnost");
        System.out.println("1: zobrazí vánoční program");
        System.out.println("2: zobrazí semestrální práci");
        System.out.println("0: ukončí program");
        System.out.println("");
    }

    public static void vanocniUloha() {
        Scanner sc = new Scanner(System.in);
        final int X = 9;

        try {

            System.out.println("Zadej symbol:");
            char symbol = sc.next().charAt(0);

            System.out.println("Zadej počet vloček:");
            int pocet = sc.nextInt();

            System.out.println("");

            for (int k = 0; k < pocet; k++) {

                for (int i = 0; i < X; i++) {
                    for (int j = 0; j < X; j++) {
                        if (i == j || i + j == X - 1 || j == X / 2 || i == X / 2) {
                            System.out.print(symbol + " ");
                        } else {
                            System.out.print("  ");
                        }
                    }
                    System.out.println();
                }
                System.out.println("");
                System.out.println("");
            }

        } catch (Exception e) {
            System.out.println("Někde se stala chyba");
        } finally {
            System.out.println("");
            System.out.println("Štastné a veselé");
        }

        System.out.println("");
    }

    public static void semestralniPrace() {
        Scanner sc = new Scanner(System.in);
        try {
            do {
                System.out.println("Zadej počet řádků: ");
                int radky = sc.nextInt();
                if (radky <= 0) {
                    break;
                }
                System.out.println("Zadej počet sloupců: ");
                int sloupce = sc.nextInt();
                System.out.println("Zadej velikost bloku: ");
                int krok = sc.nextInt();
                if (sloupce < 0 || krok < 0) {
                    throw new Exception("Zadej číslo větší nebo rovno 0");
                }
                int a = 0;
                int b = 0;
                int[][] sachovnice = new int[radky][sloupce];
                for (int i = 0; i < radky; i++) {
                    for (int l = 0; l < krok; l++) {
                        if (i * krok + l >= radky) {
                            break;
                        }
                        for (int j = 0; j < sloupce; j++) {
                            for (int k = 0; k < krok; k++) {
                                if (j * krok + k < sloupce) {
                                    if ((i + j) % 2 == 0) {
                                        sachovnice[a][b] = 0;
                                    } else {
                                        sachovnice[a][b] = 1;
                                    }
                                    b++;
                                }
                            }
                        }
                        a++;
                        b = 0;
                    }
                }
                for (int i = 0; i < sachovnice.length; i++) {
                    for (int j = 0; j < sachovnice[i].length; j++) {
                        System.out.print(sachovnice[i][j] + " ");
                    }
                    System.out.println();
                }
            } while (true);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        System.out.println();
    }
}
