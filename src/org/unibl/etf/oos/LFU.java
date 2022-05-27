package org.unibl.etf.oos;

import java.util.HashMap;

public class LFU extends Algoritam {

    LFU(int brojOkvira, int brojReferenci, int[] nizReferenci) {
        super(brojOkvira, brojReferenci, nizReferenci);
    }

    HashMap<Integer, Integer> mapa = new HashMap<Integer, Integer>();

    void popuniHashMapu() {
        for (int i = 0; i < brojReferenci; i++) {
            mapa.put(nizReferenci[i], 10);
        }
    }

    boolean sadrziReferencu(int i) {
        for (int j = 2; j < brojOkvira + 2; j++) {
            if (matrica[j][i - 1] != "  " && matrica[j][i - 1] != null)
                if (Integer.parseInt(matrica[j][i - 1]) == nizReferenci[i])
                    return true;
        }
        return false;
    }

    @Override
    void popuniMatricu() {
        popuniHashMapu();
        upisiPrviRed();
        for (int i = 0; i < brojReferenci; i++) {
            popuniPF(i);
            if (i == 0) {
                matrica[2][i] = String.valueOf(nizReferenci[i]);
                for (int j = 3; j < brojOkvira + 2; j++)
                    matrica[j][i] = "  ";
            } else {

                for (int j = 2; j < brojOkvira + 2; j++) {
                    if ((matrica[j][i - 1] != "  ") && (matrica[j][i - 1] != null) && (Integer.parseInt(matrica[j][i - 1]) != nizReferenci[i])) {
                        mapa.put(Integer.parseInt(matrica[j][i - 1]), mapa.get(Integer.parseInt(matrica[j][i - 1])) - 1);
                    } else if ((matrica[j][i - 1] != "  ") && (matrica[j][i - 1] != null) && (Integer.parseInt(matrica[j][i - 1]) == nizReferenci[i])) {
                        mapa.put(Integer.parseInt(matrica[j][i - 1]), mapa.get(Integer.parseInt(matrica[j][i - 1])) + 4);
                    }
                }
                if (!sadrziReferencu(i)) {
                    mapa.put(nizReferenci[i], 10);
                }

                int m = 0;
                int tempNiz[] = new int[brojOkvira + 1];
                tempNiz[m] = nizReferenci[i];
                m++;
                for (int k = 2; k < brojOkvira + 2; k++) {
                    if (matrica[k][i - 1] != "  " && matrica[k][i - 1] != null) {
                        if (Integer.parseInt(matrica[k][i - 1]) != nizReferenci[i]) {
                            tempNiz[m] = Integer.parseInt(matrica[k][i - 1]);
                            m++;
                        }
                    }
                }

                for (int k = 0; k < brojOkvira; k++) {
                    for (int n = k + 1; n < brojOkvira + 1; n++) {
                        if (tempNiz[k] != 0 && tempNiz[n] != 0) {
                            if (mapa.get(tempNiz[k]) < mapa.get(tempNiz[n])) {
                                int temp = tempNiz[k];
                                tempNiz[k] = tempNiz[n];
                                tempNiz[n] = temp;
                            }
                        }
                    }
                }
                m = 0;
                for (int j = 2; j < brojOkvira + 2; j++) {
                    if (tempNiz[m] != 0) {
                        matrica[j][i] = String.valueOf(tempNiz[m]);
                    } else {
                        matrica[j][i] = "  ";
                    }
                    m++;
                }


            }
        }
    }


}
