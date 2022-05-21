package org.unibl.etf.oos;

public abstract class Algoritam {
    int brojOkvira;
    int brojReferenci;
    int nizReferenci[] = new int[brojReferenci];
    String matrica[][];

    Algoritam(int brojOkvira, int brojReferenci, int []nizReferenci){
        this.brojOkvira = brojOkvira;
        this.brojReferenci = brojReferenci;
        this.nizReferenci = nizReferenci;
        this.matrica = new String[brojOkvira+2][brojReferenci];
    }

    void  popuniMatricu(){

    }

    void upisiPrviRed(){
        for(int i=0;i<brojReferenci;i++)
            matrica[0][i]=String.valueOf(nizReferenci[i]);
    }

    void ispisiMatricu( ){
        for (int j = 0; j < brojOkvira + 2; j++)
        {
            System.out.println("\n");
            for(int i=0;i<brojReferenci;i++)
                System.out.printf("%3s",matrica[j][i]);
        }
    }

    boolean trebaUpisatiPF(int trenutnaKolona,int referenca){
        if(trenutnaKolona==0){
            return true;
        }
        for(int i=2;i<brojOkvira+2;i++){
            if (String.valueOf(referenca).equals(matrica[i][trenutnaKolona - 1] )) {
                return false;
            }
        }

        return true;
    }


}
