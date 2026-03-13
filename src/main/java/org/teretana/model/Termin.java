package org.teretana.model;

import java.util.Objects;

public class Termin {

    private Long id;
    private String datum;
    private String vrijeme;
    private String sala;

    private ProgramTreninga programTreninga;

    public Termin() {
    }

    public Termin(Long id, String datum, String vrijeme, String sala) {
        this.id = id;
        this.datum = datum;
        this.vrijeme = vrijeme;
        this.sala = sala;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Termin termin = (Termin) o;
        return Objects.equals(id, termin.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}