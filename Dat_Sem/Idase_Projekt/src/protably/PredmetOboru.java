/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package protably;

import java.util.logging.Logger;

/**
 *
 * @author Vojta
 */
public class PredmetOboru {
    public String kategorie;
    public String zkratkaPredmetuOboru;

    public String getKategorie() {
        return kategorie;
    }

    public String getZkratkaPredmetuOboru() {
        return zkratkaPredmetuOboru;
    }

    public void setKategorie(String kategorie) {
        this.kategorie = kategorie;
    }

    public void setZkratkaPredmetuOboru(String zkratkaPredmetuOboru) {
        this.zkratkaPredmetuOboru = zkratkaPredmetuOboru;
    }
    

    public PredmetOboru(String kategorie, String zkratkaPredmetuOboru) {
        this.kategorie = kategorie;
        this.zkratkaPredmetuOboru = zkratkaPredmetuOboru;
    }
}
