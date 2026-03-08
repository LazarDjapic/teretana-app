package org.teretana.model;

import java.util.List;

public class Trener {

    private int id;
    private String ime;
    private String prezime;
    private String specijalizacija;
    private String email;
    private String telefon;

    private List<ProgramTreninga> programi;

    public Trener() {
    }

    public Trener(int id, String ime, String prezime, String specijalizacija, String email, String telefon) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.specijalizacija = specijalizacija;
        this.email = email;
        this.telefon = telefon;
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

    public String getSpecijalizacija() {
        return specijalizacija;
    }

    public void setSpecijalizacija(String specijalizacija) {
        this.specijalizacija = specijalizacija;
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

    public List<ProgramTreninga> getProgrami() {
        return programi;
    }

    public void setProgrami(List<ProgramTreninga> programi) {
        this.programi = programi;
    }
}
