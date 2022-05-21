package org.unibl.etf.oos;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int n,r;
        String tipAlgoritma;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Unesite broj okvira: ");
        n = scanner.nextInt();
        System.out.print("Unesite broj referenci:");
        r = scanner.nextInt();

        int nizReferecni[] = new int[r];
        for(int i=0;i<r;i++){
            System.out.print("Referenca["+(i+1)+"]: ");
            nizReferecni[i] = scanner.nextInt();
        }

        do {
            System.out.print("Izaberite algoritam:");
            tipAlgoritma = scanner.nextLine();
        } while (!tipAlgoritma.toUpperCase().equals("FIFO"));

        switch (tipAlgoritma.toUpperCase()){
            case "FIFO":
            {
                FIFO fifo = new FIFO(n,r,nizReferecni);
                fifo.upisiPrviRed();
                fifo.popuniMatricu();
                fifo.ispisiMatricu();
            }
                break;
            case "LRU":
                //LRU ALGO
                break;
            case "SC":
                //Secound chance
                break;
            case "LFU":
                //LFU
                break;
            case "OPTIMALNI":
                //Optimalni algoritam
                break;
            default:
                System.out.println("EXCEPTION!");
        }

    }
}
