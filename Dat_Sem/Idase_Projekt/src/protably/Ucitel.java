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
public class Ucitel {
    public int true_ID_Ucitele;
    public String pracoviste_Ucitel;
    public String jmeno_Ucitel;
    public String prijmeni_Ucitel;
    public String titulPred;
    public String titulZa;
    public String telefon;
    public String mobil;
    public String email;

    public Ucitel(int true_ID_Ucitele,String pracoviste_Ucitel, String jmeno_Ucitel, String prijmeni_Ucitel, String titulPred, String titulZa, String telefon, String mobil, String email) {
        this.true_ID_Ucitele = true_ID_Ucitele;
        this.pracoviste_Ucitel = pracoviste_Ucitel;
        this.jmeno_Ucitel = jmeno_Ucitel;
        this.prijmeni_Ucitel = prijmeni_Ucitel;
        this.titulPred = titulPred;
        this.titulZa = titulZa;
        this.telefon = telefon;
        this.mobil = mobil;
        this.email = email;
    }
    public Ucitel(int true_ID_Ucitele,String pracoviste_Ucitel, String jmeno_Ucitel, String prijmeni_Ucitel, String titulPred, String titulZa, String telefon, String email) {
        this.true_ID_Ucitele = true_ID_Ucitele;
        this.pracoviste_Ucitel = pracoviste_Ucitel;
        this.jmeno_Ucitel = jmeno_Ucitel;
        this.prijmeni_Ucitel = prijmeni_Ucitel;
        this.titulPred = titulPred;
        this.titulZa = titulZa;
        this.telefon = telefon;
        this.mobil = "";
        this.email = email;
    }
    public Ucitel(int true_ID_Ucitele,String pracoviste_Ucitel, String jmeno_Ucitel, String prijmeni_Ucitel, String titulPred, String titulZa, String email) {
        this.true_ID_Ucitele = true_ID_Ucitele;
        this.pracoviste_Ucitel = pracoviste_Ucitel;
        this.jmeno_Ucitel = jmeno_Ucitel;
        this.prijmeni_Ucitel = prijmeni_Ucitel;
        this.titulPred = titulPred;
        this.titulZa = titulZa;
        this.telefon = "";
        this.mobil = "";
        this.email = email;
    }
    public Ucitel(int true_ID_Ucitele,String pracoviste_Ucitel, String jmeno_Ucitel, String prijmeni_Ucitel, String titulPred, String titulZa) {
        this.true_ID_Ucitele = true_ID_Ucitele;
        this.pracoviste_Ucitel = pracoviste_Ucitel;
        this.jmeno_Ucitel = jmeno_Ucitel;
        this.prijmeni_Ucitel = prijmeni_Ucitel;
        this.titulPred = titulPred;
        this.titulZa = titulZa;
        this.telefon = "";
        this.mobil = "";
        this.email = "";
    }
       public Ucitel(int true_ID_Ucitele,String pracoviste_Ucitel, String jmeno_Ucitel, String prijmeni_Ucitel, String titulPred) {
        this.true_ID_Ucitele = true_ID_Ucitele;
           this.pracoviste_Ucitel = pracoviste_Ucitel;
        this.jmeno_Ucitel = jmeno_Ucitel;
        this.prijmeni_Ucitel = prijmeni_Ucitel;
        this.titulPred = titulPred;
        this.titulZa = "";
        this.telefon = "";
        this.mobil = "";
        this.email = "";
    }
       public Ucitel(int true_ID_Ucitele,String pracoviste_Ucitel, String jmeno_Ucitel, String prijmeni_Ucitel) {
        this.true_ID_Ucitele = true_ID_Ucitele;
           this.pracoviste_Ucitel = pracoviste_Ucitel;
        this.jmeno_Ucitel = jmeno_Ucitel;
        this.prijmeni_Ucitel = prijmeni_Ucitel;
        this.titulPred = "";
        this.titulZa = "";
        this.telefon = "";
        this.mobil = "";
        this.email = "";
    }

    public int getTrue_ID_Ucitele() {
        return true_ID_Ucitele;
    }

    public void setTrue_ID_Ucitele(int true_ID_Ucitele) {
        this.true_ID_Ucitele = true_ID_Ucitele;
    }
    
    
    
    public String getPracoviste_Ucitel() {
        return pracoviste_Ucitel;
    }

    public String getJmeno_Ucitel() {
        return jmeno_Ucitel;
    }

    public String getPrijmeni_Ucitel() {
        return prijmeni_Ucitel;
    }

    public String getTitulPred() {
        return titulPred;
    }

    public String getTitulZa() {
        return titulZa;
    }

    public String getTelefon() {
        return telefon;
    }

    public String getMobil() {
        return mobil;
    }

    public String getEmail() {
        return email;
    }

    public void setPracoviste_Ucitel(String pracoviste_Ucitel) {
        this.pracoviste_Ucitel = pracoviste_Ucitel;
    }

    public void setJmeno_Ucitel(String jmeno_Ucitel) {
        this.jmeno_Ucitel = jmeno_Ucitel;
    }

    public void setPrijmeni_Ucitel(String prijmeni_Ucitel) {
        this.prijmeni_Ucitel = prijmeni_Ucitel;
    }

    public void setTitulPred(String titulPred) {
        this.titulPred = titulPred;
    }

    public void setTitulZa(String titulZa) {
        this.titulZa = titulZa;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public void setMobil(String mobil) {
        this.mobil = mobil;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
