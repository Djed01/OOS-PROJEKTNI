package org.unibl.etf.oos;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int n,r;
        int tipAlgoritma;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Unesite broj okvira: ");
            n = scanner.nextInt();
        }while(n<0);
        do {
            System.out.print("Unesite broj referenci:");
            r = scanner.nextInt();
        }while (r<1);

        int nizReferecni[] = new int[r];
        for(int i=0;i<r;i++){
            System.out.print("Referenca["+(i+1)+"]: ");
            nizReferecni[i] = scanner.nextInt();
        }

        do {
            System.out.print("1-FIFO\n2-LRU\n3-SC\n4-LFU\n5-OPTIMALNI\n");
            System.out.print("Izaberite algoritam: ");
            tipAlgoritma = scanner.nextInt();
        } while ( tipAlgoritma>5 || tipAlgoritma< 1);

        switch (tipAlgoritma){
            case 1:
            {
                FIFO fifo = new FIFO(n,r,nizReferecni);
                fifo.upisiPrviRed();
                fifo.popuniMatricu();
                fifo.ispisiMatricu();
            }
                break;
            case 2: {
                LRU lru = new LRU(n, r, nizReferecni);
                lru.upisiPrviRed();
                lru.popuniMatricu();
                lru.ispisiMatricu();
            }
                break;
            case 3:
            {
                System.out.println("Unesite referencu koja ce imati R bit:");
                int rBit = scanner.nextInt();
                SC sc = new SC(n,r,nizReferecni,rBit);
                sc.popuniHashMapu();
                sc.popuniMatricu();
                sc.ispisiMatricu();
            }
                break;
            case 4:
                //LFU
                break;
            case 5:
                //Optimalni algoritam
                break;
            default:
                System.out.println("EXCEPTION!");
        }

    }
}
