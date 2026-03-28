package org.teretana.model;

import jakarta.persistence.*;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@NamedQuery(name = Kartica.GET_KARTICA_BY_BROJ, query = "Select k from Kartica k where k.brojKartice = :brojK")
public class Kartica {

    public static final String GET_KARTICA_BY_BROJ = "GetKarticaByBroj";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "kartica_seq")
    @SequenceGenerator(name = "kartica_seq", sequenceName = "kartica_seq", allocationSize = 1)
    private Long id;

    private String brojKartice;
    private String datumIzdavanja;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clan_id")
    @JsonIgnore
    private Clan clan;

    public Kartica() {
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
        if (!(o instanceof Kartica kartica)) return false;
        return Objects.equals(id, kartica.id) && Objects.equals(brojKartice, kartica.brojKartice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, brojKartice);
    }

    @Override
    public String toString() {
        return "Kartica{" +
                "id=" + id +
                ", brojKartice='" + brojKartice + '\'' +
                '}';
    }
}