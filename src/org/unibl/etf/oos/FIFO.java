package org.unibl.etf.oos;

public class FIFO {
    int brojOkvira;
    int brojReferenci;
    int nizReferenci[] = new int[brojReferenci];
    String matrica[][];

    FIFO(int brojOkvira, int brojReferenci, int []nizReferenci){
        this.brojOkvira = brojOkvira;
        this.brojReferenci = brojReferenci;
        this.nizReferenci = nizReferenci;
        this.matrica = new String[brojOkvira+2][brojReferenci];
    }

    void upisiPrviRed(){
        for(int i=0;i<brojReferenci;i++)
            matrica[0][i]=String.valueOf(nizReferenci[i]);
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


    void ispisiMatricu( ){
             for (int j = 0; j < brojOkvira + 2; j++)
             {
                 System.out.println("\n");
                for(int i=0;i<brojReferenci;i++)
                 System.out.printf("%3s",matrica[j][i]);
             }
    }

    void popuniMatricu(){

        for(int i=0;i<brojReferenci;i++)
        {
            if(trebaUpisatiPF(i,nizReferenci[i])){
                matrica[1][i]="PF";
            }
            else{
                matrica[1][i]="  ";
            }
            if(i==0){
                matrica[2][i]=String.valueOf(nizReferenci[i]);
                for(int j=3;j<brojOkvira+2;j++)
                    matrica[j][i]="  ";
            }
            else{
                if(matrica[1][i]=="PF"){
                    matrica[2][i]=String.valueOf(nizReferenci[i]);
                    for(int k = 3; k < brojOkvira+2; k++){
                        matrica[k][i] = matrica[k-1][i-1];
                    }
                }
                else {
                    for(int k = 2; k<brojOkvira+2;k++){
                        matrica[k][i] = matrica[k][i-1];
                    }
            }
            }
        }
    }




}
