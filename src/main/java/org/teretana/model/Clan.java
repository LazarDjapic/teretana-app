package org.teretana.model;

import java.util.List;

public class Clan {

    private int id;
    private String ime;
    private String prezime;
    private String email;
    private String telefon;
    private String datumUclanjenja;

    private List<Clanarina> clanarine;
    private List<ProgramTreninga> programi;

    public Clan() {
    }

    public Clan(int id, String ime, String prezime, String email, String telefon, String datumUclanjenja) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.telefon = telefon;
        this.datumUclanjenja = datumUclanjenja;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getDatumUclanjenja() {
        return datumUclanjenja;
    }

    public void setDatumUclanjenja(String datumUclanjenja) {
        this.datumUclanjenja = datumUclanjenja;
    }

    public List<Clanarina> getClanarine() {
        return clanarine;
    }

    public void setClanarine(List<Clanarina> clanarine) {
        this.clanarine = clanarine;
    }

    public List<ProgramTreninga> getProgrami() {
        return programi;
    }

    public void setProgrami(List<ProgramTreninga> programi) {
        this.programi = programi;
    }
}