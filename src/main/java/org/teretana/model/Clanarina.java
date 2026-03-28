package org.teretana.model;
import jakarta.persistence.*;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@NamedQuery(name = Clanarina.GET_ALL_CLANARINE_FOR_CLAN_ID, query = "Select c from Clanarina c where c.clan.id = :id")
public class Clanarina {

    public static final String GET_ALL_CLANARINE_FOR_CLAN_ID = "GetAllClanarineForClanId";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "clanarina_seq")
    @SequenceGenerator(name = "clanarina_seq", sequenceName = "clanarina_seq", allocationSize = 1)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clan_id")
    @JsonIgnore
    private Clan clan;

    private double iznos;
    private String datumUplate;
    private String datumIsteka;
    private String tipClanarine;

    public Clanarina() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Clan getClan() {
        return clan;
    }

    public void setClan(Clan clan) {
        this.clan = clan;
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

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Clanarina clanarina)) return false;
        return Objects.equals(id, clanarina.id) && Double.compare(iznos, clanarina.iznos) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, iznos);
    }

    @Override
    public String toString() {
        return "Clanarina{" +
                "id=" + id +
                ", iznos=" + iznos +
                ", tip='" + tipClanarine + '\'' +
                '}';
    }
}