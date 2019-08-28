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
public class PracovisteVsech {
    public int FakID;
    public int KatID;
    public String fakulta_pracoviste;
    public String fakulta_zkratka_pracoviste;
    public String katedra_pracoviste;
    public String katedra_zkratka_pracoviste;

    public PracovisteVsech(int FakID, int KatID, String fakulta_pracoviste, String fakulta_zkratka_pracoviste, String katedra_pracoviste, String katedra_zkratka_pracoviste) {
        this.FakID = FakID;
        this.KatID = KatID;
        this.fakulta_pracoviste = fakulta_pracoviste;
        this.fakulta_zkratka_pracoviste = fakulta_zkratka_pracoviste;
        this.katedra_pracoviste = katedra_pracoviste;
        this.katedra_zkratka_pracoviste = katedra_zkratka_pracoviste;
    }

    public int getFakID() {
        return FakID;
    }

    public int getKatID() {
        return KatID;
    }

    public String getFakulta_pracoviste() {
        return fakulta_pracoviste;
    }

    public String getFakulta_zkratka_pracoviste() {
        return fakulta_zkratka_pracoviste;
    }

    public String getKatedra_pracoviste() {
        return katedra_pracoviste;
    }

    public String getKatedra_zkratka_pracoviste() {
        return katedra_zkratka_pracoviste;
    }

    public void setFakID(int FakID) {
        this.FakID = FakID;
    }

    public void setKatID(int KatID) {
        this.KatID = KatID;
    }

    public void setFakulta_pracoviste(String fakulta_pracoviste) {
        this.fakulta_pracoviste = fakulta_pracoviste;
    }

    public void setFakulta_zkratka_pracoviste(String fakulta_zkratka_pracoviste) {
        this.fakulta_zkratka_pracoviste = fakulta_zkratka_pracoviste;
    }

    public void setKatedra_pracoviste(String katedra_pracoviste) {
        this.katedra_pracoviste = katedra_pracoviste;
    }

    public void setKatedra_zkratka_pracoviste(String katedra_zkratka_pracoviste) {
        this.katedra_zkratka_pracoviste = katedra_zkratka_pracoviste;
    }

   
}
