package org.unibl.etf.oos;

public class LRU extends Algoritam {

    LRU(int brojOkvira, int brojReferenci, int []nizReferenci){super(brojOkvira,brojReferenci,nizReferenci);}

    @Override
    void  popuniMatricu(){
        for(int i=0;i<brojReferenci;i++){
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
                if(matrica[1][i]=="PF") {
                    matrica[2][i] = String.valueOf(nizReferenci[i]);
                    for (int k = 3; k < brojOkvira + 2; k++) {
                        matrica[k][i] = matrica[k - 1][i - 1];
                    }
                }
                else{
                    matrica[2][i] = String.valueOf(nizReferenci[i]);
                    int k=3;
                    for(int j=2;j<brojOkvira+2;j++)
                    {
                        if(!String.valueOf(nizReferenci[i]).equals(matrica[j][i-1])){
                            matrica[k][i] = matrica[j][i-1];
                            k++;
                        }
                    }
                }

            }
        }
    }
}
