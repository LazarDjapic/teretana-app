package org.teretana.service;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.teretana.exception.ClanException;
import org.teretana.model.Clan;
import org.teretana.model.Clanarina;

import java.util.List;

@Dependent
public class ClanService {

  @Inject
  private EntityManager em;

  @Transactional
  public Clan createClan(Clan clan) throws ClanException {
      if(clan == null){
        throw new ClanException("Clan nije proslijedjen");
      }
      if(clan.getIme() == null || clan.getIme().isEmpty()){
        throw new ClanException("Ime je prazno");
      }
      if(clan.getPrezime() == null || clan.getPrezime().isEmpty()) {
        throw new ClanException("Prezime je prazno");
      }

      // Tačka 4 domaćeg: Povezivanje kolekcije članarina sa članom prije čuvanja
      if (clan.getClanarine() != null) {
          for (Clanarina c : clan.getClanarine()) {
              c.setClan(clan);
          }
      }

      // Povezivanje 1:1 relacije sa karticom
      if (clan.getKartica() != null) {
          clan.getKartica().setClan(clan);
      }

      return em.merge(clan);
  }

  @Transactional
  public List<Clan> getAllClanovi() throws ClanException {
    List<Clan> clanovi = em.createNamedQuery(Clan.GET_ALL_CLANOVI, Clan.class).getResultList();

    if(clanovi.isEmpty()){
      throw new ClanException("Nema clanova.");
    }
    return clanovi;
  }

  public List<Clan> getClanByIme(String name) {
    return em.createNamedQuery(Clan.GET_CLAN_BY_IME, Clan.class)
             .setParameter("imeC", name)
             .getResultList();
  }

  public List<Clanarina> getClanarineByClanId(Long id) {
    // Tačka 5 domaćeg: Korišćenje NamedQuery-ja za dobavljanje kolekcije po ID-u entiteta
    return em.createNamedQuery(Clanarina.GET_ALL_CLANARINE_FOR_CLAN_ID, Clanarina.class)
             .setParameter("id", id)
             .getResultList();
  }
}