package btc.com.hibernate.Beispiele;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Kunde")
public class KundeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Kundennummer")
    private int kundennummer;

    @Column(name = "Name")
    private String name;

    @Column(name = "Vorname")
    private String vorname;

    @Column(name = "Geburtstag")
    private String geburtstag;

    @Column(name = "Straße")
    private String strasse;

    @Column(name = "Hausnummer")
    private int hausnummer;

    @Column(name = "Hausnummerzusatz")
    private String hausnummerzusatz;

    @Column(name = "PLZ")
    private int plz;

    @Column(name = "Ort")
    private String ort;

    @Column(name = "Land")
    private String land;

    public int getKundennummer() {
        return kundennummer;
    }

    public String getName() {
        return name;
    }

    public String getVorname() {
        return vorname;
    }

    public String getGeburtsdatum() {
        return geburtstag;
    }

    public String getStrasse() {
        return strasse;
    }

    public int getHausnummer() {
        return hausnummer;
    }

    public String getHausnummerzusatz() {
        return hausnummerzusatz;
    }

    public int getPlz() {
        return plz;
    }

    public String getOrt() {
        return ort;
    }

    public String getLand() {
        return land;
    }

    public void setKundennummer(int kundennummer) {
        this.kundennummer = kundennummer;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public void setGeburtsdatum(String geburtsdatum) {
        this.geburtstag = geburtsdatum;
    }

    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    public void setHausnummer(int hausnummer) {
        this.hausnummer = hausnummer;
    }

    public void setHausnummerzusatz(String hausnummerzusatz) {
        this.hausnummerzusatz = hausnummerzusatz;
    }

    public void setPlz(int plz) {
        this.plz = plz;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public void setLand(String land) {
        this.land = land;
    }
}
