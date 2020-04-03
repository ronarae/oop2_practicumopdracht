package practicumopdracht.models;

import javafx.collections.ObservableList;

import java.time.LocalDate;

public class Contact {

   private String naam;
   private LocalDate geboortedatum;
   private String email;
   private String straat;
   private int huisnummer;
   private String postcode;
   private String woonplaats;
   private double rating; //hoe vak bel ik de persoon
   private boolean emergencyContacten;
   private Groep hoortbij; // groep hoort bij contact
   private int id;
   private int masterId;


   public Contact(String naam, LocalDate geboortedatum, String email, String straat, int huisnummer,
                  String postcode, String woonplaats, double rating, boolean emergencyContacten, Groep hoortbij, int id, int masterId) {
      this.naam = naam;
      this.geboortedatum = geboortedatum;
      this.email = email;
      this.straat = straat;
      this.huisnummer = huisnummer;
      this.postcode = postcode;
      this.woonplaats = woonplaats;
      this.rating = rating;
      this.emergencyContacten = emergencyContacten;
      this.hoortbij = hoortbij;
      this.id = id;
      this.masterId = masterId;
   }

   public Contact(String naam, LocalDate geboortedatum, String email, String straat, int huisnummer, String postcode, String woonplaats, double rating, int id, int masterId) {
      this.naam = naam;
      this.geboortedatum = geboortedatum;
      this.email = email;
      this.straat = straat;
      this.huisnummer = huisnummer;
      this.postcode = postcode;
      this.woonplaats = woonplaats;
      this.rating = rating;
      this.id = id;
      this.masterId = masterId;
   }

   public Contact(String naam, String email,LocalDate geboortedatum) {
      this.naam = naam;
      this.email = email;
      this.geboortedatum = geboortedatum;
   }

   public String getNaam() {
      return naam;
   }

   public void setNaam(String naam) {
      this.naam = naam;
   }

   public LocalDate getGeboortedatum() {
      return geboortedatum;
   }

   public void setGeboortedatum(LocalDate geboortedatum) {
      this.geboortedatum = geboortedatum;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public String getStraat() {
      return straat;
   }

   public void setStraat(String straat) {
      this.straat = straat;
   }

   public int getHuisnummer() {
      return huisnummer;
   }

   public void setHuisnummer(int huisnummer) {
      this.huisnummer = huisnummer;
   }

   public String getPostcode() {
      return postcode;
   }

   public void setPostcode(String postcode) {
      this.postcode = postcode;
   }

   public String getWoonplaats() {
      return woonplaats;
   }

   public void setWoonplaats(String woonplaats) {
      this.woonplaats = woonplaats;
   }

   public double getRating() {
      return rating;
   }

   public void setRating(double rating) {
      this.rating = rating;
   }

   public boolean isEmergencyContacten() {
      return emergencyContacten;
   }

   public void setEmergencyContacten(boolean emergencyContacten) {
      this.emergencyContacten = emergencyContacten;
   }

   public Groep getHoortbij() {
      return hoortbij;
   }

   public void setHoortbij(Groep hoortbij) {
      this.hoortbij = hoortbij;
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public int getMasterId() {
      return masterId;
   }

   public String convertToString() {
      return naam + email + geboortedatum + straat + huisnummer + postcode + woonplaats;
   }

   @Override
   public String toString() {
      return "Naam: " + naam + "\nEmail: " + email + "\nGeboortedatum: " + geboortedatum +
              "\nStraat: " + straat + "\nHuisnummer: " + huisnummer + "\nPostcode: " + postcode
              + "\nWoonplaats: " + woonplaats;
   }
}
