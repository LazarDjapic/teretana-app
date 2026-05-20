package org.teretana.service;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.teretana.exception.ClanException;
import org.teretana.model.Clan;
import org.teretana.model.Clanarina;
import org.teretana.model.UploadedFile;
import org.jboss.resteasy.reactive.multipart.FileUpload;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Dependent
public class ClanService {

  @Inject
  private EntityManager em;

  public record ClanFileUploadResult(UploadedFile uploadedFile, boolean alreadyExisted) {
  }

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

      //Povezivanje kolekcije članarina sa članom prije čuvanja
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

  public Clan findById(Long id) {
    return em.find(Clan.class, id);
  }

  @Transactional
  public void updateClan(Clan clan) {
      em.merge(clan);
  }

  @Transactional
  public ClanFileUploadResult uploadFileForClan(Long clanId, String filename, FileUpload fileUpload) throws ClanException, IOException {
      if (clanId == null) {
        throw new ClanException("ID clana nije proslijedjen");
      }
      if (fileUpload == null || fileUpload.uploadedFile() == null) {
        throw new ClanException("Fajl nije proslijedjen");
      }

      Clan clan = findById(clanId);
      if (clan == null) {
        throw new ClanException("Clan sa ID " + clanId + " nije pronadjen");
      }

      String requestedFilename = filename;
      if (requestedFilename == null || requestedFilename.isBlank()) {
        requestedFilename = fileUpload.fileName();
      }
      if (requestedFilename == null || requestedFilename.isBlank()) {
        throw new ClanException("Ime fajla nije proslijedjeno");
      }

      String cleanFilename = Paths.get(requestedFilename).getFileName().toString();
      Path uploadDir = Paths.get("uploads", "clanovi").toAbsolutePath().normalize();
      Files.createDirectories(uploadDir);

      Path targetPath = uploadDir.resolve(cleanFilename).normalize();
      if (!targetPath.startsWith(uploadDir)) {
        throw new ClanException("Ime fajla nije validno");
      }

      boolean fileAlreadyExisted = Files.exists(targetPath);
      if (!fileAlreadyExisted) {
        Files.copy(fileUpload.uploadedFile(), targetPath, StandardCopyOption.REPLACE_EXISTING);
      }

      String storedPath = targetPath.toString();
      Optional<UploadedFile> existingUploadedFile = em
              .createQuery("select u from UploadedFile u where u.filename = :filename", UploadedFile.class)
              .setParameter("filename", storedPath)
              .getResultStream()
              .findFirst();

      UploadedFile uploadedFile = existingUploadedFile.orElseGet(() -> {
        UploadedFile newUploadedFile = new UploadedFile(storedPath, targetPath.toFile());
        em.persist(newUploadedFile);
        return newUploadedFile;
      });
      uploadedFile.setFile(targetPath.toFile());

      if (clan.getUploadedFiles() == null) {
        clan.setUploadedFiles(new ArrayList<>());
      }
      if (!clan.getUploadedFiles().contains(uploadedFile)) {
        clan.getUploadedFiles().add(uploadedFile);
      }

      em.merge(clan);
      return new ClanFileUploadResult(uploadedFile, fileAlreadyExisted || existingUploadedFile.isPresent());
  }

  public List<Clan> getClanByIme(String name) {
    return em.createNamedQuery(Clan.GET_CLAN_BY_IME, Clan.class)
             .setParameter("imeC", name)
             .getResultList();
  }

  public List<Clanarina> getClanarineByClanId(Long id) {
    //Korišćenje NamedQuery-ja za dobavljanje kolekcije po ID-u entiteta
    return em.createNamedQuery(Clanarina.GET_ALL_CLANARINE_FOR_CLAN_ID, Clanarina.class)
             .setParameter("id", id)
             .getResultList();
  }
}
