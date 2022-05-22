package org.unibl.etf.oos;

import java.util.HashMap;

public class SC extends Algoritam{
    int rBit;
    SC(int brojOkvira, int brojReferenci, int []nizReferenci, int rBit){super(brojOkvira,brojReferenci,nizReferenci); this.rBit = rBit;}

    HashMap<Integer,Boolean> mapa = new HashMap<Integer, Boolean>();

    void popuniHashMapu(){
        for(int i=0;i<brojReferenci;i++){
            if(nizReferenci[i]!=rBit) {
                mapa.put(nizReferenci[i],false);
            } else{
                mapa.put(nizReferenci[i],true);
            }
        }
    }

    @Override
    void popuniMatricu() {
        upisiPrviRed();
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
            } else{
                if(matrica[1][i]=="PF") {
                    if(i>2 && mapa.get(Integer.parseInt(matrica[brojOkvira+1][i-1])) && Integer.parseInt(matrica[brojOkvira+1][i-1])!=nizReferenci[i]){
                        mapa.put(rBit,false);
                        matrica[2][i] = String.valueOf(nizReferenci[i]);
                        matrica[3][i] = String.valueOf(rBit);
                        int j=4;
                        for(int k = 2; j<brojOkvira+2;k++){
                            if(matrica[k][i-1] != String.valueOf(rBit)) {
                                matrica[j][i] = matrica[k][i - 1];
                                j++;
                            }
                        }
                    }
                    else{
                            if(nizReferenci[i] == rBit){mapa.put(rBit,true);}
                            matrica[2][i] = String.valueOf(nizReferenci[i]);
                            for (int k = 3; k < brojOkvira + 2; k++) {
                                matrica[k][i] = matrica[k - 1][i - 1];
                            }
                        }
                } else{
                        if(nizReferenci[i] == rBit){mapa.put(rBit,true);}
                        for(int k = 2; k<brojOkvira+2;k++){
                        matrica[k][i] = matrica[k][i-1];
                        }
                    }
                    }
                }

    }
}
