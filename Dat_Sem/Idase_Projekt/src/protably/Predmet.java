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
public class Predmet {
    public int ID;
    public String nazev_Predmet;
    public String zkratka_Predmet;
   // public String zpusob_Vyuky_Predmet;
   // public int pocet_Hodin;
    public String vyucovany_Semestr;
    public String zakonceni;
    public int doporuceny_Rocnik;

    public void setNazev_Predmet(String nazev_Predmet) {
        this.nazev_Predmet = nazev_Predmet;
    }

    public void setZkratka_Predmet(String zkratka_Predmet) {
        this.zkratka_Predmet = zkratka_Predmet;
    }

    

    public void setVyucovany_Semestr(String vyucovany_Semestr) {
        this.vyucovany_Semestr = vyucovany_Semestr;
    }

    public void setZakonceni(String zakonceni) {
        this.zakonceni = zakonceni;
    }

    public void setDoporuceny_Rocnik(int doporuceny_Rocnik) {
        this.doporuceny_Rocnik = doporuceny_Rocnik;
    }

    public String getNazev_Predmet() {
        return nazev_Predmet;
    }

    public String getZkratka_Predmet() {
        return zkratka_Predmet;
    }

    

    public String getVyucovany_Semestr() {
        return vyucovany_Semestr;
    }

    public String getZakonceni() {
        return zakonceni;
    }

    public int getDoporuceny_Rocnik() {
        return doporuceny_Rocnik;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    public Predmet(int ID,String nazev_Predmet, String zkratka_Predmet, String vyucovany_Semestr, String zakonceni, int doporuceny_Rocnik) {
        this.ID = ID;
        this.nazev_Predmet = nazev_Predmet;
        this.zkratka_Predmet = zkratka_Predmet;
        //this.zpusob_Vyuky_Predmet = zpusob_Vyuky_Predmet;
        //this.pocet_Hodin = pocet_Hodin;
        this.vyucovany_Semestr = vyucovany_Semestr;
        this.zakonceni = zakonceni;
        this.doporuceny_Rocnik = doporuceny_Rocnik;
    }
}
