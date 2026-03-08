package org.teretana.model;

public class Termin {

    private int id;
    private String datum;
    private String vrijeme;
    private String sala;

    private ProgramTreninga programTreninga;

    public Termin() {
    }

    public Termin(int id, String datum, String vrijeme, String sala) {
        this.id = id;
        this.datum = datum;
        this.vrijeme = vrijeme;
        this.sala = sala;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public String getVrijeme() {
        return vrijeme;
    }

    public void setVrijeme(String vrijeme) {
        this.vrijeme = vrijeme;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public ProgramTreninga getProgramTreninga() {
        return programTreninga;
    }

    public void setProgramTreninga(ProgramTreninga programTreninga) {
        this.programTreninga = programTreninga;
    }
}
