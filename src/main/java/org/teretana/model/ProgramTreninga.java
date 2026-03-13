package org.teretana.model;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ProgramTreninga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String naziv;
    private String opis;
    private String nivoTezine;
    private int trajanjeUMinutama;

    //zakomentarisano dok ne dodjemo do relacija
    /* 
    private List<Trener> treneri;
    private List<Termin> termini;
    private List<Clan> clanovi;
    */

    public ProgramTreninga() {
    }

    public ProgramTreninga(Long id, String naziv, String opis, String nivoTezine, int trajanjeUMinutama) {
        this.id = id;
        this.naziv = naziv;
        this.opis = opis;
        this.nivoTezine = nivoTezine;
        this.trajanjeUMinutama = trajanjeUMinutama;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    /* 
    public List<Trener> getTreneri() {
        return treneri;
    }

    public void setTreneri(List<Trener> treneri) {
        this.treneri = treneri;
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
    */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProgramTreninga that = (ProgramTreninga) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
    return "ProgramTreninga{" +
            "id=" + id +
            ", naziv='" + naziv + '\'' +
            ", nivoTezine='" + nivoTezine + '\'' +
            ", trajanjeUMinutama=" + trajanjeUMinutama +
            '}';
    }
}