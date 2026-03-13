package org.teretana.model;

import java.util.List;
import java.util.Objects;

public class Trener {

    private Long id;
    private String ime;
    private String prezime;
    private String specijalizacija;
    private String email;
    private String telefon;

    private List<ProgramTreninga> programi;

    public Trener() {
    }

    public Trener(Long id, String ime, String prezime, String specijalizacija, String email, String telefon) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.specijalizacija = specijalizacija;
        this.email = email;
        this.telefon = telefon;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trener trener = (Trener) o;
        return Objects.equals(id, trener.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
    return "Trener{" +
            "id=" + id +
            ", ime='" + ime + '\'' +
            ", prezime='" + prezime + '\'' +
            ", specijalizacija='" + specijalizacija + '\'' +
            '}';
    }
}