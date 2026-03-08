package org.teretana.model;

import java.util.List;

public class ProgramTreninga {

    private int id;
    private String naziv;
    private String opis;
    private String nivoTezine;
    private int trajanjeUMinutama;

    private Trener trener;
    private List<Termin> termini;
    private List<Clan> clanovi;

    public ProgramTreninga() {
    }

    public ProgramTreninga(int id, String naziv, String opis, String nivoTezine, int trajanjeUMinutama) {
        this.id = id;
        this.naziv = naziv;
        this.opis = opis;
        this.nivoTezine = nivoTezine;
        this.trajanjeUMinutama = trajanjeUMinutama;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getNivoTezine() {
        return nivoTezine;
    }

    public void setNivoTezine(String nivoTezine) {
        this.nivoTezine = nivoTezine;
    }

    public int getTrajanjeUMinutama() {
        return trajanjeUMinutama;
    }

    public void setTrajanjeUMinutama(int trajanjeUMinutama) {
        this.trajanjeUMinutama = trajanjeUMinutama;
    }

    public Trener getTrener() {
        return trener;
    }

    public void setTrener(Trener trener) {
        this.trener = trener;
    }

    public List<Termin> getTermini() {
        return termini;
    }

    public void setTermini(List<Termin> termini) {
        this.termini = termini;
    }

    public List<Clan> getClanovi() {
        return clanovi;
    }

    public void setClanovi(List<Clan> clanovi) {
        this.clanovi = clanovi;
    }
}
