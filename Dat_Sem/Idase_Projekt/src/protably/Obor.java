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
public class Obor {
    public String zkratka_Obor;
    public int ID_OBOR;
    public String katedra_Obor;
    public int celkovy_Pocet_Studentu;
    public String forma_Vyuky;

    public Obor(int id_obor,String zkratka_Obor, String katedra_Obor, int celkovy_Pocet_Studentu, String forma_Vyuky) {
        this.ID_OBOR = id_obor;
        this.zkratka_Obor = zkratka_Obor;
        this.katedra_Obor = katedra_Obor;
        this.celkovy_Pocet_Studentu = celkovy_Pocet_Studentu;
        this.forma_Vyuky = forma_Vyuky;
    }

    public void setID_OBOR(int ID_OBOR) {
        this.ID_OBOR = ID_OBOR;
    }

    public int getID_OBOR() {
        return ID_OBOR;
    }

    public void setZkratka_Obor(String zkratka_Obor) {
        this.zkratka_Obor = zkratka_Obor;
    }

    public void setKatedra_Obor(String katedra_Obor) {
        this.katedra_Obor = katedra_Obor;
    }

    public void setCelkovy_Pocet_Studentu(int celkovy_Pocet_Studentu) {
        this.celkovy_Pocet_Studentu = celkovy_Pocet_Studentu;
    }

    public void setForma_Vyuky(String forma_Vyuky) {
        this.forma_Vyuky = forma_Vyuky;
    }

    public String getZkratka_Obor() {
        return zkratka_Obor;
    }

    public String getKatedra_Obor() {
        return katedra_Obor;
    }

    public int getCelkovy_Pocet_Studentu() {
        return celkovy_Pocet_Studentu;
    }

    public String getForma_Vyuky() {
        return forma_Vyuky;
    }
    
    
}
