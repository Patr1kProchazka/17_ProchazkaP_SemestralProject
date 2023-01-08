/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package semestralni_prace;

import java.util.Scanner;

/**
 * 17. Program will display matrix with checkerboard pattern based on users
 * inputs
 *
 * @author pproc
 * @version 0.4 28/12/22
 */
public class Sachovnice {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        uzivateluvVstup();
        //vstupy();

    }

    /**
    * obdrží vstupy od uživatele
    */
    public static void uzivateluvVstup() {
        
        Scanner sc = new Scanner(System.in);
        try {
            do {
                System.out.println("Zadej počet řádků: ");
                int radky = sc.nextInt();
                if (radky <= 0) {
                    System.exit(0);
                }
                System.out.println("Zadej počet sloupců: ");
                int sloupce = sc.nextInt();
                System.out.println("Zadej velikost bloku: ");
                int krok = sc.nextInt();
                if (sloupce < 0 || krok < 0) {
                    throw new Exception("Zadej číslo větší nebo rovno 0");
                }
                int[][] sachovnice = matice(radky, sloupce, krok);
                vypisMatice(sachovnice);
            } while (true);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    /**
     * předem definované vstupy
     */
    public static void vstupy() {

        int radky = 6;
        int sloupce = 6;
        int krok = 2;
        int[][] sachovnice = matice(radky, sloupce, krok);
        vypisMatice(sachovnice);
        System.out.println();

        radky = 10;
        sloupce = 5;
        krok = 3;
        int[][] sachovnice1 = matice(radky, sloupce, krok);
        vypisMatice(sachovnice1);
        System.out.println();

        radky = 3;
        sloupce = 5;
        krok = 8;
        int[][] sachovnice2 = matice(radky, sloupce, krok);
        vypisMatice(sachovnice2);
        System.out.println();

        radky = 7;
        sloupce = 11;
        krok = 19;
        int[][] sachovnice3 = matice(radky, sloupce, krok);
        vypisMatice(sachovnice3);
        System.out.println();

        radky = 10;
        sloupce = 5;
        krok = 6;
        int[][] sachovnice4 = matice(radky, sloupce, krok);
        vypisMatice(sachovnice4);
    }
    
/**
 * metoda vytvoří matici se vzorem šachovnice
 * @param radky
 * @param sloupce
 * @param krok
 * @return 
 */
    public static int[][] matice(int radky, int sloupce, int krok) {
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
        return sachovnice;
    }

    /**
     * metoda zobrazí šachovnici
     * @param sachovnice 
     */
    public static void vypisMatice(int sachovnice[][]) {
        for (int i = 0; i < sachovnice.length; i++) {
            for (int j = 0; j < sachovnice[i].length; j++) {
                System.out.print(sachovnice[i][j] + " ");
            }
            System.out.println();
        }
    }
}
