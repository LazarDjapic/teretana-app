package org.teretana.model;

public class Clanarina {

    private int id;
    private double iznos;
    private String datumUplate;
    private String datumIsteka;
    private String tipClanarine;

    private Clan clan;

    public Clanarina() {
    }

    public Clanarina(int id, double iznos, String datumUplate, String datumIsteka, String tipClanarine) {
        this.id = id;
        this.iznos = iznos;
        this.datumUplate = datumUplate;
        this.datumIsteka = datumIsteka;
        this.tipClanarine = tipClanarine;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getIznos() {
        return iznos;
    }

    public void setIznos(double iznos) {
        this.iznos = iznos;
    }

    public String getDatumUplate() {
        return datumUplate;
    }

    public void setDatumUplate(String datumUplate) {
        this.datumUplate = datumUplate;
    }

    public String getDatumIsteka() {
        return datumIsteka;
    }

    public void setDatumIsteka(String datumIsteka) {
        this.datumIsteka = datumIsteka;
    }

    public String getTipClanarine() {
        return tipClanarine;
    }

    public void setTipClanarine(String tipClanarine) {
        this.tipClanarine = tipClanarine;
    }

    public Clan getClan() {
        return clan;
    }

    public void setClan(Clan clan) {
        this.clan = clan;
    }
}
