package org.teretana.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Objects;

@Entity
public class TimeZoneLog {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "time_seq")
    @SequenceGenerator(name = "time_seq", sequenceName = "time_seq", allocationSize = 1)
    private Long id;

    private String ipAddress;
    private String timeZone;
    private String currentDateTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clan_id")
    @JsonIgnore
    private Clan clan;

   
    public TimeZoneLog() {
    }

    public TimeZoneLog(String ipAddress, String timeZone, String currentDateTime, Clan clan) {
        this.ipAddress = ipAddress;
        this.timeZone = timeZone;
        this.currentDateTime = currentDateTime;
        this.clan = clan;
    }

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public String getCurrentDateTime() {
        return currentDateTime;
    }

    public void setCurrentDateTime(String currentDateTime) {
        this.currentDateTime = currentDateTime;
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
        TimeZoneLog that = (TimeZoneLog) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

  
    @Override
    public String toString() {
        return "TimeZoneLog{" +
                "id=" + id +
                ", ipAddress='" + ipAddress + '\'' +
                ", timeZone='" + timeZone + '\'' +
                ", currentDateTime='" + currentDateTime + '\'' +
                '}';
    }
}