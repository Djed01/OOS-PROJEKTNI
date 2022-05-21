package org.unibl.etf.oos;

public abstract class Algoritam {
    int brojOkvira;
    int brojReferenci;
    int nizReferenci[] = new int[brojReferenci];
    int matrica[][] = new int[brojOkvira+2][brojReferenci];

    Algoritam(){
        super();
    }
    Algoritam(int brojOkvira,int brojReferenci,int []nizReferenci){
        this.brojOkvira = brojOkvira;
        this.brojReferenci = brojReferenci;
        this.nizReferenci = nizReferenci;
    }

    void upisiPrviRed(int matrica[][]){
        for(int i=0;i<brojReferenci;i++)
            matrica[0][i]=nizReferenci[i];
    }


}
