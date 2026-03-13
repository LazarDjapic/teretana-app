package org.teretana.model;

import java.util.Objects;

public class Kartica {

    private Long id;
    private String brojKartice;
    private String datumIzdavanja;
    private Clan clan;

    public Kartica() {
    }

    public Kartica(Long id, String brojKartice, String datumIzdavanja) {
        this.id = id;
        this.brojKartice = brojKartice;
        this.datumIzdavanja = datumIzdavanja;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrojKartice() {
        return brojKartice;
    }

    public void setBrojKartice(String brojKartice) {
        this.brojKartice = brojKartice;
    }

    public String getDatumIzdavanja() {
        return datumIzdavanja;
    }

    public void setDatumIzdavanja(String datumIzdavanja) {
        this.datumIzdavanja = datumIzdavanja;
    }

    public Clan getClan() {
        return clan;
    }

    public void setClan(Clan clan) {
        this.clan = clan;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Kartica kartica = (Kartica) o;
        return Objects.equals(id, kartica.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}