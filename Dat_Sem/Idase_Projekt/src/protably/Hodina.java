/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package protably;

/**
 *
 * @author Vojta
 */
public class Hodina {
    public String jmeno_Hodina;
    public String prijmeni_Hodina;
    public int id_Uc_Hodina;
    public int id_Hodina;
    public int odCas;
    public int doCas;
    public int celkemCas;
    public String typ_Akce;

    public void setJmeno_Hodina(String jmeno_Hodina) {
        this.jmeno_Hodina = jmeno_Hodina;
    }

    public void setPrijmeni_Hodina(String prijmeni_Hodina) {
        this.prijmeni_Hodina = prijmeni_Hodina;
    }

    public void setId_Uc_Hodina(int id_Uc_Hodina) {
        this.id_Uc_Hodina = id_Uc_Hodina;
    }

    public void setId_Hodina(int id_Hodina) {
        this.id_Hodina = id_Hodina;
    }

    public void setOdCas(int odCas) {
        this.odCas = odCas;
    }

    public void setDoCas(int doCas) {
        this.doCas = doCas;
    }

    public void setCelkemCas(int celkemCas) {
        this.celkemCas = celkemCas;
    }

    public void setTyp_Akce(String typ_Akce) {
        this.typ_Akce = typ_Akce;
    }

    public String getJmeno_Hodina() {
        return jmeno_Hodina;
    }

    public String getPrijmeni_Hodina() {
        return prijmeni_Hodina;
    }

    public int getId_Uc_Hodina() {
        return id_Uc_Hodina;
    }

    public int getId_Hodina() {
        return id_Hodina;
    }

    public int getOdCas() {
        return odCas;
    }

    public int getDoCas() {
        return doCas;
    }

    public int getCelkemCas() {
        return celkemCas;
    }

    public String getTyp_Akce() {
        return typ_Akce;
    }

    public Hodina(String jmeno_Hodina, String prijmeni_Hodina, int id_Uc_Hodina, int id_Hodina, int odCas, int doCas, int celkemCas, String typ_Akce) {
        this.jmeno_Hodina = jmeno_Hodina;
        this.prijmeni_Hodina = prijmeni_Hodina;
        this.id_Uc_Hodina = id_Uc_Hodina;
        this.id_Hodina = id_Hodina;
        this.odCas = odCas;
        this.doCas = doCas;
        this.celkemCas = celkemCas;
        this.typ_Akce = typ_Akce;
    }
    
}
