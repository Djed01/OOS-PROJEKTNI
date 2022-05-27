package org.unibl.etf.oos;

import java.util.ArrayList;
import java.util.Arrays;

public class OPTIMALNI extends Algoritam {

    OPTIMALNI(int brojOkvira, int brojReferenci, int[] nizReferenci) {
        super(brojOkvira, brojReferenci, nizReferenci);
    }

    @Override
    void popuniMatricu() {
        upisiPrviRed();
        for (int i = 0; i < brojReferenci; i++) {
            if (trebaUpisatiPF(i, nizReferenci[i])) {
                matrica[1][i] = "PF";
            } else {
                matrica[1][i] = "  ";
            }
            if (i == 0) {
                matrica[2][i] = String.valueOf(nizReferenci[i]);
                for (int j = 3; j < brojOkvira + 2; j++)
                    matrica[j][i] = "  ";
            } else {
                if (matrica[brojOkvira + 1][i - 1] == "  ") {
                    matrica[2][i] = String.valueOf(nizReferenci[i]);
                    for (int k = 3; k < brojOkvira + 2; k++) {
                        matrica[k][i] = matrica[k - 1][i - 1];
                    }
                } else if (matrica[1][i] == "  ") {
                    for (int k = 2; k < brojOkvira + 2; k++) {
                        matrica[k][i] = matrica[k][i - 1];
                    }
                } else if (matrica[1][i] == "PF") {
                    Integer tempArr[] = new Integer[brojOkvira - 1];
                    int m = 0;
                    for (int k = i + 1; k < brojReferenci; k++) {
                        for (int j = 2; j < brojOkvira + 2; j++) {
                            if (nizReferenci[k] == Integer.parseInt(matrica[j][i - 1])) {
                                if (tempArr[brojOkvira - 2] != null) {
                                    continue;
                                } else {
                                    tempArr[m] = Integer.parseInt(matrica[j][i - 1]);
                                    m++;
                                }
                            }
                        }

                    }
                    if (tempArr[brojOkvira - 2] != null) {
                        for (int j = 2; j < brojOkvira + 2; j++) {
                            if (matrica[j][i - 1] != null && matrica[j][i - 1] != "  " && !Arrays.asList(tempArr).contains(Integer.parseInt(matrica[j][i - 1]))) {
                                if (nizReferenci[i] != 0)
                                    matrica[j][i] = String.valueOf(nizReferenci[i]);
                            } else if (matrica[j][i - 1] != null && matrica[j][i - 1] != "  " && Arrays.asList(tempArr).contains(Integer.parseInt(matrica[j][i - 1]))) {
                                matrica[j][i] = matrica[j][i - 1];
                            }
                        }
                    } else {
                        int k;
                        for (k = brojOkvira + 1; k >= 2; k--)
                            if (!Arrays.asList(tempArr).contains(Integer.parseInt(matrica[k][i - 1]))) {
                                matrica[k][i] = String.valueOf(nizReferenci[i]);
                                break;
                            }
                        for (int j = 2; j < brojOkvira + 2; j++) {
                            if (j == k) {
                                continue;
                            } else {
                                matrica[j][i] = matrica[j][i - 1];
                            }
                        }
                    }
                }
            }
        }
    }
}

